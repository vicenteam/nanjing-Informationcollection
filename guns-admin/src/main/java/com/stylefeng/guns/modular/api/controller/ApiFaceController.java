package com.stylefeng.guns.modular.api.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.face.AipFace;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.FaceMode;
import com.stylefeng.guns.modular.face.FaceUser;
import com.stylefeng.guns.modular.face.FaceUtil;
import com.stylefeng.guns.modular.system.model.User;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/apifacecontroller")
public class ApiFaceController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiFaceController.class);


    public ResponseData findImgBase64(String imgBase64) throws Exception {
        ResponseData responseData = new ResponseData();
        AipFace client = new AipFace(FaceUtil.APP_ID, FaceUtil.API_KEY, FaceUtil.SECRET_KEY);
        FaceUtil faceUtil = new FaceUtil();
        JSONObject user = faceUtil.findUser(client, imgBase64, ShiroKit.getUser().getDeptId() + "");
        if (user.getString("error_msg").equals("liveness check fail")) {
            log.info("活性检查失败");
            throw new Exception("暂无匹配数据");
        } else if (user.getString("error_msg").equals("pic not has face")) {
            log.info("照片没有脸");
            throw new Exception("无效图片");
        }
        FaceMode faceMode = JSON.parseObject(user.toString(2), FaceMode.class);
        if (faceMode != null && faceMode.getResult() != null && faceMode.getResult().getUser_list().size() >= 1) {
            //数据转换
            FaceUser faceUser = faceMode.getResult().getUser_list().get(0);
            String deptId = faceUser.getGroup_id();
            String user_id = faceUser.getUser_id();
            Double score = faceUser.getScore();
            if (score >= 60) {//图片相似率
                //数据处理
                //提示二次采集信息

            }else {
                //进行百度group注册
                 user = faceUtil.userRegister(client,"",imgBase64,ShiroKit.getUser().getDeptId()+"","");
                //提示第一次采集

            }

//                    userAttendanceEntityWrapper.eq("")
            //返回结果
        } else {
            throw new Exception("暂无匹配数据");
        }
        return responseData;
    }
}
