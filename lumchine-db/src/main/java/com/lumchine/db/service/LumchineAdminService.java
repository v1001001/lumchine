package com.lumchine.db.service;

import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineAdminMapper;
import com.lumchine.db.domain.LumchineAdmin;
import com.lumchine.db.domain.LumchineAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LumchineAdminService {
    private final LumchineAdmin.Column[] result = new LumchineAdmin.Column[]{LumchineAdmin.Column.id, LumchineAdmin.Column.username, LumchineAdmin.Column.avatar, LumchineAdmin.Column.roleIds};
    @Resource
    private LumchineAdminMapper adminMapper;

    public List<LumchineAdmin> findAdmin(String username) {
        LumchineAdminExample example = new LumchineAdminExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }

    public LumchineAdmin findAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public List<LumchineAdmin> querySelective(String username, Integer page, Integer limit, String sort, String order) {
        LumchineAdminExample example = new LumchineAdminExample();
        LumchineAdminExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adminMapper.selectByExampleSelective(example, result);
    }

    public int updateById(LumchineAdmin admin) {
        admin.setUpdateTime(LocalDateTime.now());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LumchineAdmin admin) {
        admin.setAddTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.insertSelective(admin);
    }

    public LumchineAdmin findById(Integer id) {
        return adminMapper.selectByPrimaryKeySelective(id, result);
    }

    public List<LumchineAdmin> all() {
        LumchineAdminExample example = new LumchineAdminExample();
        example.or().andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }
}
