package com.cyquen.miniprogramserver;

import com.cyquen.miniprogramserver.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniprogramServerApplicationTests {

    @Autowired
    public BlogMapper blogMapper;

    @Test
    void contextLoads() {

        System.out.println(blogMapper.findBlogList());
    }

}
