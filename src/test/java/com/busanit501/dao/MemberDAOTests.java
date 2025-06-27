package com.busanit501.dao;

import com.busanit501.hello_project._3jdbc.dao.MemberDAO;
import com.busanit501.hello_project._3jdbc.dao.TodoDAO;
import com.busanit501.hello_project._3jdbc.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Log4j2
public class MemberDAOTests {
    // 1, TodoDAO 기능 사용하기, 가져오기.
    private MemberDAO memberDAO;

    // 각각 @Test 메서드가 실행 되기전에 실해되는 메서드.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    // 아이디, 패스워드 ,mid,mpw를 이용해서, 한명 회원 조회 하기.
    @Test
    public void getMember() throws Exception {
        String mid = "lsy";
        String mpw = "1234";

        MemberVO memberVO = memberDAO.getMemberVO(mid,mpw);
        log.info("조회한 멤버 : " + memberVO);
    }

}
