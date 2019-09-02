package com.lumchine.db.service;

import com.lumchine.db.dao.LumchineGoodsAttributeMapper;
import com.lumchine.db.domain.LumchineGoodsAttribute;
import com.lumchine.db.domain.LumchineGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineGoodsAttributeService {
    @Resource
    private LumchineGoodsAttributeMapper goodsAttributeMapper;

    public List<LumchineGoodsAttribute> queryByGid(Integer goodsId) {
        LumchineGoodsAttributeExample example = new LumchineGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(LumchineGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public LumchineGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        LumchineGoodsAttributeExample example = new LumchineGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }
}
