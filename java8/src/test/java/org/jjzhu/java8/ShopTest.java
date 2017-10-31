/**
 * @(#)ShopTest.java, 2017/10/20.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import org.jjzhu.java8.beans.Shop;
import org.jjzhu.java8.stream.BestPriceFinder;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
public class ShopTest {
    public static void main(String[] args) {
        BestPriceFinder finder = new BestPriceFinder();
        long start = System.nanoTime();
        System.out.println(finder.findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }
}