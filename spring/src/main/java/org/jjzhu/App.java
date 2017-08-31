package org.jjzhu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        loop: for(int i = 1; i < 10; i++){
            if(i % 2 == 0){
                continue loop;
            }
            System.out.println(i);

        }
        System.out.println( "Hello World!" );
    }
}
