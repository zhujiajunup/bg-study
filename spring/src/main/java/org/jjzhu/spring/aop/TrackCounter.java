package org.jjzhu.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhujiajunup@163.com on 2017/7/7.
 */
@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<>();
    @Pointcut("execution(* org.jjzhu.spring.soundsystem.CompactDisc.playTrack(int ))" +
            "&& args(index_)")
    public void trackPlayed(int index_){}

    @Before("trackPlayed(index)")
    public void countTrack(int index){
        int currentCount = getPlayCount(index);
        trackCounts.put(index, ++currentCount);
    }
    public int getPlayCount(int index){
        return trackCounts.getOrDefault(index, 0);
    }
}
