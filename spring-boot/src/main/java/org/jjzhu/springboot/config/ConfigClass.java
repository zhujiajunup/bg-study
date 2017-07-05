package org.jjzhu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by hzzhujiajun on 2017/7/4.
 */
@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
public class ConfigClass {
}
