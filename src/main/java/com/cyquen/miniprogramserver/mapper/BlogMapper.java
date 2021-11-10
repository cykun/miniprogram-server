package com.cyquen.miniprogramserver.mapper;

import com.cyquen.miniprogramserver.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    List<Blog> findBlogList();
}
