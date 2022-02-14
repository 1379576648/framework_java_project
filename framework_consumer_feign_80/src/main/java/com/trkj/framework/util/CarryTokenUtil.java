package com.trkj.framework.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 13795
 * 携带token传前台
 */
@Component
public class CarryTokenUtil {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    public Map<String,Object> main(Map<String,Object> map){
        try {
            if (map.get("state").equals(200)){
                //获取HttpServletRequest对象
                RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
                HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
                //刷新令牌
                String token= jwtTokenUtil.refreshToken(request.getHeader("Authorization").split(" ")[1] );
                map.put("token", token );
            }
        }catch (Exception e){
            return map;
        }
        return map;
    }
}
