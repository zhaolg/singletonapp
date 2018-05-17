package com.zhaolg5.singleton.userinfo.utils;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
public class BeanUtils {

    private static Logger log = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * List --> json
     */
    public static <T> String convertToJson(List<T> beans){
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(beans,jsonConfig);
        return jsonArray.toString();
    }



}
