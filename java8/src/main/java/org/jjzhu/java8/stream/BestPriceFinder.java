/**
 * @(#)BestPriceFinder.java, 2017/10/20.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.jjzhu.java8.beans.Shop;

import static java.util.stream.Collectors.toList;

/**
 * @author 祝佳俊(zhujiajunup@163.com)
 */
public class BestPriceFinder {
    private List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    public List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPrice(product)))
                        .collect(toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());

    }
}