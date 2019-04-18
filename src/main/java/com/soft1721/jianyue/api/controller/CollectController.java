package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import com.soft1721.jianyue.api.service.CollectService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    @PostMapping("/add")
    public ResponseResult collectArticle(@RequestParam("fromUId") int fromUId,@RequestParam("toAId") int toAId){
        Collect collect=new Collect();
        collect.setFromUId(fromUId);
        collect.setToAId(toAId);
        collectService.insertCollect(collect);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelCollect(@RequestParam("fromUId") int fromUId,@RequestParam("toAId") int toAId){
        collectService.deleteCollect(fromUId,toAId );
        return ResponseResult.success();
    }

    @GetMapping("/list")
    public ResponseResult CollectAll(@RequestParam("fromUId") int fromUId){
        List<CollectVO> list=collectService.getCollectsByUId(fromUId);
        return ResponseResult.success(list);
    }
}
