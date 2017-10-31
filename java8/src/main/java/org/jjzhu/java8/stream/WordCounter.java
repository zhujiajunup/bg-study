/**
 * @(#)WordCounter.java, 2017/10/19.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.java8.stream;

import java.util.stream.Stream;

/**
 * @author 祝佳俊(hzzhujiajun@corp.****.com)
 */
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;
    public WordCounter(int counter, boolean lastSpace){
        this.counter = counter;
        this.lastSpace = lastSpace;
    }
    public WordCounter accumulate(Character c){
        if(Character.isWhitespace(c)){
            return lastSpace ? this: new WordCounter(counter, true);
        }else{
            return lastSpace ? new WordCounter(counter + 1, false): this;
        }
    }

    public int getCounter() {
        return counter;
    }

    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter +  wordCounter.counter, wordCounter.lastSpace);
    }
    public static int countWords(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }
}