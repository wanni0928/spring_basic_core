package com.spring.basic.spring_demo.web;

import com.spring.basic.spring_demo.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String reqeustURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(reqeustURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
