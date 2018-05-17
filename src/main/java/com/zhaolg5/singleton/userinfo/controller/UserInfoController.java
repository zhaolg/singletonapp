package com.zhaolg5.singleton.userinfo.controller;

import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String getUserListAll(){


        return null;
    }






}
