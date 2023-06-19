package com.guruguruzom.firstservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service")
@RequiredArgsConstructor
@Slf4j
public class FirstServiceController {

    //application.yml 파일에 선언된 변수 가져오기
    private final Environment env;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the First service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        log.info(header);
        return "Hellow world in First Service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        //mvc를 통한 방법
        log.info("Server port={}", request.getServerPort());

        return String.format("First Service Check on Port %s"
                , env.getProperty("local.server.port"));
    }
}
