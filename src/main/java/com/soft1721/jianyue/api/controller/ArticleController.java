package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import com.soft1721.jianyue.api.entity.vo.CommentVO;
import com.soft1721.jianyue.api.service.*;
import com.soft1721.jianyue.api.util.MsgConst;
import com.soft1721.jianyue.api.util.ResponseResult;
import com.soft1721.jianyue.api.util.poi.PoiUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private ImgService imgService;
    @Resource
    private FollowService followService;
    @Resource
    private CollectService collectService;

    @GetMapping(value = "/list")
    public ResponseResult getAll() {
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/{aId}")
    public ResponseResult getArticleById(@PathVariable("aId") int aId,@RequestParam("userId") int userId) {
        System.out.println(userId);
        ArticleVO article = articleService.getArticleById(aId);
        int toUId = article.getUId();
        Map<String, Object> map = new HashMap<>();
        Follow follow = followService.getFollow(userId, toUId);
        Collect collect=collectService.getCollect(userId, aId);
        if (collect!=null){
            map.put("collected", MsgConst.COLLECTED);
        }else {
            map.put("collected", MsgConst.NO_COLLECTED);
        }
        if (follow != null) {
            map.put("followed", MsgConst.FOLLOWED);
        } else {
            map.put("followed", MsgConst.NO_FOLLOWED);
        }
        List<CommentVO> comments = commentService.selectCommentsByAId(aId);
        map.put("article", article);
        map.put("comments", comments);
        return ResponseResult.success(map);
    }


    @PostMapping("/add")
    public ResponseResult postArticle(@RequestParam("uId") int uId,
                                      @RequestParam("title") String title,
                                      @RequestParam("content") String content) {
        Article article = new Article();
        article.setUId(uId);
        article.setTitle(title);
        article.setContent(content);
        article.setCreateTime(new Date());
        articleService.insertArticle(article);
        //新增文章后，将获取到的自增主键返回给客户端，方便图片地址的写入
        return ResponseResult.success(article.getId());
    }

    @GetMapping("/user")
    public ResponseResult getAllByUId(@RequestParam("userId") int uId){
        List<ArticleVO> articleList = articleService.selectByuId(uId);
        return ResponseResult.success(articleList);
    }

    @GetMapping("/collect")
    public ResponseResult getAllCollectByUId(@RequestParam("userId")int uId){
        List<CollectVO> collectVO=collectService.getCollectsByUId(uId);
        return ResponseResult.success(collectVO);
    }

    @GetMapping("/user_count")
    public ResponseResult getCountByUId(@RequestParam("userId") int uId){
        List<ArticleVO> articleList = articleService.selectByuId(uId);
        return ResponseResult.success(articleList.size());
    }

    @DeleteMapping("/delete")
    public ResponseResult deleteArticleById(@RequestParam("id") int id){
        articleService.deleteArticleById(id);
        return ResponseResult.success();
    }

    @RequestMapping(value = "/exportArticle", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        return PoiUtils.exportArticleExcel(articleService.selectAll());
    }
}