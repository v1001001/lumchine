package com.lumchine.db.service;

import com.lumchine.db.dao.LumchineOrderGoodsMapper;
import com.lumchine.db.domain.LumchineOrderGoods;
import com.lumchine.db.domain.LumchineOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineOrderGoodsService {
    @Resource
    private LumchineOrderGoodsMapper orderGoodsMapper;

    public int add(LumchineOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<LumchineOrderGoods> queryByOid(Integer orderId) {
        LumchineOrderGoodsExample example = new LumchineOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<LumchineOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        LumchineOrderGoodsExample example = new LumchineOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public LumchineOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(LumchineOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        LumchineOrderGoodsExample example = new LumchineOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        LumchineOrderGoodsExample example = new LumchineOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }
}
