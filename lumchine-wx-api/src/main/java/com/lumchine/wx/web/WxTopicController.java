package com.lumchine.wx.web;

import com.lumchine.core.util.ResponseUtil;
import com.lumchine.core.validator.Order;
import com.lumchine.core.validator.Sort;
import com.lumchine.db.domain.LumchineGoods;
import com.lumchine.db.domain.LumchineTopic;
import com.lumchine.db.service.LumchineGoodsService;
import com.lumchine.db.service.LumchineTopicService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专题服务
 */
@RestController
@RequestMapping("/wx/topic")
@Validated
public class WxTopicController {
    private final Log logger = LogFactory.getLog(WxTopicController.class);

    @Autowired
    private LumchineTopicService topicService;
    @Autowired
    private LumchineGoodsService goodsService;

    /**
     * 专题列表
     *
     * @param page 分页页数
     * @param limit 分页大小
     * @return 专题列表
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<LumchineTopic> topicList = topicService.queryList(page, limit, sort, order);
        return ResponseUtil.okList(topicList);
    }

    /**
     * 专题详情
     *
     * @param id 专题ID
     * @return 专题详情
     */
    @GetMapping("detail")
    public Object detail(@NotNull Integer id) {
        LumchineTopic topic = topicService.findById(id);
        List<LumchineGoods> goods = new ArrayList<>();
        for (Integer i : topic.getGoods()) {
            LumchineGoods good = goodsService.findByIdVO(i);
            if (null != good)
                goods.add(good);
        }

        Map<String, Object> entity = new HashMap<String, Object>();
        entity.put("topic", topic);
        entity.put("goods", goods);
        return ResponseUtil.ok(entity);
    }

    /**
     * 相关专题
     *
     * @param id 专题ID
     * @return 相关专题
     */
    @GetMapping("related")
    public Object related(@NotNull Integer id) {
        List<LumchineTopic> topicRelatedList = topicService.queryRelatedList(id, 0, 4);
        return ResponseUtil.okList(topicRelatedList);
    }
}