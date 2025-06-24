package com.busanit501.hello_project._3jdbc.dao;

import com.busanit501.hello_project._3jdbc.domain.TodoVO;
import lombok.Cleanup;

import java.sql.*;

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
    } //getTime2

    // 등록 기능. 화면에서 todo의 내용을 전달 받아와서, -> 디비에 넣을 예정.
    // 화면에서 데이터를 각각 받는 것보다, -> 모델 클래스 담아서 전달.
    public void insert(TodoVO todoVO) throws Exception{
        // 등록, insert sql, 문장 작성,
        String sql ="insert into tbl_todo (title, dueDate, finished) values (?,?,?)";

        // 디비에 연결할 객체 작성, 자원 반납 방법) @Cleanup 사용하기.
        // 연결 객체, sql 문장 담는 객체 , 반복.
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, todoVO.getTitle());
        // 요구사항 Date 타입을 원하는데, LocalDate 타입을 형변환하기.
        pstmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
        pstmt.setBoolean(3, todoVO.isFinished());

        // 실제 디비서버에 반영하기. 쓰기 작업 진행.
        pstmt.executeUpdate();

    }


}
