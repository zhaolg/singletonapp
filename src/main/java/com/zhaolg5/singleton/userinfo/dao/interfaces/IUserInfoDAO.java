package com.zhaolg5.singleton.userinfo.dao.interfaces;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.bean.UserTag;

import java.util.List;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
public interface IUserInfoDAO {

    public UserInfo findbyUserId(long userId);

    public UserInfo findByOpenId(String openId);

    public void save(UserInfo userInfo);

    public void  saveImageInfoList(List<ImageInfo> imageInfos);

    public void  saveUserTagList(List<UserTag> userTags);

    public List<UserInfo> findUserList(long userId)throws Exception;

    public List<ImageInfo> findOneByUserId(long userId)throws Exception;

    public List<UserTag>  findUsertagByUserId(long userId)throws Exception;

    public void deleteImage(long userId,long sortId)throws Exception;

}
