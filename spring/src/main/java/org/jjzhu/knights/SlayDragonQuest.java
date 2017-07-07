package org.jjzhu.knights;

import java.io.PrintStream;

/**
 * Created by hzzhujiajun on 2017/7/6.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay a dragon");
    }
}
