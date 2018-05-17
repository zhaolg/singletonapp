package com.zhaolg5.singleton.userinfo.dao.interfaces;

import com.zhaolg5.singleton.userinfo.bean.UserInfo;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
public interface IUserInfoDAO {

    public UserInfo findbyUserId(long userId);

    public void save(UserInfo userInfo);

}
