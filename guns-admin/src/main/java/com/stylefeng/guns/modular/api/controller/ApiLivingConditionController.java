package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.IInformationServiceService;
import com.stylefeng.guns.modular.face.service.ILivingConditionService;
import com.stylefeng.guns.modular.system.model.InformationService;
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
@RequestMapping("/api/apilivingconditioncontroller")
@Api(value="采集人生活居住状况及社会关系controller",tags={"采集人生活居住状况及社会关系接口"})
public class ApiLivingConditionController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiLivingConditionController.class);

    @Autowired
   private ILivingConditionService livingConditionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人生活居住状况及社会关系")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "liveState", value = "居住状态(1其他情况,2与子女居住,3与配偶居住,4独居)", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "needHlep", value = "是否特困或者失能（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "firstHlep", value = "是否重点优抚（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "severeDisability", value = "是否重度残疾（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "threeNo", value = "是否城市三无（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "fiveInsurance", value = "是否农村五保（1是，2否）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "pestype", value = "人员类型（0特困失能 1重点优抚 2城市三五 3农村五保 4重度残疾 5其他）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "pestypeothertext", value = "人员类别其他文本", paramType = "query"),
            @ApiImplicitParam(required = true, name = "liveStateOtherText", value = "居住情况其他文本", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<LivingCondition> add(LivingCondition livingCondition, int parentId) throws Exception {
        if(livingCondition.getId()!=null&&livingCondition.getId()==-1)livingCondition.setId(null);
        ResponseData<LivingCondition> informationPersonalResponseData = new ResponseData<>();
        livingCondition.setParentId(parentId);
        livingCondition.setCreateDate(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        livingCondition.setStatus(0);
        livingConditionService.insert(livingCondition);
        informationPersonalResponseData.setDataCollection(livingCondition);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑采集人生活居住状况及社会关系")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "LivingCondition_id", paramType = "query"),
            @ApiImplicitParam(required = true, name = "liveState", value = "居住状态(1其他情况,2与子女居住,3与配偶居住,4独居)", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "needHlep", value = "是否特困或者失能（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "firstHlep", value = "是否重点优抚（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "severeDisability", value = "是否重度残疾（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "threeNo", value = "是否城市三无（1是，2否）", paramType = "query"),
//            @ApiImplicitParam(required = true, name = "fiveInsurance", value = "是否农村五保（1是，2否）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "pestype", value = "人员类型（0特困失能 1重点优抚 2城市三五 3农村五保 4重度残疾 5其他）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "pestypeothertext", value = "人员类别其他文本", paramType = "query"),
            @ApiImplicitParam(required = true, name = "liveStateOtherText", value = "居住情况其他文本", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<LivingCondition> edit(LivingCondition livingCondition, int parentId) throws Exception {
        ResponseData<LivingCondition> informationPersonalResponseData = new ResponseData<>();
        livingCondition.setUpdateDate(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        livingConditionService.updateById(livingCondition);
        informationPersonalResponseData.setDataCollection(livingCondition);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ApiOperation("获取采集人生活居住状况及社会关系")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query")
    })
    public ResponseData<LivingCondition> getData(Integer parentId) throws Exception {
        ResponseData<LivingCondition> informationPersonalResponseData = new ResponseData<>();
        EntityWrapper<LivingCondition> informationPersonalEntityWrapper = new EntityWrapper<>();
        informationPersonalEntityWrapper.eq("parentId",parentId);
        informationPersonalResponseData.setDataCollection(livingConditionService.selectOne(informationPersonalEntityWrapper));
        return informationPersonalResponseData;
    }
}
