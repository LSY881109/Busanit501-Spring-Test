package com.busanit501.hello_project._3jdbc.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 해당 프로젝트가 실해되자마자,
// 실행 했으면 하는 작업을 확인 해보기.
@WebListener
@Log4j2
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info(("WebAppListener 클래스, 초기 작업 1 : init 라고 표현. ======================="));
        log.info(("WebAppListener 클래스, 초기 작업 1======================="));
        log.info(("WebAppListener 클래스, 초기 작업 1======================="));
        log.info(("WebAppListener 클래스, 프로젝트가 실행되면, 하고 싶은 작업 예시======================="));

    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info(("WebAppListener 클래스, 종료 작업 destroy ======================="));
        log.info(("WebAppListener 클래스, 종료 작업 destroy ======================="));
        log.info(("WebAppListener 클래스, 종료 작업 destroy ======================="));
    }
}
