package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.IInformationPersonalService;
import com.stylefeng.guns.modular.face.service.IInformationServiceService;
import com.stylefeng.guns.modular.system.model.InformationHealth;
import com.stylefeng.guns.modular.system.model.InformationPersonal;
import com.stylefeng.guns.modular.system.model.InformationService;
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
@RequestMapping("/api/apiinformationservicecontroller")
@Api(value="采集人服务信息controller",tags={"采集人服务信息操作接口"})
public class ApiInformationServiceController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiInformationServiceController.class);

    @Autowired
   private IInformationServiceService iInformationServiceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人服务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "serviceType", value = "服务类型（1.信息服务，2.实体服务）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "phoneMeal", value = "用户手机套餐", paramType = "query"),
            @ApiImplicitParam(required = true, name = "phoneType", value = "用户手机型号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "personServiceType", value = "用户享受的服务类别", paramType = "query"),
            @ApiImplicitParam(required = true, name = "govNum", value = "政府援助次数", paramType = "query"),
            @ApiImplicitParam(required = true, name = "changeStatus", value = "状态变更原因", paramType = "query"),
            @ApiImplicitParam(required = true, name = "refuse", value = "审核拒绝原因", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id", paramType = "query"),
    })
    public ResponseData<InformationService> add(InformationService informationService, int parentId) throws Exception {
        ResponseData<InformationService> informationPersonalResponseData = new ResponseData<>();
        informationService.setParentId(parentId);
        informationService.setCreateDate(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        informationService.setStatus(0);
        iInformationServiceService.insert(informationService);
        informationPersonalResponseData.setDataCollection(informationService);
        return informationPersonalResponseData;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑采集人服务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "InformationService_id", paramType = "query"),
            @ApiImplicitParam(required = true, name = "serviceType", value = "服务类型（1.信息服务，2.实体服务）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "phoneMeal", value = "用户手机套餐", paramType = "query"),
            @ApiImplicitParam(required = true, name = "phoneType", value = "用户手机型号", paramType = "query"),
            @ApiImplicitParam(required = true, name = "personServiceType", value = "用户享受的服务类别", paramType = "query"),
            @ApiImplicitParam(required = true, name = "govNum", value = "政府援助次数", paramType = "query"),
            @ApiImplicitParam(required = true, name = "changeStatus", value = "状态变更原因", paramType = "query"),
            @ApiImplicitParam(required = true, name = "refuse", value = "审核拒绝原因", paramType = "query"),
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id", paramType = "query"),
    })
    public ResponseData<InformationService> edit(InformationService informationService, int parentId) throws Exception {
        ResponseData<InformationService> informationPersonalResponseData = new ResponseData<>();
        informationService.setCreateDate(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        iInformationServiceService.updateById(informationService);
        informationPersonalResponseData.setDataCollection(informationService);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ApiOperation("获取采集人服务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id", paramType = "query")
    })
    public ResponseData<InformationService> getData(Integer parentId) throws Exception {
        ResponseData<InformationService> informationPersonalResponseData = new ResponseData<>();
        EntityWrapper<InformationService> informationPersonalEntityWrapper = new EntityWrapper<>();
        informationPersonalEntityWrapper.eq("parentId",parentId);
        informationPersonalResponseData.setDataCollection(iInformationServiceService.selectOne(informationPersonalEntityWrapper));
        return informationPersonalResponseData;
    }
}
