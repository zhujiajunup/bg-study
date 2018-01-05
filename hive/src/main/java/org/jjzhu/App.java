package org.jjzhu;

import java.io.IOException;

import com.****.mail.holmes.alert.AlertService;
import com.****.mail.holmes.alert.bean.AlertBean;
import com.****.mail.holmes.alert.constant.AlertType;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AlertBean alertBean = new AlertBean();

        alertBean.setSubject("test");
        alertBean.setBody("test");
        alertBean.setMobile("13486178520");
        alertBean.setAccount("zhujiajunup@163.com");
        alertBean.setType(AlertType.SEND_BY_POPO + AlertType.SEND_BY_EMAIL + AlertType.SEND_BY_MOBILE + AlertType.SEND_BY_YIXIN);
        try {
            System.out.println(AlertService.sendAlert(alertBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
