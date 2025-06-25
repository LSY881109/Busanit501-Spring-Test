package com.busanit501.hello_project._3jdbc.controller;

import com.busanit501.hello_project._3jdbc.dto.TodoDTO;
import com.busanit501.hello_project._3jdbc.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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

    // 등록 처리 기능
    // 화면으로부터 전달 받은 데이터를 , 모델 클래스 TodoDTO에 담아서 전달 하기.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), formatter))
                .build();
        log.info("TodoRegController  작업중, doPost 처리중./todo/register2");
        log.info("전달 받은 데이터 변환 확인 : " + todoDTO);

        // 서비스에 외주 주기, 데이터를 전달만 해주면 됨.
        try{
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 데이터를 전달 후, 다시, PRG 패턴, post 처리후,  다시 화면으로 전환해주기.
        resp.sendRedirect("/todo/list2");
    }
}
