package org.jjzhu.spring.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zhujiajunup@163.com on 2017/7/6.
 */
@Configuration
@PropertySource("classpath:app.properties")
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    public SgtPeppers(){}
    public SgtPeppers(String title, String artist){
        this.title = title;
        this.artist = artist;
    }
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int index) {

    }
}
