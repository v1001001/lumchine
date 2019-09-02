package com.lumchine.db.service;

import com.lumchine.db.dao.LumchinePermissionMapper;
import com.lumchine.db.domain.LumchinePermission;
import com.lumchine.db.domain.LumchinePermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LumchinePermissionService {
    @Resource
    private LumchinePermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        LumchinePermissionExample example = new LumchinePermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<LumchinePermission> permissionList = permissionMapper.selectByExample(example);

        for(LumchinePermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        LumchinePermissionExample example = new LumchinePermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<LumchinePermission> permissionList = permissionMapper.selectByExample(example);

        for(LumchinePermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        LumchinePermissionExample example = new LumchinePermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        LumchinePermissionExample example = new LumchinePermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(LumchinePermission lumchinePermission) {
        lumchinePermission.setAddTime(LocalDateTime.now());
        lumchinePermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(lumchinePermission);
    }
}
