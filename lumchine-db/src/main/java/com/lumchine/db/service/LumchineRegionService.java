package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineRegionMapper;
import com.lumchine.db.domain.LumchineRegion;
import com.lumchine.db.domain.LumchineRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LumchineRegionService {

    @Resource
    private LumchineRegionMapper regionMapper;

    public List<LumchineRegion> getAll(){
        LumchineRegionExample example = new LumchineRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<LumchineRegion> queryByPid(Integer parentId) {
        LumchineRegionExample example = new LumchineRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public LumchineRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<LumchineRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        LumchineRegionExample example = new LumchineRegionExample();
        LumchineRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
