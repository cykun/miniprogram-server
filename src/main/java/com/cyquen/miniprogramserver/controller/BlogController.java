package com.cyquen.miniprogramserver.controller;

import com.cyquen.miniprogramserver.model.Result;
import com.cyquen.miniprogramserver.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    public BlogService blogService;

    // http://localhost:8080/api/v1/blogs
    @GetMapping("/api/v1/blogs")
    public Result getBlogList() {
        return Result.buildSuccess(blogService.getBlogList());
    }

    @PostMapping("/api/v1/collect")
    public Result collect(@RequestBody HashMap<String, String> data, @RequestHeader("token") String token) {
        LOGGER.info("token {}", token);
        return Result.buildSuccess();
    }
}
