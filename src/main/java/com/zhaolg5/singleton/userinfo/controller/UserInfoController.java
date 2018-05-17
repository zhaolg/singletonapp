package com.zhaolg5.singleton.userinfo.controller;

import com.zhaolg5.singleton.userinfo.bean.User;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import com.zhaolg5.singleton.userinfo.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
@RestController
public class UserInfoController {

    @Autowired
    IUserInfoSV userInfoSV;

    @RequestMapping(value = {"/userlist"} ,method = {RequestMethod.GET,RequestMethod.POST} , produces = "application/json;charset=utf-8")
    public String getUserListAll(@Param(value = "userId") long userId) throws Exception {
        List<User> userList = userInfoSV.getUserList(userId);
        return BeanUtils.convertToJson(userList);
    }






}
