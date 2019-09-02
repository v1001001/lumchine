package com.lumchine.wx.service;

import com.lumchine.db.domain.LumchineUser;
import com.lumchine.db.service.LumchineUserService;
import com.lumchine.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private LumchineUserService userService;


    public UserInfo getInfo(Integer userId) {
        LumchineUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
