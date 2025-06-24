package com.busanit501.dao;

import com.busanit501.hello_project._3jdbc.dao.TodoDAO;
import com.busanit501.hello_project._3jdbc.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

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

    @Test
    public void testInsert() throws Exception {
        // 임시 데이터로 구성, 나중에 화면에서 입력 받은 데이터를 사용할 예정.

        // 기본 인스턴스 생성, 빌더 패턴 사용 전
//        TodoVO todoVO = new TodoVO();
//        todoVO.setTitle("샘플 제목");
//        todoVO.setDueDate(LocalDate.now());

        // 빌더 패턴 사용 후
        TodoVO todoVO = TodoVO.builder()
                .title("샘플 제목")
                .dueDate(LocalDate.now())
                .build();

        // TodoDAO 기능 이용해서, insert 해보기.
        todoDAO.insert(todoVO);
    }
}
