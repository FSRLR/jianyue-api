package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;

    @Test
    public void selectAll() {
        List<ArticleVO> articleVO=articleService.selectAll();
        System.out.println(articleVO);
    }

    @Test
    public void getArticleById() {
    }
}