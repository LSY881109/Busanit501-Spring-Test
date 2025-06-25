package com.busanit501.hello_project._3jdbc.service;

import com.busanit501.hello_project._3jdbc.dao.TodoDAO;
import com.busanit501.hello_project._3jdbc.domain.TodoVO;
import com.busanit501.hello_project._3jdbc.dto.TodoDTO;
import com.busanit501.hello_project._3jdbc.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum TodoService {
    INSTANCE;

    // 다른 기능 불러와서 사용할 준비.
    // DB 로직 처리하는 DAO 기능 필요함.
    private TodoDAO dao;
    // DTO<->VO, 변환 해주는 도구 , 모델 맵퍼 기능 필요함.
    private ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 등록기능,
    // 화면에서 데이터 입력 후 전달 -> 컨트롤러에서 데이터 받고, DTO 담기
    // -> DTO를 서비스에 전달 -> 서비스에서 받은 DTO를 VO 변환 , 다시 DAO 전달.
    //  -> DAO 가 디비 쓰는 과정.
    // 현위치 : 서비스 ,
    // 역할 : 받고, 변환, 전달.
    public void register(TodoDTO todoDTO) throws Exception{
        System.out.println("TodoService , 화면으로 부터 받은 데이터 확인. todoDTO:"+todoDTO);
        // DTO -> VO 로 변환하기, 도구 이용해서.
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        System.out.println("TodoService 변환 데이터 확인. todoVO:"+todoVO);
        // 서비스 -> DAO의 기능을 이용하자, 의존하자, 도움받자, 재사용하자.
        dao.insert(todoVO);
    }


}
