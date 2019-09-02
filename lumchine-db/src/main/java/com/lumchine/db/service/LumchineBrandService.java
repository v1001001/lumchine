package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineBrandMapper;
import com.lumchine.db.domain.LumchineBrand;
import com.lumchine.db.domain.LumchineBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineBrandService {
    @Resource
    private LumchineBrandMapper brandMapper;
    private LumchineBrand.Column[] columns = new LumchineBrand.Column[]{LumchineBrand.Column.id, LumchineBrand.Column.name, LumchineBrand.Column.desc, LumchineBrand.Column.picUrl, LumchineBrand.Column.floorPrice};

    public List<LumchineBrand> query(Integer page, Integer limit, String sort, String order) {
        LumchineBrandExample example = new LumchineBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<LumchineBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public LumchineBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<LumchineBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LumchineBrandExample example = new LumchineBrandExample();
        LumchineBrandExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return brandMapper.selectByExample(example);
    }

    public int updateById(LumchineBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LumchineBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<LumchineBrand> all() {
        LumchineBrandExample example = new LumchineBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
