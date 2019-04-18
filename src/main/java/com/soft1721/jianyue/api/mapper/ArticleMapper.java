package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a Left JOIN t_user b ON a.u_id=b.id ORDER By id DESC ")
    List<ArticleVO> selectAll();


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a Left JOIN t_user b ON a.u_id = b.id WHERE a.id=#{aId} ")
    ArticleVO getArticleById(int aId);


    @Insert("INSERT INTO t_article (u_id,title,content,create_time) VALUES (#{uId},#{title},#{content},#{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertArticle(Article article);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a Left JOIN t_user b ON a.u_id=b.id WHERE a.u_id=#{uId} ORDER By id DESC ")
    List<ArticleVO> selectByuId(int uId);

    @Delete("DELETE  FROM t_article WHERE id = #{id} ")
    void deleteArticleById(int id);

}