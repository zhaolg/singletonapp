package com.zhaolg5.singleton.userinfo.dao.impl;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.bean.UserTag;
import com.zhaolg5.singleton.userinfo.dao.ImageInfoRepository;
import com.zhaolg5.singleton.userinfo.dao.UserinfoRepository;
import com.zhaolg5.singleton.userinfo.dao.UsertagRepository;
import com.zhaolg5.singleton.userinfo.dao.interfaces.IUserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Autowired
    ImageInfoRepository imageInfoRepository;

    @Autowired
    UsertagRepository usertagRepository;

    @Override
    public UserInfo findbyUserId(long userId) {
        Assert.state(userId>-1);
        return userinfoRepository.findOneByUserId(userId);
    }

    @Override
    public UserInfo findByOpenId(String openId) {
        return userinfoRepository.findUserInfoByOpenId(openId);
    }

    @Override
    public void save(UserInfo userInfo) {
        Assert.notNull(userInfo);
        userinfoRepository.save(userInfo);
    }

    @Override
    public void saveImageInfoList(List<ImageInfo> imageInfos) {
        Assert.notEmpty(imageInfos);
        imageInfoRepository.saveAll(imageInfos);
    }

    @Override
    public void saveUserTagList(List<UserTag> userTags) {
        Assert.notEmpty(userTags);
        usertagRepository.saveAll(userTags);
    }

    @Override
    public List<UserInfo> findUserList(long userId) {
        Pageable pageable = new PageRequest(0,10);
        Page<UserInfo> all = userinfoRepository.findAll(pageable);
        Iterator<UserInfo> iterator = all.iterator();
        List<UserInfo> rtnList = new ArrayList<>();
        while (iterator.hasNext()){
            rtnList.add(iterator.next());
        }
        return rtnList;
    }

    @Override
    public List<ImageInfo> findOneByUserId(long userId) throws Exception {
        return imageInfoRepository.findOneByUserId(userId);
    }

    @Override
    public List<UserTag> findUsertagByUserId(long userId) throws Exception {
        return usertagRepository.findOneByUserId(userId);
    }

    @Override
    public void deleteImage(long userId, long sortId) throws Exception {
        imageInfoRepository.deleteImageInfosByUserIdAndSortId(userId,sortId);
    }
}
