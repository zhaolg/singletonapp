package com.zhaolg5.singleton.userinfo.service.interfaces;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.User;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.bean.UserTag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@Transactional
public interface IUserInfoSV {

    public UserInfo findbyUserId(long userId);

    public UserInfo findByOpenId(String openId);

    public void  save(UserInfo userInfo);

    public void  saveImageInfoList(List<ImageInfo> imageInfos);

    public void  saveUserTagList(List<UserTag> userTags);

    public void update(UserInfo userInfo);

    public void delete(UserInfo userInfo);

    public List<User> getUserList(long userId) throws Exception;

    public User userLogin(String code,String userName)throws Exception;

    public void deleteImage(long userId,long sortId)throws Exception;

    public User refreshUserInfo(long userId)throws Exception;

}
