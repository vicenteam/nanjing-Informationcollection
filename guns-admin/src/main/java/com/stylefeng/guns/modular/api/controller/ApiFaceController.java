package com.stylefeng.guns.modular.api.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.face.AipFace;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.api.model.user.FaceInfoModel;
import com.stylefeng.guns.modular.face.FaceMode;
import com.stylefeng.guns.modular.face.FaceUser;
import com.stylefeng.guns.modular.face.FaceUtil;
import com.stylefeng.guns.modular.system.model.FaceIdentifyTop;
import com.stylefeng.guns.modular.system.service.IFaceIdentifyTopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/apifacecontroller")
@Api(value="人脸识别controller",tags={"人脸识别接口"})
public class ApiFaceController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiFaceController.class);
    @Autowired
    private IFaceIdentifyTopService faceIdentifyTopService;

    @RequestMapping(value = "/findImgBase64", method = RequestMethod.POST)
    @ApiOperation("图片识别")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "imgBase64", value = "识别图片base64字符串"),
            @ApiImplicitParam(required = true, name = "deptId", value = "操作人deptId"),
    })
    public ResponseData<FaceInfoModel> findImgBase64(String imgBase64,String deptId) throws Exception {
        ResponseData<FaceInfoModel> responseData = new ResponseData();
        AipFace client = new AipFace(FaceUtil.APP_ID, FaceUtil.API_KEY, FaceUtil.SECRET_KEY);
        FaceUtil faceUtil = new FaceUtil();
        JSONObject user = faceUtil.findUser(client, imgBase64, deptId);
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
//            String deptId = faceUser.getGroup_id();
            String user_id = faceUser.getUser_id();
            Double score = faceUser.getScore();
            if (score >= 80) {//图片相似率
                //数据处理
                //提示二次采集信息
                String user_info = faceUser.getUser_info();
                FaceInfoModel faceInfoModel = JSON.parseObject(user_info, FaceInfoModel.class);
                faceInfoModel.setType(0);
                faceInfoModel.setImgUrl("");
                EntityWrapper<FaceIdentifyTop> faceIdentifyTopEntityWrapper = new EntityWrapper<>();
                faceIdentifyTopEntityWrapper.eq("idcard",faceInfoModel.getIdCard());
                FaceIdentifyTop faceIdentifyTop = faceIdentifyTopService.selectOne(faceIdentifyTopEntityWrapper);
                faceInfoModel.setImgBase64(faceIdentifyTop.getImgbase64());
                responseData.setDataCollection(faceInfoModel);

            }else {
                //进行百度group注册
//                 user = faceUtil.userRegister(client,"{name:\"张三\",idCard:\"15645456\",imgUrl:\"45314.jpg\"}",imgBase64,ShiroKit.getUser().getDeptId()+"","15645456");
                //提示第一次采集
                FaceInfoModel faceInfoModel=new FaceInfoModel();
                faceInfoModel.setType(1);
                faceInfoModel.setIdCard("");
                faceInfoModel.setName("");
                faceInfoModel.setImgUrl("");
                responseData.setDataCollection(faceInfoModel);
            }

//                    userAttendanceEntityWrapper.eq("")
            //返回结果
        } else {
            throw new Exception("暂无匹配数据");
        }
        return responseData;
    }

    @RequestMapping(value = "/faceRegistered", method = RequestMethod.POST)
    @ApiOperation("人脸注册")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "imgBase64", value = "注册图片base64字符串"),
            @ApiImplicitParam(required = true, name = "name", value = "姓名"),
            @ApiImplicitParam(required = true, name = "idCard", value = "身份证"),
            @ApiImplicitParam(required = true, name = "deptId", value = "部门Id"),
    })
    public ResponseData faceRegistered(String imgBase64,String name,String idCard,String deptId){
        ResponseData responseData=new ResponseData();
        AipFace client = new AipFace(FaceUtil.APP_ID, FaceUtil.API_KEY, FaceUtil.SECRET_KEY);
        FaceUtil faceUtil = new FaceUtil();
        JSONObject jsonObject = faceUtil.userRegister(client, "{name:\""+name+"\",idCard:\""+idCard+"\",imgUrl:\"\" }", imgBase64, deptId, idCard);
        System.out.println(jsonObject);
        //存入数据库
        FaceIdentifyTop faceIdentifyTop = new FaceIdentifyTop();
        faceIdentifyTop.setDeptid(Integer.parseInt(deptId));
        faceIdentifyTop.setIdcard(idCard);
        faceIdentifyTop.setImgbase64(imgBase64);
        faceIdentifyTop.setCreatetime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        faceIdentifyTop.setUsername(name);
        faceIdentifyTop.insert();
        return responseData;
    }
}
