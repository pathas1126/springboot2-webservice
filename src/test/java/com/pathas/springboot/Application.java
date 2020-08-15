package com.pathas.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication // 메인 클래스 지정 어노테이션, 해당 위치부터 설정을 일어가기 때문에 프로젝트 최상단에 위치
public class Application {
    public static void main(String[] args){
        run(Application.class, args); // 내장 WAS 실행, 서버에 톰캣 설치할 필요 X
    }
}
