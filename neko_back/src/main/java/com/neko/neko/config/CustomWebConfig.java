package com.neko.neko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        System.out.println("运行配置文件：addResourceHandlers");
        String path = "D:\\code\\blog\\neko_back\\src\\main\\resources\\static\\img\\";
//        String path = "C:\\nginx-1.21.0\\nginx-1.21.0\\project\\java\\src\\main\\resources\\static\\img\\";
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:" + path);
    }
}
