package com.zhaolg5.singleton.userinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaolg on 2018/6/6
 *
 * @author xmly
 * @return
 * @throws Exception
 */
@RestController
public class ErrorController {

    @RequestMapping(value = {"/error"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String error() throws Exception {
        return "error/404.html";
    }


}
