/**
 * @(#)TraderStream.java, 2017/10/18.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

import org.jjzhu.java8.beans.Trader;
import org.jjzhu.java8.beans.Transaction;

/**
 * @author 祝佳俊(zhujiajunup@163.com)
 */
public class TraderStream {
    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");
    private List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    private void func1() {
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        System.out.println("---------------------");
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("---------------------");
        transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().forEach(System.out::println);
        System.out.println("---------------------");
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Milan")).findAny();
    }


    public static void main(String[] args) {

        java.util.stream.Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        java.util.stream.Stream.iterate(new int[] {0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
    }

}