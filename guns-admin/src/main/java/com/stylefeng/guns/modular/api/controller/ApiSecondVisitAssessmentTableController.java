package com.stylefeng.guns.modular.api.controller;

import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.ISecondVisitAssessmentTableService;
import com.stylefeng.guns.modular.system.model.SecondVisitAssessmentTable;
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

@RestController
@RequestMapping("/api/apisecondvisitassessmenttablecontroller")
@Api(value = "采集人第二次走访能力评估controller", tags = {"采集人第二次走访能力评估接口"})
public class ApiSecondVisitAssessmentTableController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiSecondVisitAssessmentTableController.class);

    @Autowired
    private ISecondVisitAssessmentTableService secondVisitAssessmentTableService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人第二次走访能力评估")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "secondvisitName", value = "姓名", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitSex", value = "性别(0男 1女)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitIdcard", value = "身份证", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitAge", value = "年龄", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitOthercard", value = "社保卡号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitEthnic", value = "名族(0汉族 1其他)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitLevelOfEducation", value = "教育水平(1文盲 2小学 3初中 4高中/技校/中专 5大学专科及以上 6不详)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitMaritalStatus", value = "婚姻状况(1未婚   2 已婚   3丧偶   4离婚   5未说明的婚姻状况)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitAddress", value = "居住地址", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitHomePhone", value = "住宅电话", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitPhoneNumber", value = "手机号码", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitLivingSituation", value = "居住情况(1独自居住  2 与配偶居住  3 与子女居住  4 其他 )", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitMedical", value = "医疗费用支付方式(1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗  4贫困救助  5商业医疗保险  6全公费  7全自费  8其他)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitVisitObjectCategories", value = "走访对象类别(1低保  2低收入  3建档立卡贫困老人  4重点优抚对象)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitExpectationsPension", value = "期望的养老模式(0居家养老   1社区养老   2机构养老   3其他)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitExpectationsPensionServer", value = "期望的养老服务(0家政服务 1生活照料 2健康咨询 3精神慰藉 4陪同就医 5换季服务 6助浴服务 7助残服务 8助洁服务 9助餐服务 10 助行服务 11定制服务)", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitMedicalOtherText", value = "医疗支付方式其他对应文本", paramType = "query"),
            @ApiImplicitParam(required = true, name = "secondvisitExpectationsPensionOtherText", value = "期望的养老模式其他选择对应文本", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<SecondVisitAssessmentTable> add(SecondVisitAssessmentTable secondVisitAssessmentTable, int parentId) {
        if(secondVisitAssessmentTable.getId()!=null&&secondVisitAssessmentTable.getId()==-1)secondVisitAssessmentTable.setId(null);
        ResponseData<SecondVisitAssessmentTable> informationPersonalResponseData = new ResponseData<>();
        secondVisitAssessmentTable.setFaceIdentifyTopId(parentId);
        secondVisitAssessmentTableService.insert(secondVisitAssessmentTable);
        informationPersonalResponseData.setDataCollection(secondVisitAssessmentTable);
        return informationPersonalResponseData;
    }

}
