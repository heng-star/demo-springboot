package com.heng.config;

import com.heng.component.LoginHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@Slf4j
//@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }
//


    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    //新版本WebMvcConfigurerAdapter类被弃
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源； *.css , *.js
                // SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new
                        LoginHandler()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/user/login","/static/asserts/**","/webjars/**");
            }


        };

        return adapter;
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    //@Bean //将组件注册在容器

//    //@Bean
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/index.html").setViewName("login");
//
//    }








}