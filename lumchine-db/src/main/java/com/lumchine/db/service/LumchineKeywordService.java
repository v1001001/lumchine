package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineKeywordMapper;
import com.lumchine.db.domain.LumchineKeyword;
import com.lumchine.db.domain.LumchineKeywordExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineKeywordService {
    @Resource
    private LumchineKeywordMapper keywordsMapper;

    public LumchineKeyword queryDefault() {
        LumchineKeywordExample example = new LumchineKeywordExample();
        example.or().andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return keywordsMapper.selectOneByExample(example);
    }

    public List<LumchineKeyword> queryHots() {
        LumchineKeywordExample example = new LumchineKeywordExample();
        example.or().andIsHotEqualTo(true).andDeletedEqualTo(false);
        return keywordsMapper.selectByExample(example);
    }

    public List<LumchineKeyword> queryByKeyword(String keyword, Integer page, Integer limit) {
        LumchineKeywordExample example = new LumchineKeywordExample();
        example.setDistinct(true);
        example.or().andKeywordLike("%" + keyword + "%").andDeletedEqualTo(false);
        PageHelper.startPage(page, limit);
        return keywordsMapper.selectByExampleSelective(example, LumchineKeyword.Column.keyword);
    }

    public List<LumchineKeyword> querySelective(String keyword, String url, Integer page, Integer limit, String sort, String order) {
        LumchineKeywordExample example = new LumchineKeywordExample();
        LumchineKeywordExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        if (!StringUtils.isEmpty(url)) {
            criteria.andUrlLike("%" + url + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return keywordsMapper.selectByExample(example);
    }

    public void add(LumchineKeyword keywords) {
        keywords.setAddTime(LocalDateTime.now());
        keywords.setUpdateTime(LocalDateTime.now());
        keywordsMapper.insertSelective(keywords);
    }

    public LumchineKeyword findById(Integer id) {
        return keywordsMapper.selectByPrimaryKey(id);
    }

    public int updateById(LumchineKeyword keywords) {
        keywords.setUpdateTime(LocalDateTime.now());
        return keywordsMapper.updateByPrimaryKeySelective(keywords);
    }

    public void deleteById(Integer id) {
        keywordsMapper.logicalDeleteByPrimaryKey(id);
    }
}
