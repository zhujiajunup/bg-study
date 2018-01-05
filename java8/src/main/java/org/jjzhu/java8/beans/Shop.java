/**
 * @(#)Shop.java, 2017/10/20.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.jjzhu.java8.utils.StreamsUtils;

import static java.lang.Math.random;

/**
 * @author 祝佳俊(zhujiajunup@163.com)
 */
@Setter
@Getter
@AllArgsConstructor
public class Shop {

    private String name;

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
        /*CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            }catch (Exception ex){
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;*/
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
    private double calculatePrice(String product){
        StreamsUtils.delay();
        return random() * product.charAt(0) + product.charAt(1);
    }
}