package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineSearchHistoryMapper;
import com.lumchine.db.domain.LumchineSearchHistory;
import com.lumchine.db.domain.LumchineSearchHistoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineSearchHistoryService {
    @Resource
    private LumchineSearchHistoryMapper searchHistoryMapper;

    public void save(LumchineSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<LumchineSearchHistory> queryByUid(int uid) {
        LumchineSearchHistoryExample example = new LumchineSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, LumchineSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        LumchineSearchHistoryExample example = new LumchineSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<LumchineSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        LumchineSearchHistoryExample example = new LumchineSearchHistoryExample();
        LumchineSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
