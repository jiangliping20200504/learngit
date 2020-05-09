package com.example.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdou on 05/01/2018.
 */
public class JsonHelp {
    public static String list2String(List<?> l) {
        return JSONArray.toJSONString(l);
    }

    public static String nullListString() {
        return JSONArray.toJSONString(new ArrayList());
    }

    public static String obj2String(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static <T> T string2Object(String str, Class<T> clazz) {
        return JSONObject.parseObject(str, clazz);
    }

    public static <T> List<T> string2List(String str, Class<T> clazz) {
        return JSONArray.parseArray(str, clazz);
    }

    public static String jsonArg(Object obj) {
        Map<String, String> map = new HashMap<>();
        map.put("jsonArg", JsonHelp.obj2String(obj));
        return JsonHelp.obj2String(map);
    }
    public static JSONObject String2JSON(String str) {
        return JSONObject.parseObject(str);
    }
}
