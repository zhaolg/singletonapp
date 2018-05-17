package com.zhaolg5.singleton.userinfo.service.impl;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.User;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.bean.UserTag;
import com.zhaolg5.singleton.userinfo.common.UserBuilder;
import com.zhaolg5.singleton.userinfo.dao.interfaces.IUserInfoDAO;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoSVImpl implements IUserInfoSV {

    private Logger log = LoggerFactory.getLogger(IUserInfoSV.class);

    @Autowired
    IUserInfoDAO userInfoDAO;

    @Autowired
    UserBuilder userBuilder;

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
    public void saveImageInfoList(List<ImageInfo> imageInfos) {
        userInfoDAO.saveImageInfoList(imageInfos);
    }

    @Override
    public void saveUserTagList(List<UserTag> userTags) {
        userInfoDAO.saveUserTagList(userTags);
    }

    @Override
    public void update(UserInfo userInfo) {
        Assert.notNull(userInfo);

    }

    @Override
    public void delete(UserInfo userInfo) {

    }

    @Override
    public List<User> getUserList(long userId) throws Exception{
        Assert.state(userId > 0,"userId is <=0 ");
        List<UserInfo> userList = userInfoDAO.findUserList(userId);
        List<User> users = new ArrayList<>();
        if(! ObjectUtils.isEmpty(userList)){
            for (UserInfo userInfo :userList){
                List<ImageInfo> oneByUserId = userInfoDAO.findOneByUserId(userInfo.getUserId());
                List<UserTag> usertagByUserId = userInfoDAO.findUsertagByUserId(userInfo.getUserId());
                User build = UserBuilder.newInstance().withUserInfo(userInfo).withImageInfos(oneByUserId).withUserTags(usertagByUserId).build();
                users.add(build);
            }
        }else {
            if(log.isErrorEnabled()){
                log.error("当前系统无推荐人员可用！！！");
            }
        }
        return users;
    }


}
