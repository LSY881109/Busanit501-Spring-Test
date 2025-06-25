package com.busanit501.hello_project._3jdbc.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;

    // 변환도구, 불러오기,
    private ModelMapper modelMapper;

    MapperUtil() {
        // DTO <-> VO , 2개의 모델 클래스의 변환 하기 위한 설정.
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
//        .setFieldMatchingEnabled(true)
//        - 필드 매칭을 활성화합니다. 이를 통해 ModelMapper는
//        객체 간 필드 이름이 일치할 경우 직접 매핑을 수행할 수 있습니다.
//
//.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
// - 접근 레벨을 PRIVATE으로 설정합니다. 이렇게 하면 ModelMapper가
// private 필드까지 접근하여 매핑할 수 있게 됩니다.
//
//.setMatchingStrategy(MatchingStrategies.STRICT) -
// 매칭 전략을 STRICT(엄격)으로 설정합니다.
// 이 설정은 소스와 대상의 필드 이름이 정확히
// 일치해야만 매핑을 수행하도록 합니다.
    }
    public  ModelMapper get() {
        return modelMapper;
    }
}
