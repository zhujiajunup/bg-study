/**
 * @(#)ParallelStreams.java, 2017/10/19.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.jjzhu.java8.utils.StreamsUtils;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
public class ParallelStreams {
    public static long sequentialSum(long n){
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }
    public static long parallelSum(long n){
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }
    public static long rangeSum(long n){
        return LongStream.rangeClosed(1, n).reduce(0, Long::sum);
    }
    static long parallelRangeSum(long n){
        return LongStream.rangeClosed(1, n).parallel().reduce(0, Long::sum);
    }

    static long forkJoinSum(long n){
        long [] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
    public static void main(String [] args){
        //System.out.println("sequentialSum: " + StreamsUtils.measureSumPerf(ParallelStreams::sequentialSum, 1_000_000));
        //System.out.println("parallelSum:" + StreamsUtils.measureSumPerf(ParallelStreams::parallelSum, 1_000_000));
        //System.out.println("rangeSum:" + StreamsUtils.measureSumPerf(ParallelStreams::rangeSum, 1_000_000));
       // System.out.println("parallelRangeSum:" + StreamsUtils.measureSumPerf(ParallelStreams::parallelRangeSum, 1_000_000));
        System.out.println("forkJoinSum:" + StreamsUtils.measureSumPerf(ParallelStreams::forkJoinSum, 1_000_000));
    }
}