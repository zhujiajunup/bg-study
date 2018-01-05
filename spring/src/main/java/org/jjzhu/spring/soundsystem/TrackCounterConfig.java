package org.jjzhu.spring.soundsystem;

import org.jjzhu.spring.aop.TrackCounter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujiajunup@163.com on 2017/7/7.
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {
    @Bean
    @Qualifier("blankDisc")
    public CompactDisc blankDisc(){
        List<String> tracks = new ArrayList<>(3);
        tracks.add("track1");
        tracks.add("track2");
        tracks.add("track3");
        return new BlankDisc("title aaaa", "artist bbbbb", tracks);
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
}
