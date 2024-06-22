package com.geekaca.mall.geekmall.config;
import com.geekaca.mall.geekmall.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


//
//import com.geekaca.mall.geekmall.config.handler.TokenToAdminUserMethodArgumentResolver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.List;
@Configuration
public class MallWebMvcConfig extends WebMvcConfigurationSupport {
    @Autowired
    private TokenInterceptor tokenInterceptor;
//    @Autowired
//    private TokenToAdminUserMethodArgumentResolver adminUserMethodArgumentResolver;
//    //Cors 跨域
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        //任意请求路径                          允许来自任何域名的访问
        registry.addMapping("/**").allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
    //重写父类的方法，增加拦截器的配置

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        //针对哪些访问路径 设置拦截器   ，后端接口地址一定不要和前端页面的地址冲突
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/manage-api/**")
//        .addPathPatterns("/api/**")
//                //放行 后台的登陆
//                .excludePathPatterns("/manage-api/v1/adminUser/login")
//                //放行前台的注册和登陆
//        .excludePathPatterns("/api/v1/user/register")
//        .excludePathPatterns("/api/v1/user/login")
//        .excludePathPatterns("/manage-api/v1/upload/**");
//
//    }

//
//    @Override
//    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(adminUserMethodArgumentResolver);
//    }
    //配置 资源访问 路径
    //http://localhost:28019/goods-img/a2afdb6c-69a7-4081-bd09-62174f9f5624.jpg
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
        //                            来自前端的地址请求             java springboot会到 这个路径下去寻找文件返回
        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);

        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }


}
