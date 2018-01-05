package org.jjzhu.spring.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhujiajunup@163.com on 2017/7/6.
 */
public class CDPlayer2 {
    private CompactDisc cd;

    @Autowired
    public void setCompactDisc(CompactDisc cd){
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }
}
