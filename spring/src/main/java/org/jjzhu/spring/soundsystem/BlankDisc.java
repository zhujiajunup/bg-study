package org.jjzhu.spring.soundsystem;

import java.util.List;

/**
 * Created by zhujiajunup@163.com on 2017/7/6.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks){
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("playing "+title+" by "+artist);
        tracks.forEach(System.out::println);
    }

    @Override
    public void playTrack(int index) throws IndexOutOfBoundsException {
        System.out.println("playing track "+tracks.get(index));
    }
}
