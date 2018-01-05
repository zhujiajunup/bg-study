/**
 * @(#)Stream.java, 2017/10/18.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jjzhu.java8.beans.Dish;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author 祝佳俊(zhujiajunup@163.com)
 */
public class DishStream {

    private List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );

    void testFlatMap(){

        List<String> words = Arrays.asList(
                "hello", "world"
        );
        List<String>
        uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);
        menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        menu.stream().collect(groupingBy(Dish::getType)).forEach((k, v) -> System.out.println(k + ":" + v));
    }
    public void testStream(){
        int a = 1_1000_100;
        List<String> threeHighCaloricDishNames = this.menu.stream().filter(
                d -> {
                    System.out.println("filtering" + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping" + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }

    public static void main(String [] args){
        new DishStream().testFlatMap();
    }
}