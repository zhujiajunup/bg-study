package org.jjzhu.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hzzhujiajun on 2017/7/6.
 */
public class KnightMain {
    public static void main(String [] args){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
