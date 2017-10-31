/**
 * @(#)ParallelStreamsUtils.java, 2017/10/19.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.utils;

import java.util.function.Function;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
public class StreamsUtils {

    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n){
        long total = 0;
        for(int i = 0 ; i < 10; i ++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            total += (System.nanoTime() - start);
            System.out.println("Result: " + sum);

        }
        return total/1_000_000;
    }
}