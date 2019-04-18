package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.vo.PageDemo;
import com.soft1721.jianyue.api.service.PageDemoService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/page")
public class PageController {
    @Resource
    private PageDemoService pageDemoService;

    @GetMapping(value = "/list")
    public ResponseResult getAll(@RequestParam("pageNO") int pageNO, @RequestParam("pageSize") int pageSize) {
        List<PageDemo> list = pageDemoService.selectAll(pageNO, pageSize);
        return ResponseResult.success(list);
    }


}
