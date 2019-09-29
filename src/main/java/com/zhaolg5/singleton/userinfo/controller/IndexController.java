package com.zhaolg5.singleton.userinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : lingangzhao
 * @date : 2019/2/2 17:49
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/health")
    @ResponseBody
    public String health() {
        return "";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "error/404.html";
    }
}
