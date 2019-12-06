package com.sicau.one_car;

import com.sicau.one_car.dao.DraftDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneCarApplicationTests {

    @Autowired
    private DraftDao draftDao;

    @Test
    void contextLoads() {
    }

}
