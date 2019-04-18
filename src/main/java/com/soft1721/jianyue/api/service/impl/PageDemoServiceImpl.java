package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.vo.PageDemo;
import com.soft1721.jianyue.api.mapper.PageMapper;
import com.soft1721.jianyue.api.service.PageDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PageDemoServiceImpl implements PageDemoService {
    @Resource
    private PageMapper pageMapper;

    @Override
    public List<PageDemo> selectAll(int pageNo,int pageSize) {
        int offSet=(pageNo-1)*pageSize;
        return pageMapper.selectAll(offSet, pageSize);
    }
}
