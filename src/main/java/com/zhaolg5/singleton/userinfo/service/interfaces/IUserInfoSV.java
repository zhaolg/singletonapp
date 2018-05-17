package com.zhaolg5.singleton.userinfo.service.interfaces;

import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@Transactional
public interface IUserInfoSV {

    public UserInfo findbyUserId(long userId);

    public void  save(UserInfo userInfo);

    public void update(UserInfo userInfo);

    public void delete(UserInfo userInfo);


}
