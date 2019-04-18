package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollectService {
    Collect getCollect(int fromUId, int toAId);

    List<CollectVO> getCollectsByUId(int fromUId);

    void insertCollect(Collect collect);

    void deleteCollect(int fromUId, int toAId);
}
