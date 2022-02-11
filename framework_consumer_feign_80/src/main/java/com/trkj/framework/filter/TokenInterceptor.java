package com.trkj.framework.filter;





import com.trkj.framework.util.JwtTokenUtil;

import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 13795
 */
@Slf4j
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    /***
     * 在方法被调用前执行。在该方法中可以做类似校验的功能。如果返回true，则继续调用下一个拦截器。
     * 如果返回false，则中断执行，也就是说我们想调用的方法 不会被执行，但是你可以修改response为你想要的响应。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /** 地址过滤 */
        String uri = request.getRequestURI() ;
        System.out.println(uri);
        if (uri.contains("/register") || uri.contains("/login")){
            return true ;
        }
        /** Token 验证 */
        String token = request.getHeader(jwtTokenUtil.getHeader());
        if(token==null){
            token = request.getParameter(jwtTokenUtil.getHeader());
        }
        if(token==null){
            try {
                token = request.getHeader("Authorization").split(" ")[1];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new SignatureException("未登录，请先登录");
            }
        }
        if(jwtTokenUtil.isTokenExpired(token)) {
            throw new SignatureException("登录失效，请重新登录");
        }
        return true;
    }

    /***
     * 在方法执行后调用。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("进入到拦截器中:postHandle() 方法中");
        System.out.println(request.getRequestURI());
    }

    /***
     * 在整个请求处理完毕后进行回调，也就是说视图渲染完毕或者调用方已经拿到响应。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("进入到拦截器中:afterCompletion() 方法中");
        System.out.println(request.getServletPath());
    }
}