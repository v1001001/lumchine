package com.lumchine.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.lumchine.core.qcode.QCodeService;
import com.lumchine.db.domain.LumchineGoods;
import com.lumchine.db.service.LumchineGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateShareImageTest {
    @Autowired
    QCodeService qCodeService;
    @Autowired
    LumchineGoodsService lumchineGoodsService;

    @Test
    public void test() {
        LumchineGoods good = lumchineGoodsService.findById(1181010);
        qCodeService.createGoodShareImage(good.getId().toString(), good.getPicUrl(), good.getName());
    }
}
