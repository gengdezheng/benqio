package com.java.news.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author:gengdz
 * @date:2019/11/23
 * @desc:
 */
@Configuration
@Slf4j
public class ResourceConfig extends WebMvcConfigurerAdapter {

    @Value("${Img.uploadFolder}")
    String path;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info(path);
     registry.addResourceHandler("/img/**").addResourceLocations("file:"+path);
     super.addResourceHandlers(registry);
    }
}
