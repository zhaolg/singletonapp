package com.zhaolg5.singleton.userinfo.bean;

import java.util.List;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
public class User {

    public UserInfo userInfo;

    public List<UserTag> userTags;

    public List<ImageInfo> imageInfos;

    public User() {
    }

    public User(UserInfo userInfo, List<UserTag> userTags, List<ImageInfo> imageInfos) {
        this.userInfo = userInfo;
        this.userTags = userTags;
        this.imageInfos = imageInfos;
    }

    public List<UserTag> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
    }

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

    public UserInfo getUserInfo() {

        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
