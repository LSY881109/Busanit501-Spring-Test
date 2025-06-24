package com.busanit501;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectTests {
    @Test
    public void test1() {
        int v1 = 10;
        int v2 = 10;
// 같은지 확인하는 메서드
        // 같으면 : 성공, 다르면 실패.
        Assertions.assertEquals(v1, v2);
    }
}
