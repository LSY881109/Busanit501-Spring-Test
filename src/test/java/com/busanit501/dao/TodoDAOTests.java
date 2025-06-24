package com.busanit501.dao;

import com.busanit501.hello_project._3jdbc.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TodoDAOTests {
    // 1, TodoDAO 기능 사용하기, 가져오기.
    private TodoDAO todoDAO;

    // 각각 @Test 메서드가 실행 되기전에 실해되는 메서드.
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println("testTime : " + todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception {
        System.out.println("testTime : " + todoDAO.getTime2());
    }
}
