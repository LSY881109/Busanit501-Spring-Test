package com.busanit501.hello_project._3jdbc.dao;

import com.busanit501.hello_project._3jdbc.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    // mid, mpw 를 이용해서, 한 명 회원 조회.
    public MemberVO getMemberVO(String mid, String mpw) throws Exception {
        String query= "select mid,mpw,mname from tbl_member where mid=? and mpw=?";
        // 디비에서 조회한 회원 정보를 담을 임시 , 객체 생성.
        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        // 회원 정보가 있다면, 모델 클래스 담기.
        memberVO = MemberVO.builder()
                .mid(mid)
                .mpw(mpw)
                .build();

        return memberVO;
    }
}
