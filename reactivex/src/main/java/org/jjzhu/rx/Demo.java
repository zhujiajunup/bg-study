/**
 * @(#)Demo.java, 2017/9/25.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.rx;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
public class Demo {

    public static void flowableUsage(){
        Flowable<Integer> upstream = Flowable.create(
                (e) -> {
                    System.out.println("emit 1");
                    e.onNext(1);
                    System.out.println("emit 2");
                    e.onNext(2);
                }, BackpressureStrategy.ERROR);
        Subscriber<Integer> downstream = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        upstream.subscribe(downstream);
    }
    public static void observableUsage(){
        Observable<Integer> observable = Observable.create(
                (e) -> {
                    for(int i = 0; ; i ++){
                        System.out.println("emit " + i);
                        e.onNext(i);
                        if(i % 2 == 0)
                            Thread.sleep(2 * 1000);
                        else
                            Thread.sleep(500);
                    }
                }
        );

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("subscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        };
        observable.debounce(1, TimeUnit.SECONDS).subscribe(observer);
    }
    public static void main(String[] args) {
        Demo.observableUsage();
    }
}