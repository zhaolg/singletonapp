package com.zhaolg5.singleton.userinfo.common;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.User;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.bean.UserTag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
@Service
public class UserBuilder {

    public UserInfo userInfo ;

    public List<UserTag> userTags = new ArrayList<>();

    public List<ImageInfo> imageInfos = new ArrayList<>();

    public static UserBuilder newInstance(){
        return new UserBuilder();
    }


    public  UserBuilder withUserInfo(UserInfo userInfo){
        this.userInfo =  userInfo;
        return this;
    }

    public  UserBuilder withUserTags(List<UserTag> userTags){
        this.userTags =  userTags;
        return this;
    }

    public  UserBuilder withImageInfos(List<ImageInfo> imageInfos){
        this.imageInfos =  imageInfos;
        return this;
    }

    public User build(){
       return new User(userInfo,userTags,imageInfos);
    }


}
