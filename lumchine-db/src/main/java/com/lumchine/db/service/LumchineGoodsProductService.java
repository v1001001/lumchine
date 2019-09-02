package com.lumchine.db.service;

import com.lumchine.db.dao.LumchineGoodsProductMapper;
import com.lumchine.db.domain.LumchineGoodsProduct;
import com.lumchine.db.domain.LumchineGoodsProductExample;
import com.lumchine.db.dao.GoodsProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineGoodsProductService {
    @Resource
    private LumchineGoodsProductMapper lumchineGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<LumchineGoodsProduct> queryByGid(Integer gid) {
        LumchineGoodsProductExample example = new LumchineGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return lumchineGoodsProductMapper.selectByExample(example);
    }

    public LumchineGoodsProduct findById(Integer id) {
        return lumchineGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        lumchineGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LumchineGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        lumchineGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        LumchineGoodsProductExample example = new LumchineGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) lumchineGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        LumchineGoodsProductExample example = new LumchineGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        lumchineGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }
}