package com.lumchine.db.service;

import com.lumchine.db.dao.LumchineSystemMapper;
import com.lumchine.db.domain.LumchineSystem;
import com.lumchine.db.domain.LumchineSystemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LumchineSystemConfigService {
    @Autowired
    private LumchineSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        LumchineSystemExample example = new LumchineSystemExample();
        example.or().andDeletedEqualTo(false);

        List<LumchineSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (LumchineSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        LumchineSystemExample example = new LumchineSystemExample();
        example.or().andKeyNameLike("lumchine_mall_%").andDeletedEqualTo(false);
        List<LumchineSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(LumchineSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        LumchineSystemExample example = new LumchineSystemExample();
        example.or().andKeyNameLike("lumchine_wx_%").andDeletedEqualTo(false);
        List<LumchineSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(LumchineSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        LumchineSystemExample example = new LumchineSystemExample();
        example.or().andKeyNameLike("lumchine_order_%").andDeletedEqualTo(false);
        List<LumchineSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(LumchineSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        LumchineSystemExample example = new LumchineSystemExample();
        example.or().andKeyNameLike("lumchine_express_%").andDeletedEqualTo(false);
        List<LumchineSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(LumchineSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            LumchineSystemExample example = new LumchineSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            LumchineSystem system = new LumchineSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        LumchineSystem system = new LumchineSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
