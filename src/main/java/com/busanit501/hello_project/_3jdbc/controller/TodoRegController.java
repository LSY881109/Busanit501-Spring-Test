package com.busanit501.hello_project._3jdbc.controller;

import com.busanit501.hello_project._3jdbc.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegController2", value = "/todo/register2")
@Log4j2
public class TodoRegController extends HttpServlet {
    // 등록 1) 등록 화면 get , 2)등록 처리 post
    // 외주 맡기기, 등록을 구현 할수 있는  , TodoService 외주 요청. 준비.
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TodoRegController : 등록 화면 제공 , doGet 작업");
        // 화면 전달 먼저 하기.
        req.getRequestDispatcher("/WEB-INF/todo/todoReg.jsp").forward(req, resp);
    }
}
