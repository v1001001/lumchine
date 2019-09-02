package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineCategoryMapper;
import com.lumchine.db.domain.LumchineCategory;
import com.lumchine.db.domain.LumchineCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineCategoryService {
    @Resource
    private LumchineCategoryMapper categoryMapper;
    private LumchineCategory.Column[] CHANNEL = {LumchineCategory.Column.id, LumchineCategory.Column.name, LumchineCategory.Column.iconUrl};

    public List<LumchineCategory> queryL1WithoutRecommend(int offset, int limit) {
        LumchineCategoryExample example = new LumchineCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<LumchineCategory> queryL1(int offset, int limit) {
        LumchineCategoryExample example = new LumchineCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<LumchineCategory> queryL1() {
        LumchineCategoryExample example = new LumchineCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<LumchineCategory> queryByPid(Integer pid) {
        LumchineCategoryExample example = new LumchineCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<LumchineCategory> queryL2ByIds(List<Integer> ids) {
        LumchineCategoryExample example = new LumchineCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public LumchineCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<LumchineCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LumchineCategoryExample example = new LumchineCategoryExample();
        LumchineCategoryExample.Criteria criteria = example.createCriteria();

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
        return categoryMapper.selectByExample(example);
    }

    public int updateById(LumchineCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LumchineCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<LumchineCategory> queryChannel() {
        LumchineCategoryExample example = new LumchineCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
