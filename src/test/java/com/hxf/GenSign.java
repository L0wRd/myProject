package com.hxf;

import java.util.TreeMap;

/**
 * @author: hxf
 * @date: 2019/12/27 10:54
 * @description:
 */
public class GenSign {

    private static String secret = "adsads123";

    public static void main(String[] args) {
        TreeMap<String, String> param = new TreeMap<>();
//        param.put("contentType", "2");
//        param.put("appCode", "GP_APP");
//        param.put("openId", "oYNyl5MkqUA0kYHU4duq-5CKjLNM");
//        param.put("id", "5");
//        param.put("phone", "13795480079");
//        param.put("meid", "99001331000442");
//        param.put("imei1", "860682040008850");
//        param.put("imei2", "860682040008868");
//        param.put("createUser", "admin");
//        param.put("wxType", "1");
//        param.put("name", "薄悦");
//        param.put("idNumber", "310222999128317931");
//        param.put("userId", "680549");
//        param.put("updateUser", "680549");
//        param.put("wxCode", "baoyue111884");
//        param.put("ban", "0");
        param.put("openId", "o95gkv-IkkTr8JHcHj4AHSQ_La3k");
        param.put("associateId", "381");
        System.out.println(genSign(param));
    }

    public static String genSign(TreeMap<String, String> param) {
        StringBuilder sb = new StringBuilder();
        for (String key : param.keySet()) {
            sb.append(key).append("=").append(param.get(key)).append("&");
        }
        String s = sb.deleteCharAt(sb.length() - 1).append(secret).toString();
//        String s = "ban=0&id=5&idNumber=310222999128317931&imei1=860682040008850&imei2=860682040008868&meid=99001331000442&name=薄悦&phone=13795480079&updateUser=680549&userId=680549&wxCode=baoyue111884&wxType=1hxf20191227";
        System.out.println(s);
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(s);
    }
}
