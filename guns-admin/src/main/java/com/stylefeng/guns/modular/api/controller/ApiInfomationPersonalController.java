package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.api.model.user.UserModel;
import com.stylefeng.guns.modular.api.util.HttpsUtil;
import com.stylefeng.guns.modular.api.util.ReflectionObject;
import com.stylefeng.guns.modular.face.service.IInformationPersonalService;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.model.Dept;
import com.stylefeng.guns.modular.system.model.InformationPersonal;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/apiinfomationpersonalcontroller")
@Api(value = "采集人基础信息controller", tags = {"采集人基础信息操作接口"})
public class ApiInfomationPersonalController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiInfomationPersonalController.class);

    @Autowired
    private IInformationPersonalService iInformationPersonalService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人基础信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "fullName", value = "姓名", paramType = "query"),
            @ApiImplicitParam(required = true, name = "sex", value = "性别", paramType = "query"),
            @ApiImplicitParam(required = true, name = "minZu", value = "民族", paramType = "query"),
            @ApiImplicitParam(required = true, name = "age", value = "年龄", paramType = "query"),
            @ApiImplicitParam(required = true, name = "birthDate", value = "出生日期", paramType = "query"),
            @ApiImplicitParam(required = true, name = "cardId", value = "身份证号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "telephone", value = "手机号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "telHome", value = "座机", paramType = "query"),
            @ApiImplicitParam(required = true, name = "userType", value = "用户类型(1.政府援助用户,2.商业用户)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "areaType", value = "生活区域(1.城市,2.农村)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "address", value = "地址", paramType = "query"),
            @ApiImplicitParam(required = true, name = "nowAddress", value = "现居住地址", paramType = "query"),
            @ApiImplicitParam(required = true, name = "maritalStatus", value = "婚姻状况(1.未婚，2.已婚，3.离异，4.丧偶)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "economics", value = "经济来源（1.养老金，2.子女供养，3.救济优抚，4.兼职，5.其他）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "certificateNum", value = "证号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "certificateNumType", value = "证号类型（1.低保，2.优抚，3.失独，4.其他）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "oldPosition", value = "退休前职位", paramType = "query"),
            @ApiImplicitParam(required = true, name = "hobby", value = "爱好", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query")
    })
    public ResponseData<InformationPersonal> add(InformationPersonal informationPersonal, int parentId) throws Exception {
        if (informationPersonal.getId() != null && informationPersonal.getId() == -1) informationPersonal.setId(null);
        ResponseData<InformationPersonal> informationPersonalResponseData = new ResponseData<>();
        informationPersonal.setParentId(parentId);
        informationPersonal.setCreateDate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        informationPersonal.setStatus(0);
        iInformationPersonalService.insert(informationPersonal);
        informationPersonalResponseData.setDataCollection(informationPersonal);

        Map<String, Object> map = new HashMap<>();
        map.put("name", informationPersonal.getFullName());
        map.put("phone", informationPersonal.getTelephone());
        map.put("sex", informationPersonal.getSex());
        map.put("nation", informationPersonal.getMinZu());
        map.put("age", informationPersonal.getAge());
        map.put("birthday", informationPersonal.getBirthDate());
        map.put("idNumber", informationPersonal.getCardId());
        map.put("type", informationPersonal.getUserType() != null && informationPersonal.getUserType() == 1 ? "1" : "2");
        map.put("lifeAreas", informationPersonal.getAreaType() != null && informationPersonal.getAreaType() == 1 ? 1 : 2);
        map.put("address", informationPersonal.getAddress());
        map.put("currentAddress", informationPersonal.getNowAddress());
        map.put("belongAddressName", "南京分公司");
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.api = HttpsUtil.CUSTOMER_INFO_INSERTCUSTOMER;
        httpsUtil.map_temp = map;
        Thread thread = new Thread(httpsUtil);
        thread.run();
        return informationPersonalResponseData;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑采集人基础信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "InformationPersonal_id", paramType = "query"),
            @ApiImplicitParam(required = true, name = "fullName", value = "姓名", paramType = "query"),
            @ApiImplicitParam(required = true, name = "sex", value = "性别", paramType = "query"),
            @ApiImplicitParam(required = true, name = "minZu", value = "民族", paramType = "query"),
            @ApiImplicitParam(required = true, name = "age", value = "年龄", paramType = "query"),
            @ApiImplicitParam(required = true, name = "birthDate", value = "出生日期", paramType = "query"),
            @ApiImplicitParam(required = true, name = "cardId", value = "身份证号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "telephone", value = "手机号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "telHome", value = "座机", paramType = "query"),
            @ApiImplicitParam(required = true, name = "userType", value = "用户类型(1.政府援助用户,2.商业用户)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "areaType", value = "生活区域(1.城市,2.农村)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "address", value = "地址", paramType = "query"),
            @ApiImplicitParam(required = true, name = "nowAddress", value = "现居住地址", paramType = "query"),
            @ApiImplicitParam(required = true, name = "maritalStatus", value = "婚姻状况(1.未婚，2.已婚，3.离异，4.丧偶)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "economics", value = "经济来源（1.养老金，2.子女供养，3.救济优抚，4.兼职，5.其他）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "certificateNum", value = "证号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "certificateNumType", value = "证号类型（1.低保，2.优抚，3.失独，4.其他）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "oldPosition", value = "退休前职位", paramType = "query"),
            @ApiImplicitParam(required = true, name = "hobby", value = "爱好", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query")
    })
    public ResponseData<InformationPersonal> edit(InformationPersonal informationPersonal) throws Exception {
        ResponseData<InformationPersonal> informationPersonalResponseData = new ResponseData<>();
        informationPersonal.setUpdateDate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        iInformationPersonalService.updateById(informationPersonal);
        informationPersonalResponseData.setDataCollection(informationPersonal);

        Map<String, Object> map = new HashMap<>();
        map.put("name", informationPersonal.getFullName());
        map.put("phone", informationPersonal.getTelephone());
        map.put("sex", informationPersonal.getSex());
        map.put("nation", informationPersonal.getMinZu());
        map.put("age", informationPersonal.getAge());
        map.put("birthday", informationPersonal.getBirthDate());
        map.put("idNumber", informationPersonal.getCardId());
        map.put("type", informationPersonal.getUserType() != null && informationPersonal.getUserType() == 1 ? "1" : "2");
        map.put("lifeAreas", informationPersonal.getAreaType() != null && informationPersonal.getAreaType() == 1 ? "1" : "2");
        map.put("address", informationPersonal.getAddress());
        map.put("currentAddress", informationPersonal.getNowAddress());
        map.put("belongAddressName", "南京分公司");
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.api = HttpsUtil.CUSTOMER_INFO_UPDATECUSTOMER;
        httpsUtil.map_temp = map;
        Thread thread = new Thread(httpsUtil);
        thread.run();
        return informationPersonalResponseData;
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ApiOperation("获取采集人基础信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query")
    })
    public ResponseData<InformationPersonal> getData(Integer parentId) throws Exception {
        ResponseData<InformationPersonal> informationPersonalResponseData = new ResponseData<>();
        EntityWrapper<InformationPersonal> informationPersonalEntityWrapper = new EntityWrapper<>();
        informationPersonalEntityWrapper.eq("parentId", parentId);
        InformationPersonal informationPersonal = iInformationPersonalService.selectOne(informationPersonalEntityWrapper);
        informationPersonalResponseData.setDataCollection(informationPersonal);
        return informationPersonalResponseData;
    }
}
