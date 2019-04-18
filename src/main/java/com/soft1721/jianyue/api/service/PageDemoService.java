package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.vo.PageDemo;

import java.util.List;

public interface PageDemoService {
    List<PageDemo> selectAll(int pageNO,int pageSize);
}
