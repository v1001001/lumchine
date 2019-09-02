package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineTopicMapper;
import com.lumchine.db.domain.LumchineTopic;
import com.lumchine.db.domain.LumchineTopicExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineTopicService {
    @Resource
    private LumchineTopicMapper topicMapper;
    private LumchineTopic.Column[] columns = new LumchineTopic.Column[]{LumchineTopic.Column.id, LumchineTopic.Column.title, LumchineTopic.Column.subtitle, LumchineTopic.Column.price, LumchineTopic.Column.picUrl, LumchineTopic.Column.readCount};

    public List<LumchineTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<LumchineTopic> queryList(int offset, int limit, String sort, String order) {
        LumchineTopicExample example = new LumchineTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        LumchineTopicExample example = new LumchineTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public LumchineTopic findById(Integer id) {
        LumchineTopicExample example = new LumchineTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<LumchineTopic> queryRelatedList(Integer id, int offset, int limit) {
        LumchineTopicExample example = new LumchineTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<LumchineTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        LumchineTopic topic = topics.get(0);

        example = new LumchineTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<LumchineTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<LumchineTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        LumchineTopicExample example = new LumchineTopicExample();
        LumchineTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(LumchineTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        LumchineTopicExample example = new LumchineTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LumchineTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


}
