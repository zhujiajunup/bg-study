package org.jjzhu.spring.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by hzzhujiajun on 2017/7/11.
 */
@Configuration
@ComponentScan(basePackages = {"org.jjzhu.spring.spittr"},
    excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
}
