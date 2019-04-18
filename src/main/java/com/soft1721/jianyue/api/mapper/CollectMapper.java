package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollectMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fromUId", column = "from_uid"),
            @Result(property = "toAId", column = "to_aid")
    })
    @Select("SELECT * FROM t_collect WHERE from_uid = #{fromUId} AND to_aid = #{toAId} ")
    Collect getCollect(@Param("fromUId") int fromUId, @Param("toAId") int toAId);

    @Results({
            @Result(property = "toAId", column = "to_aid"),
            @Result(property = "title", column = "title")
    })
    @Select("SELECT a.to_aid,b.title FROM t_collect a LEFT JOIN t_article b ON a.to_aid = b.id WHERE a.from_uid = #{fromUId}  ")
    List<CollectVO> getCollectsByUId(int fromUId);

    @Insert("INSERT INTO t_collect (from_uid,to_aid) VALUES (#{fromUId},#{toAId}) ")
    void insertCollect(Collect collect);

    @Delete("DELETE  FROM t_collect WHERE from_uid = #{fromUId} AND to_aid = #{toAId} ")
    void deleteCollect(@Param("fromUId") int fromUId, @Param("toAId") int toAId);
}
