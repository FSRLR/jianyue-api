package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.vo.PageDemo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PageMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "content", column = "content"),
    })
    @Select("SELECT * FROM t_page LIMIT #{offSet},#{limit} ")
    List<PageDemo> selectAll(@Param("offSet") int curPage,@Param("limit") int pageSize);

}
