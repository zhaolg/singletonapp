package com.zhaolg5.singleton.userinfo.dao.impl;

import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.dao.UserinfoRepository;
import com.zhaolg5.singleton.userinfo.dao.interfaces.IUserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
@Service
public class UserInfoDAOImpl implements IUserInfoDAO {

    @Autowired
    UserinfoRepository userinfoRepository;

    @Override
    public UserInfo findbyUserId(long userId) {
        Assert.state(userId>-1);
        return userinfoRepository.findOneByUserId(userId);
    }

    @Override
    public void save(UserInfo userInfo) {
        Assert.notNull(userInfo);
        userinfoRepository.save(userInfo);
    }
}
