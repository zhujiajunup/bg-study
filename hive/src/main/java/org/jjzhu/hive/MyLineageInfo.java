/**
 * @(#)MyLineageInfo.java, 2017/8/28.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.hive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.apache.hadoop.hive.ql.lib.DefaultGraphWalker;
import org.apache.hadoop.hive.ql.lib.DefaultRuleDispatcher;
import org.apache.hadoop.hive.ql.lib.Dispatcher;
import org.apache.hadoop.hive.ql.lib.GraphWalker;
import org.apache.hadoop.hive.ql.lib.Node;
import org.apache.hadoop.hive.ql.lib.NodeProcessor;
import org.apache.hadoop.hive.ql.lib.NodeProcessorCtx;
import org.apache.hadoop.hive.ql.lib.Rule;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.BaseSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.HiveParser;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.jjzhu.hive.util.HiveParserUtil;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
public class MyLineageInfo implements NodeProcessor {
    /**
     * Stores input tables in sql.
     */
    private TreeSet<String> inputTableList = new TreeSet<>();
    /**
     * Stores output tables in sql.
     */
    private TreeSet<String> outputTableList = new TreeSet<>();

    private Set<String> columns = new TreeSet<>();

    private Set<String> partitions = new TreeSet<>();

    public Set<String> getColumns() {
        return columns;
    }

    public TreeSet getInputTableList() {
        return inputTableList;
    }

    public TreeSet getOutputTableList() {
        return outputTableList;
    }

    public Set<String> getPartitions() {
        return partitions;
    }

    /**
     * Implements the process method for the NodeProcessor interface.
     */
    public Object process(Node nd, Stack stack, NodeProcessorCtx procCtx,
                          Object... nodeOutputs) throws SemanticException {
        ASTNode pt = (ASTNode) nd;

        switch (pt.getToken().getType()) {

            case HiveParser.TOK_CREATETABLE:
            case HiveParser.TOK_TAB:
                outputTableList.add(BaseSemanticAnalyzer.getUnescapedName((ASTNode) pt.getChild(0)));
                break;
            case HiveParser.TOK_TABCOLLIST:
                switch (pt.getParent().getType()){
                    case HiveParser.TOK_CREATETABLE:
                        columns.addAll(HiveParserUtil.getColumns(pt));
                        break;
                    case HiveParser.TOK_TABLEPARTCOLS:
                        partitions.addAll(HiveParserUtil.getColumns(pt));
                        break;
                }
                break;
            case HiveParser.TOK_TABREF:
                ASTNode tabTree = (ASTNode) pt.getChild(0);
                String table_name = (tabTree.getChildCount() == 1) ?
                        BaseSemanticAnalyzer.getUnescapedName((ASTNode) tabTree.getChild(0)) :
                        BaseSemanticAnalyzer.getUnescapedName((ASTNode) tabTree.getChild(0)) + "." + tabTree.getChild(1);
                inputTableList.add(table_name);
                break;
        }
        return null;
    }

    /**
     * parses given query and gets the lineage info.
     *
     * @param query 查询语句
     * @throws ParseException exception
     */
    public void getLineageInfo(String query) throws ParseException,
            SemanticException {

        /*
         * Get the AST tree
         */
        ParseDriver pd = new ParseDriver();
        ASTNode tree = pd.parse(query);

        while ((tree.getToken() == null) && (tree.getChildCount() > 0)) {
            tree = (ASTNode) tree.getChild(0);
        }

        /*
         * initialize Event Processor and dispatcher.
         */
        inputTableList.clear();
        outputTableList.clear();
        partitions.clear();
        columns.clear();
        // create a walker which walks the tree in a DFS manner while maintaining
        // the operator stack. The dispatcher
        // generates the plan from the operator tree
        Map<Rule, NodeProcessor> rules = new LinkedHashMap<>();

        // The dispatcher fires the processor corresponding to the closest matching
        // rule and passes the context along
        Dispatcher disp = new DefaultRuleDispatcher(this, rules, null);
        GraphWalker ogw = new DefaultGraphWalker(disp);

        // Create a list of topop nodes
        ArrayList<Node> topNodes = new ArrayList<>();
        topNodes.add(tree);
        ogw.startWalking(topNodes, null);
    }

    public static void main(String[] args) throws IOException, ParseException,
            SemanticException {
//        String query = "INSERT OVERWRITE TABLE hzzhujiajun.table1 SELECT a.name FROM hzzhujiajun.table2 a join hzzhujiajun.table3 b ON (a.id = b.id)";
//        String query2 = "CREATE EXTERNAL TABLE facts.http_status (\n" +
//                "  code INT,\n" +
//                "  status_group STRING,\n" +
//                "  message STRING,\n" +
//                "  description STRING\n" +
//                ")\n" +
//                "ROW FORMAT DELIMITED \n" +
//                "FIELDS TERMINATED BY '\\t'\n" +
//                "LINES TERMINATED BY '\\n'\n" +
//                "STORED AS TEXTFILE\n" +
//                "LOCATION \"${EXTERNAL_DATA_LOCATION}/facts.db/http_status\"\n";
//        String query3 = "CREATE TABLE nasa_access.daily_logs(\n" +
//                "  source_ip STRING,\n" +
//                "  source_url STRING,\n" +
//                "  time TIMESTAMP ,\n" +
//                "  action STRING,\n" +
//                "  url STRING,\n" +
//                "  size INT,\n" +
//                "  line STRING\n" +
//                ")\n" +
//                "PARTITIONED BY (day STRING)\n" +
//                "STORED AS ORC";

        String query4 = "select u.name, o.orderid from o join u on o.uid = u.uid";

        String query5 = "with q1 as (select key from q2 where key = '5'),  \n" +
                "q2 as ( select key from src where key = '5')  \n" +
                "select * from (select key from q1) a";
        MyLineageInfo lep = new MyLineageInfo();
//        lep.getLineageInfo(query);
//        HiveParserUtil.output(lep);
//        System.out.println("------------------------------------------");
//        lep.getLineageInfo(query2);
//        HiveParserUtil.output(lep);
//        System.out.println("------------------------------------------");
//        lep.getLineageInfo(query3);
//        HiveParserUtil.output(lep);
//        System.out.println("------------------------------------------");
        lep.getLineageInfo(query5);
        HiveParserUtil.output(lep);
    }
}