package com.zhaolg5.singleton.userinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaolg on 2018/6/6
 *
 * @return
 * @throws Exception
 */
@Controller
public class ErrorController {

    @RequestMapping(value = {"/error"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String error() throws Exception {
        return "error/404.html";
    }


}
