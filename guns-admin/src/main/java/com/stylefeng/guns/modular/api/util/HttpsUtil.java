package com.stylefeng.guns.modular.api.util;

import cn.hutool.http.HttpUtil;
import com.stylefeng.guns.core.support.HttpKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HttpsUtil implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(HttpsUtil.class);
    private final static String URL = "https://www.hk952183.com:40843/njhk-wisdom-datasys-web-api";

    //判断老人信息是否存在
    public static final String CUSTOMER_INFO_FINDCUSTOMER = "/customer/info/findCustomer";
    //判断老人填写问卷调查
    public static final String CUSTOMER_INFO_FINDQUESTIONNAIRECUSTOMER = "/customer/info/findQuestionnaireCustomer";
    //增加老人信息
    public static final String CUSTOMER_INFO_INSERTCUSTOMER = "/customer/info/insertCustomer";
    //上传结束走访照片
    public static final String CUSTOMER_INFO_OVER = "/customer/info/over";
    //上传开始走访照片
    public static final String CUSTOMER_INFO_START = "/customer/info/start";
    //修改老人信息
    public static final String CUSTOMER_INFO_UPDATECUSTOMER = "/customer/info/updateCustomer";
    //二次走访能力评估表接口
    public static final String CUSTOMER_INFO_UPDATESECONDVISITCUSTOMERS = "/customer/info/updateSecondVisitCustomers";
    //首次走访问卷信息接口
    public static final String CUSTOMER_INFO_UPDATEVISITCUSTOMERS = "/customer/info/updateVisitCustomers";
    //上传走访录音
    public static final String CUSTOMER_INFO_UPLOADRECORD = "/customer/info/uploadRecord";

    public Map<String, Object> map_temp = new HashMap<>();
    public String api = "";


    public void syncData() {
        String url = URL + api;
        String post = HttpUtil.post(url, map_temp);
        System.out.printf(post);
        logger.info(post);
    }

    public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        map.put("name",1);
        map.put("idNumber","1");
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.api=CUSTOMER_INFO_FINDCUSTOMER;
        httpsUtil.map_temp=map;
        Thread thread = new Thread(httpsUtil);
        thread.run();

    }

    @Override
    public void run() {
        syncData();
    }
}
