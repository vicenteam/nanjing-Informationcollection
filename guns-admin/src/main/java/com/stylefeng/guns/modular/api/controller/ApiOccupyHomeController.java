package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.ILivingConditionService;
import com.stylefeng.guns.modular.face.service.IOccupyHomeService;
import com.stylefeng.guns.modular.system.model.LivingCondition;
import com.stylefeng.guns.modular.system.model.OccupyHome;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/apioccupyhomecontroller")
@Api(value="采集人居家养老信息controller",tags={"采集人居家养老信息接口"})
public class ApiOccupyHomeController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiOccupyHomeController.class);

    @Autowired
   private IOccupyHomeService occupyHomeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人生居家养老信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "occupyHomeType", value = "老人类别(0特困老人  1低保老人  2建档立卡贫困老人优抚对象  3失独老人  4残疾老人 \n" +
                    "5计划生育特殊家庭成员  6其他 7空巢老人  8农村留守老人_)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeGovernmentPurchases", value = "政府购买对象(0 70岁以上享受城乡低保待遇  1 80岁以上重点优抚对象 2 80岁以上失独老人)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeUpStandard1", value = "达到标准1(0介助   1介护)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeUpStandard2", value = "达到标准1(0介助   1介护)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeGovernmentToBuy", value = "是否为政府购买对象(0 是 1否)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeExpectPension", value = "期望养老模式(0居家养老      1社区养老      2机构养老      3其他)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeExpectServer", value = "期望的服务(0家政服务 1生活照料 2健康咨询  3精神慰藉  4陪同就医  5换季服务 )", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeTypeOtherText", value = "老人类别其他对应文本"),
            @ApiImplicitParam(required = true, name = "occupyHomeExpectPensionOtherText", value = "期望养老模式其他类型对应文本"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<OccupyHome> add(OccupyHome occupyHome, int parentId) {
        if(occupyHome.getId()!=null&&occupyHome.getId()==-1)occupyHome.setId(null);
        ResponseData<OccupyHome> informationPersonalResponseData = new ResponseData<>();
        occupyHome.setParentId(parentId);
        occupyHomeService.insert(occupyHome);
        informationPersonalResponseData.setDataCollection(occupyHome);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑采集人生居家养老信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "OccupyHome_id" +
                    "5计划生育特殊家庭成员  6其他 7空巢老人  8农村留守老人_)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeGovernmentPurchases", value = "政府购买对象(0 70岁以上享受城乡低保待遇  1 80岁以上重点优抚对象 2 80岁以上失独老人)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeUpStandard1", value = "达到标准1(0介助   1介护)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeUpStandard2", value = "达到标准1(0介助   1介护)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeGovernmentToBuy", value = "是否为政府购买对象(0 是 1否)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeExpectPension", value = "期望养老模式(0居家养老      1社区养老      2机构养老      3其他)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeExpectServer", value = "期望的服务(0家政服务 1生活照料 2健康咨询  3精神慰藉  4陪同就医  5换季服务 )", paramType = "query"),
            @ApiImplicitParam(required = true, name = "occupyHomeTypeOtherText", value = "老人类别其他对应文本" ),
            @ApiImplicitParam(required = true, name = "occupyHomeExpectPensionOtherText", value = "期望养老模式其他类型对应文本" ),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<OccupyHome> edit(OccupyHome occupyHome, int parentId) {
        ResponseData<OccupyHome> informationPersonalResponseData = new ResponseData<>();
        occupyHome.setParentId(parentId);
        occupyHomeService.updateById(occupyHome);
        informationPersonalResponseData.setDataCollection(occupyHome);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ApiOperation("获取采集人居家养老信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query")
    })
    public ResponseData<OccupyHome> getData(Integer parentId) throws Exception {
        ResponseData<OccupyHome> informationPersonalResponseData = new ResponseData<>();
        EntityWrapper<OccupyHome> informationPersonalEntityWrapper = new EntityWrapper<>();
        informationPersonalEntityWrapper.eq("parentId",parentId);
        informationPersonalResponseData.setDataCollection(occupyHomeService.selectOne(informationPersonalEntityWrapper));
        return informationPersonalResponseData;
    }
}
