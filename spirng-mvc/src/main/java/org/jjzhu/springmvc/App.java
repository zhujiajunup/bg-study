package org.jjzhu.springmvc;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by zhujiajunup@163.com on 2017/7/13.
 */
public class App {
    enum UserRole{
        common,
        admin
    }
    public static void main(String [] args){
        UserRole role = UserRole.admin;
        System.out.println(role);
    }
}
