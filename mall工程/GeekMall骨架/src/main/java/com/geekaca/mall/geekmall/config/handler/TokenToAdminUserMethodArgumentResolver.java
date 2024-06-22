//
//package com.geekaca.mall.geekmall.config.handler;
//
//import com.auth0.jwt.interfaces.Claim;
//import com.geekaca.mall.geekmall.common.ServiceResultEnum;
//import com.geekaca.mall.geekmall.config.annotation.TokenToAdminUser;
//import com.geekaca.mall.geekmall.domain.AdminUserToken;
//import com.geekaca.mall.geekmall.exceptions.MallException;
//import com.geekaca.mall.geekmall.utils.JwtUtil;
//import org.springframework.core.MethodParameter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
//import java.util.Map;
///**
// * HandlerMethodArgumentResolver
// * 对方法参数进行处理
// */
//@Component
//public class TokenToAdminUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
//
//
//
//    public TokenToAdminUserMethodArgumentResolver() {
//    }
//    //描述 支持哪种类型的参数
//    public boolean supportsParameter(MethodParameter parameter) {
//        //你的这个函数参数如果加了  @TokenToAdminUser 注解，那么就归我管
//        if (parameter.hasParameterAnnotation(TokenToAdminUser.class)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 捕获到 带有  @TokenToAdminUser 注解的方法
//     * 自动的从http header中获取token 值，然后提取用户id
//     * 构造  AdminUserToken  然后传递给  当前处理的方法
//     * @param parameter
//     * @param mavContainer
//     * @param webRequest
//     * @param binderFactory
//     * @return
//     */
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
//        if (parameter.getParameterAnnotation(TokenToAdminUser.class) instanceof TokenToAdminUser) {
//            //获取http 请求提交的header信息  ，从中拿出来 token
//            String token = webRequest.getHeader("token");
//            if (null != token && !"".equals(token) ) {
//                //从token中提取信息
//                Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
//                if (stringClaimMap == null) {
//                    MallException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
//                }
//                AdminUserToken adminUserToken = new AdminUserToken();
//                adminUserToken.setToken(token);
//                Claim idClaim = stringClaimMap.get("id");
//                String idStr = idClaim.asString();
//                if (idStr != null) {
//                    adminUserToken.setAdminUserId(Long.valueOf(idStr));
//                }
//                return adminUserToken;
//            } else {
//                MallException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
//            }
//        }
//        return null;
//    }
//
//}
