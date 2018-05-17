package com.zhaolg5.singleton.userinfo.service.impl;

import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.dao.interfaces.IUserInfoDAO;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@Service
public class UserInfoSVImpl implements IUserInfoSV {

    @Autowired
    IUserInfoDAO userInfoDAO;

    @Override
    public UserInfo findbyUserId(long userId) {
        Assert.state(userId > 0,"userId is <=0 ");
        return userInfoDAO.findbyUserId(userId);
    }

    @Override
    public void save(UserInfo userInfo) {
        Assert.notNull(userInfo);
        userInfoDAO.save(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        Assert.notNull(userInfo);

    }

    @Override
    public void delete(UserInfo userInfo) {

    }


}
