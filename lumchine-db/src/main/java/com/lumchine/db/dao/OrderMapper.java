package com.lumchine.db.dao;

import org.apache.ibatis.annotations.Param;
import com.lumchine.db.domain.LumchineOrder;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") LumchineOrder order);
}