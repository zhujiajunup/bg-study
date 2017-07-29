package org.jjzhu.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

/**
 * Created by hzzhujiajun on 2017/7/4.
 */
@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
public class ConfigClass {
    @Bean
    public ViewResolver cnViewResolver(){
        return new ContentNegotiatingViewResolver();
    }

}
