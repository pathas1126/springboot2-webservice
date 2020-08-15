package com.pathas.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest // Web 에 집중할 수 있는 테스트 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입받음
    private MockMvc mvc; // GET, POST 등의 API 테스트 시 사용


    @Test // HTTP GET 요청을 받을 수 있는 API 생성
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // HTTP Header 의 Status 검증
                .andExpect(content().string(hello)); // 응답 본문의 내용 검증
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 10000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
