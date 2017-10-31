/**
 * @(#)Point.java, 2017/10/20.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
@Setter
@Getter
public class Point {

    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);

    private final int x;

    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point moveRightBy(int x){
        return new Point(this.x + x, this.y);
    }
}