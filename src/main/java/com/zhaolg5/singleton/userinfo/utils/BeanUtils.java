package com.zhaolg5.singleton.userinfo.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.collections.map.ListOrderedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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

    /**
     * bean --> json
     */
    public static  String convertToJson(Object value){
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(value,jsonConfig);
        return jsonArray.toString();
    }

    /**
     * json -- Map
     */
    public static Map<String, Object> convertToMap(String jsonStr) {
        ListOrderedMap map = new ListOrderedMap();
        JSONObject json = JSONObject.fromObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(convertToMap(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

}
