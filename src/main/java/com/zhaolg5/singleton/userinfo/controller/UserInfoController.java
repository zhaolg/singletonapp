package com.zhaolg5.singleton.userinfo.controller;

import com.zhaolg5.singleton.userinfo.bean.ResultMsg;
import com.zhaolg5.singleton.userinfo.bean.User;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import com.zhaolg5.singleton.userinfo.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = {"/userLogin"} ,method = {RequestMethod.GET,RequestMethod.POST} , produces = "application/json;charset=utf-8")
    public String userLogin(@Param(value = "code") String code,@Param(value = "userName") String userName)throws Exception{
        if(!StringUtils.isEmpty(code)){
            User user = userInfoSV.userLogin(code,userName);
            return BeanUtils.convertToJson(user);
        }else {
            ResultMsg errorMsg = new ResultMsg("10001","openId为空");
            return BeanUtils.convertToJson(errorMsg);
        }
    }

    @RequestMapping(value = {"/refreshUserInfo"} ,method = {RequestMethod.GET,RequestMethod.POST} , produces = "application/json;charset=utf-8")
    public String refreshUserInfo(@Param(value = "userId") String userId)throws Exception{
        if(!StringUtils.isEmpty(userId)){
            User user = userInfoSV.refreshUserInfo(Long.valueOf(userId));
            return BeanUtils.convertToJson(user);
        }else {
            ResultMsg errorMsg = new ResultMsg("10001","userId为空");
            return BeanUtils.convertToJson(errorMsg);
        }
    }


    @RequestMapping(value = {"/test"} ,method = {RequestMethod.GET,RequestMethod.POST} , produces = "application/json;charset=utf-8")
    public String test(@Param(value = "aa")String ss,@Param(value = "bb")String bb)throws Exception{

        System.out.println(ss);

        return null;
    }


}
