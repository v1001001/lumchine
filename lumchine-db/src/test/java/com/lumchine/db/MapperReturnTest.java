package com.lumchine.db;

import com.lumchine.db.domain.LumchineSystem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.lumchine.db.dao.LumchineSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapperReturnTest {

    @Autowired
    private LumchineSystemMapper systemMapper;

    @Test
    public void test() {
        LumchineSystem system = new LumchineSystem();
        system.setKeyName("test-system-key");
        system.setKeyValue("test-system-value");
        int updates = systemMapper.insertSelective(system);
        Assert.assertEquals(updates, 1);

        updates = systemMapper.deleteByPrimaryKey(system.getId());
        Assert.assertEquals(updates, 1);

        updates = systemMapper.updateByPrimaryKey(system);
        Assert.assertEquals(updates, 0);
    }

}

