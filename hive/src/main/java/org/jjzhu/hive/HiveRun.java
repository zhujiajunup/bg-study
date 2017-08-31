/**
 * @(#)HiveRun.java, 2017/8/29.
 * <p/>
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.hive;

import org.apache.hadoop.hive.cli.CliDriver;

/**
 * @author 祝佳俊(hzzhujiajun@corp.netease.com)
 */
public class HiveRun {
    public static void main(String[] args) throws Exception {
            new CliDriver();
    }
}