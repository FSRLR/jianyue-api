package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.mapper.CommentMapper;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ImgMapper imgMapper;
    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO:articles){
            articleVO.setImgs(imgMapper.selectImgsByAId(articleVO.getId()));
            articleVO.setComments(commentMapper.selectCommentsByAId(articleVO.getId()).size());
        }
        return articles;
    }

    @Override
    public ArticleVO getArticleById(int aId) {
        return articleMapper.getArticleById(aId);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public List<ArticleVO> selectByuId(int uId) {
        return articleMapper.selectByuId(uId);
    }

    @Override
    public void deleteArticleById(int id) {
        articleMapper.deleteArticleById(id);
    }
}