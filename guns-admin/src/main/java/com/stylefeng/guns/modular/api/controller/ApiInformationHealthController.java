package com.stylefeng.guns.modular.api.controller;

import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.IInformationHealthService;
import com.stylefeng.guns.modular.face.service.ILivingConditionService;
import com.stylefeng.guns.modular.system.model.InformationHealth;
import com.stylefeng.guns.modular.system.model.LivingCondition;
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
@RequestMapping("/api/apiinformationhealthcontroller")
@Api(value="采集人生活居住状况及社会关系controller",tags={"采集人生活居住状况及社会关系接口"})
public class ApiInformationHealthController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiInformationHealthController.class);

    @Autowired
   private IInformationHealthService informationHealthService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人生活居住状况及社会关系")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "hearing", value = "听力（1.良好，2.一般，3.很大声才能听见，4.听不见）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "helpHear", value = "是否佩戴助听器（1.是，2.否）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "health", value = "病史（1.健康   2.高血压   3.糖尿病   4.冠心病   5.恶性肿瘤   6.结核病   7.肝炎   8.脑卒中  9.精神疾病  10.慢性阻塞性肺疾病  11.慢性支气管炎  12.帕金森综合症  13.腰椎间盘突出  14.阿尔茨海默病  15.心脏病  16.肺气肿  17.白内障  18.脑血栓  19.风湿病  20.脑中风  21.高脂血症  22.哮喘  23.意外伤害  24.其他_____）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergy", value = "药物过敏情况", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergyHistory", value = "药物过敏史（1.是，2.否）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergyType", value = "过敏类型（1药物过敏  2化工金属  3植物过敏  4食物过敏  5动物过敏  6其他_____）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "everyEatDrugs", value = "经常服用药物", paramType = "query"),
            @ApiImplicitParam(required = true, name = "ziLiType", value = "老人自理类别（1自理  2失能  3半失能  4失智  5轻度依赖  6重度依赖  7不能自理）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergyTypeOtherText", value = "过敏类型其他对应文本"),
            @ApiImplicitParam(required = true, name = "healthOtherText", value = "病史其他对应文本"),
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id", paramType = "query"),
    })
    public ResponseData<InformationHealth> add(InformationHealth informationHealth, int parentId) throws Exception {
        ResponseData<InformationHealth> informationPersonalResponseData = new ResponseData<>();
        informationHealth.setParentId(parentId);
        informationHealthService.insert(informationHealth);
        informationPersonalResponseData.setDataCollection(informationHealth);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑采集人生活居住状况及社会关系")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "id", paramType = "query"),
            @ApiImplicitParam(required = true, name = "hearing", value = "听力（1.良好，2.一般，3.很大声才能听见，4.听不见）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "helpHear", value = "是否佩戴助听器（1.是，2.否）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "health", value = "病史（1.健康   2.高血压   3.糖尿病   4.冠心病   5.恶性肿瘤   6.结核病   7.肝炎   8.脑卒中  9.精神疾病  10.慢性阻塞性肺疾病  11.慢性支气管炎  12.帕金森综合症  13.腰椎间盘突出  14.阿尔茨海默病  15.心脏病  16.肺气肿  17.白内障  18.脑血栓  19.风湿病  20.脑中风  21.高脂血症  22.哮喘  23.意外伤害  24.其他_____）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergy", value = "药物过敏情况", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergyHistory", value = "药物过敏史（1.是，2.否）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergyType", value = "过敏类型（1药物过敏  2化工金属  3植物过敏  4食物过敏  5动物过敏  6其他_____）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "everyEatDrugs", value = "经常服用药物", paramType = "query"),
            @ApiImplicitParam(required = true, name = "ziLiType", value = "老人自理类别（1自理  2失能  3半失能  4失智  5轻度依赖  6重度依赖  7不能自理）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "allergyTypeOtherText", value = "过敏类型其他对应文本"),
            @ApiImplicitParam(required = true, name = "healthOtherText", value = "病史其他对应文本"),
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id", paramType = "query"),
    })
    public ResponseData<InformationHealth> edit(InformationHealth informationHealth, int parentId) throws Exception {
        ResponseData<InformationHealth> informationPersonalResponseData = new ResponseData<>();
        informationHealth.setParentId(parentId);
        informationHealthService.updateById(informationHealth);
        informationPersonalResponseData.setDataCollection(informationHealth);
        return informationPersonalResponseData;
    }

}
