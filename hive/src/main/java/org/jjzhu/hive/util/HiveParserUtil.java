/**
 * @(#)HiveParserUtil.java, 2017/8/28.
 * <p/>
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.hive.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.jjzhu.hive.MyLineageInfo;


/**
 * @author 祝佳俊(hzzhujiajun@corp.netease.com)
 */
public class HiveParserUtil {

    public static List<String> getColumns(ASTNode ast){

        int numCh = ast.getChildCount();
        List<String> colList = new ArrayList<>(numCh);
        for(int i = 0; i < numCh; ++i) {
            ASTNode child = (ASTNode)ast.getChild(i);
            ASTNode childChild = (ASTNode)child.getChild(0);
            if(childChild != null){
                colList.add(childChild.getText().toLowerCase());
            }
        }
        return colList;
    }

    public static void output(MyLineageInfo lep){
        System.out.println("Input tables = " + lep.getInputTableList());
        System.out.println("Output tables = " + lep.getOutputTableList());
        System.out.println("columns = " + lep.getColumns());
        System.out.println("partitions columns:" + lep.getPartitions());
    }
}