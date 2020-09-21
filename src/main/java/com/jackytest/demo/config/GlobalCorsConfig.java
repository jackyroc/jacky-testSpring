package com.jackytest.demo.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * 跨域配置
 * @author JackyRoc
 * @date 2020/9/19 18:57
 */
@Configuration
public class GlobalCorsConfig {
    /**
     * 跨域过滤器
     * @return
     */
//    @Bean
//    public CorsFilter corsFilter() {
//
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);//允许cookie跨域
//        config.addAllowedOrigin("*");//允许请求的URI
//        config.addAllowedHeader("*");//允许访问的头信息
//        config.setMaxAge(18000L);//允许请求的缓存时间
//        config.addAllowedMethod("OPTIONS");//允许请求提交的方法
//        config.addAllowedMethod("HEAD");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("DELETE");
//        config.addAllowedMethod("PATH");
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",config);
//        return new CorsFilter(source);
//    }

}
