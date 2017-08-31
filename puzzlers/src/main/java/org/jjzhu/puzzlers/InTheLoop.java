/**
 * @(#)InTheLoop.java, 2017/8/2.
 * <p/>
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.puzzlers;

/**
 * @author 祝佳俊(hzzhujiajun@corp.netease.com)
 */
public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;
    public static void main(String[] args) {
        int count = 0;
        for (long i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }
}