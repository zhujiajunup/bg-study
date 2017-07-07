package org.jjzhu.spring.soundsystem;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by hzzhujiajun on 2017/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
@ActiveProfiles(value = "pro")
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;
    @Test
    public void testCDNotNull(){
        cd.play();
        assertNotNull(cd);
    }
}
