package com.lumchine.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineGoodsMapper;
import com.lumchine.db.dao.LumchineGrouponRulesMapper;
import com.lumchine.db.domain.LumchineGoods;
import com.lumchine.db.domain.LumchineGrouponRules;
import com.lumchine.db.domain.LumchineGrouponRulesExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineGrouponRulesService {
    @Resource
    private LumchineGrouponRulesMapper mapper;
    @Resource
    private LumchineGoodsMapper goodsMapper;
    private LumchineGoods.Column[] goodsColumns = new LumchineGoods.Column[]{LumchineGoods.Column.id, LumchineGoods.Column.name, LumchineGoods.Column.brief, LumchineGoods.Column.picUrl, LumchineGoods.Column.counterPrice, LumchineGoods.Column.retailPrice};

    public int createRules(LumchineGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public LumchineGrouponRules queryById(Integer id) {
        LumchineGrouponRulesExample example = new LumchineGrouponRulesExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<LumchineGrouponRules> queryByGoodsId(Integer goodsId) {
        LumchineGrouponRulesExample example = new LumchineGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购活动列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<LumchineGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<LumchineGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        LumchineGrouponRulesExample example = new LumchineGrouponRulesExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购活动是否已经过期
     *
     * @return
     */
    public boolean isExpired(LumchineGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购活动列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<LumchineGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        LumchineGrouponRulesExample example = new LumchineGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        LumchineGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(LumchineGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}