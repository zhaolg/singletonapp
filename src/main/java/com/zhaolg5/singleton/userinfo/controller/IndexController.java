package com.zhaolg5.singleton.userinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lingangzhao
 * @date : 2019/2/2 17:49
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/health")
    @ResponseBody
    public String health() {
        return "";
    }

//    @RequestMapping(value = "/")
//    @ResponseBody
//    public String index() {
//        return "/static/index";
//    }
}
