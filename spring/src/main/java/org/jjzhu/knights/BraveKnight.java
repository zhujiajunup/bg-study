package org.jjzhu.knights;

/**
 * Created by zhujiajunup@163.com on 2017/7/6.
 */
public class BraveKnight implements Knight {
    private Quest quest;
    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
