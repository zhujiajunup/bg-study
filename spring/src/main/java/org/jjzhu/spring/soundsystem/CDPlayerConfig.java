package org.jjzhu.spring.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by hzzhujiajun on 2017/7/6.
 */
@Configuration
@PropertySource("classpath:app.properties")
public class CDPlayerConfig {
    @Autowired
    Environment environment;
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers(
                environment.getProperty("sgt.title"),
                environment.getProperty("sgt.artist")
        );
    }

    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }


}
