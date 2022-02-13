package com.trkj.framework.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:JWT工具类。
 * @version 1.0
 */
@Slf4j
@Data
/***
 * @ConfigurationProperties
 * 通过配置文件注入属性值
 */
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtTokenUtil {

    private String secret;
    private Long expire;
    private String header;

    /**
     * 生成token令牌
     *
     * @param userName 用户
     * @return 令token牌
     */
    public String generateToken(String userName,Integer userId,String postName) {
        //初始化集合大小
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", "jwt");
        //用户名称
        claims.put("name",userName);
        //职位名称
        claims.put("postName",postName);
        //用户ID
        claims.put("id",userId);
        //生成创建时间
        Date iatDate=new Date();
        claims.put("iat", iatDate);
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            //获取令牌的数据
            Claims claims = getClaimsFromToken(token);
            //获取用户名称
            username = claims.get("name").toString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 从令牌中获取职位名称
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUserPostNameFromToken(String token) {
        String postName;
        try {
            //获取令牌的数据
            Claims claims = getClaimsFromToken(token);
            //获取职位名称
            postName = claims.get("postName").toString();
        } catch (Exception e) {
            postName = null;
        }
        return postName;
    }

    /**
     * 从令牌中获取用户ID
     *
     * @param token 令牌
     * @return 用户编号
     */
    public String getUserIdFromToken(String token) {
        String userId;
        try {
            //获取令牌数据
            Claims claims = getClaimsFromToken(token);
            //获取用户ID
            userId = claims.get("id").toString();
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            //获取令牌数据
            Claims claims = getClaimsFromToken(token);
            //获取过期时间
            Date expiration = claims.getExpiration();
            System.out.println(expiration.toLocaleString());
            log.info("过期时间为{}",expiration.toLocaleString());
            Date date=new Date();
            System.out.println("现在时间:{},过期时间:{} ,{}"+date.toLocaleString()+expiration.toLocaleString()+expiration.before(date));
            log.info("现在时间:{},过期时间:{} ,{}",date.toLocaleString(),expiration.toLocaleString(),expiration.before(date));
            //返回是否过期
            return expiration.before(date);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * 得到token的过期时间，测试用
     * @param token
     * @return
     */
    public Date  expirationDate(String token){
        //获取令牌数据
        Claims claims = getClaimsFromToken(token);
        //获取令牌过期时间
        Date expiration = claims.getExpiration();
        return expiration;
    }

    /**
     * 刷新令牌
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            //获取令牌数据
            Claims claims = getClaimsFromToken(token);
            //初始化创建时间
            Date iatDate=new Date();
            claims.put("iat", iatDate);
            //生成令牌
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            e.printStackTrace();
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userName 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, String userName) {
        //获取令牌里面的用户名
        String name = getUsernameFromToken(token);
        //判断令牌里面的用户名是否一致 以及令牌是否过期
        return (name.equals(userName) && !isTokenExpired(token));
    }

    /**
     * 从claims生成令牌
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        //获取令牌过期时间
        Date expirationDate = new Date(System.currentTimeMillis() + expire);
        /**
         * signWith() 签名方法。两个参数分别是签名算法和自定义的签名Key（盐）。
         * 签名key可以byte[] 、String及Key的形式传入。
         * 前两种形式均存入builder的keyBytes属性，后一种形式存入builder的key属性。
         * 如果是第二种（及String类型）的key，则将其进行base64解码获得byte[] 。
         * compact() 生成JWT
         */
        //获取创建令牌时间
        Date iatDate= (Date) claims.get("iat");
        log.debug("创建时间:{},过期时间:{}",iatDate.toLocaleString(),expirationDate.toLocaleString());
        return Jwts.builder()
                //header
                //类型
                .setHeaderParam("typ", "JWT")
                //加密方式
                .setHeaderParam("alg","HS256")
                //payload
                //数据
                .setClaims(claims)
                //ID
                .setId(UUID.randomUUID().toString())
                //过期时间
                .setExpiration(expirationDate)
                //signature
                //签名信息
                .signWith(SignatureAlgorithm.HS256, secret)
                //拼接字符串
                .compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        //获取数据令牌里面的数据，返回数据结果
        Claims claims;
        try {
            claims = Jwts.parser()
                    //通过签名信息进行取令牌数据
                    .setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            claims = null;
        }
        return claims;
    }

}
