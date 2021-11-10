package com.cyquen.miniprogramserver.service;

import com.cyquen.miniprogramserver.mapper.BlogMapper;
import com.cyquen.miniprogramserver.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    public BlogMapper blogMapper;

    public List<Blog> getBlogList() {
//        ArrayList<Blog> blogs = new ArrayList<>(4);
//        blogs.add(new Blog(0, "为何我中断执行的线程不起作用，Why", "摘要：我们就以一个案例的形式，来为大家详细介绍下为何中断执行的线程不起作用。"));
//        blogs.add(new Blog(1, "使用 OpenCV 和 Python 识别数字", "使用 OpenCV 和 Python 识别数字本文演示如何使用 OpenCV 和 Python 识别图像中的数字。"));
//        blogs.add(new Blog(2, "《大学生Python学习》社区正式运行，加入我们，每日学习，引燃青春~", "欢迎每一位小伙伴的加入： 社区：大学生Python学习  文章目录：第一部分：社区管理员简介"));
//        blogs.add(new Blog(3, "【硬核】小明高考考了680分，他想知道在全国1000W考生中排什么名次？", "大家好，我是Tom哥~有这么一道题：今年高考，有1000万的考生参加了考试，满分750，小明靠了680分，他想"));
//        blogs.add(new Blog(4, "【硬核】小明高考考了680分，他想知道在全国1000W考生中排什么名次？", "大家好，我是Tom哥~有这么一道题：今年高考，有1000万的考生参加了考试，满分750，小明靠了680分，他想"));
        return blogMapper.findBlogList();
    }
}
