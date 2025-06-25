package com.busanit501.hello_project._3jdbc.controller;

import com.busanit501.hello_project._3jdbc.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoListController2", value = "/todo/list2")
@Log4j2
public class TodoListController extends HttpServlet {
    // 서비스의 도움을 받기, 서비스 기능 가져오기. 준비하기.
    private TodoService todoService = TodoService.INSTANCE;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TodoListController doGet 확인");

        // 서비스 도움받기.
        // 디비에서 조회한 데이터 -> TodoVO 클래스 변환 하고, -> TodoDTO 변환하고,
        // 리스트에 담아서 전달 받기.
        // 컨트롤러에서는, 서비스에서 받은 List<TodoDTO> 받아서, 화면에 탑재 할 예정.
    }
}
