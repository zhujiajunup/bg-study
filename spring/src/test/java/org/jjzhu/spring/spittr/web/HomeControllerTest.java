package org.jjzhu.spring.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by zhujiajunup@163.com on 2017/7/11.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        MvcResult result = mockMvc.perform(get("/")).andReturn();
        System.out.println("12334");
        System.out.println(result.getRequest().getRequestURI());

        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }
}
