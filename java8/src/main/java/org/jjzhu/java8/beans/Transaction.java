/**
 * @(#)Transaction.java, 2017/10/18.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
@Getter
@AllArgsConstructor
@ToString
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;
}