package com.busanit501.hello_project._3jdbc.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
    // 1, 테스트용으로 현재 시간 가져오는 메서드 , 디비서버에서 받아오기.
    public String getTime() {
        // 디비로 부터 전달받은 시간을 담아둘 임시 변수.
        String now = null;
        // 디비 연결 , sql 전달, 값 가져오기. 자원 반납(자동으로 하기 위해서 try~resource).
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            ResultSet rs = pstmt.executeQuery();){
        // rs, 가상 테이블, 디비의 결과 내용을 테이블 형식으로 가지고 있다.
            rs.next();
            now = rs.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    } //getTime

    //2. 똑같은 기능, 시간 가져오기,
    // 자원 반납을 다르게 표현.
    // Lombok 기능 중에서,  @Cleanup 을 이용해서, 자동반납 하기.
    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next(); // 가상 테이블에서 데이터 가져오고,
        String now = rs.getString(1);
        return now;
    }


}
