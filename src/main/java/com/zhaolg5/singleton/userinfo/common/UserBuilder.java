package com.zhaolg5.singleton.userinfo.common;

import com.zhaolg5.singleton.userinfo.bean.*;
import com.zhaolg5.singleton.userinfo.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        if(userInfo != null){
            userInfo.setAge(DateUtils.getAgeByBirth(userInfo.getBirthday()));
            this.userInfo =  userInfo;
        }
        return this;
    }

    public  UserBuilder withUserTags(List<UserTag> userTags){
        if(!ObjectUtils.isEmpty(userTags)){
            this.userTags =  userTags;
        }
        return this;
    }

    public  UserBuilder withImageInfos(List<ImageInfo> imageInfos){
        if(!ObjectUtils.isEmpty(imageInfos)){
            for (ImageInfo value : imageInfos ){
                value.setImageUrl(Constant.IMAGE_GLOBALDATA + value.getImageUrl());
            }
            this.imageInfos =  imageInfos;
        }
        return this;
    }

    public User build(){
       return new User(userInfo,userTags,imageInfos);
    }




}
