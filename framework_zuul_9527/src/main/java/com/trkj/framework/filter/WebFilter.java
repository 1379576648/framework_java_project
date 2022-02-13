//package com.trkj.framework.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import com.trkj.framework.util.JwtTokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Configuration
///***
// * 网关拦截
// */
//public class WebFilter extends ZuulFilter {
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//    @Override
//    public String filterType() {
//        //在微服务网关进行转发之前j进行过滤
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        //数字越大,优先执行越低,0为最先执行
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        //如果是登录请求,不使用过滤器
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//        if (request.getRequestURI().indexOf("/register")==-1&&request.getRequestURI().indexOf("/login")==-1){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//
//        //前台网管需要吧用户的身份信息token转发给具体的微服务进行验证
//        //而使用网关时是获取不到消息头的
//        //需要在这个过滤器中,拿到用户信息
//        RequestContext ctx = RequestContext.getCurrentContext();
//        //获取用户原来的请求
//        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//        /** Token 验证 */
//        String token = request.getHeader(jwtTokenUtil.getHeader());
//        if(token==null){
//            token = request.getParameter(jwtTokenUtil.getHeader());
//        }
//        System.out.println(request.getHeader("Authorization"));
//        if(token==null){
//            token = request.getHeader("Authorization");
//        }
//        if(token==null){
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(888);
//            return 888;
//        }
////        if(jwtTokenUtil.isTokenExpired(token)) {
////            ctx.setSendZuulResponse(false);
////            ctx.setResponseStatusCode(999);
////            return null;
////        }
//        return null;
//    }
//}
