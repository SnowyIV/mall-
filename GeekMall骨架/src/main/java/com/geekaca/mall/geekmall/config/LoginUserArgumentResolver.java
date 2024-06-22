package com.geekaca.mall.geekmall.config;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.geekmall.domain.MallAdminUser;
import com.geekaca.mall.geekmall.utils.JwtUtil;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 描述 支持哪种类型的参数
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //拿到参数类型
        Class<?> clazz = parameter.getParameterType();
        //管理员实体类
        return clazz == MallAdminUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        String token = request.getHeader("Token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        String uid = stringClaimMap.get("id").asString();
        String uname = stringClaimMap.get("userName").asString();
        MallAdminUser mallAdminUser = new MallAdminUser();
        mallAdminUser.setAdminUserId(Long.valueOf(uid));
        mallAdminUser.setLoginUserName(uname);
        return mallAdminUser;
    }
}
