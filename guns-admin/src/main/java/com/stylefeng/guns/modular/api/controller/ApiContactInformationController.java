package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.IContactInformationService;
import com.stylefeng.guns.modular.face.service.IOccupyHomeService;
import com.stylefeng.guns.modular.system.model.ContactInformation;
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

@RestController
@RequestMapping("/api/apicontactinformationcontroller")
@Api(value="采集人紧急联系人controller",tags={"采集人紧急联系人接口"})
public class ApiContactInformationController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiContactInformationController.class);

    @Autowired
   private IContactInformationService iContactInformationService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人紧急联系人")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "occupyHomeType", value = "志愿者一"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers1Phone", value = "志愿者一电话"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers2", value = "志愿者二"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers2Phone", value = "志愿者二电话"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers3", value = "志愿者三"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers3Phone", value = "志愿者三电话"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseName", value = "配偶紧急联系人一 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseRelationship", value = "配偶紧急联系人一 关系"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseSex", value = "配偶紧急联系人一 性别"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseAge", value = "配偶紧急联系人一 年龄"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseEthnic", value = "配偶紧急联系人一 名族"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseIdcard", value = "配偶紧急联系人一 身份证"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseResidence", value = "配偶紧急联系人一 户口所在地"),
            @ApiImplicitParam(required = true, name = "contactInformationSpousePhone", value = "急联系人一 电话"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseAddress", value = "急联系人一 地址"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Name", value = "急联系人二 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Relationship", value = "急联系人二 关系"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Sex", value = "急联系人二 性别"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Phone1", value = "急联系人二 电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Phone2", value = "急联系人二 备用电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Address", value = "急联系人二 地址"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Name", value = "紧急联系人三 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Name", value = "急联系人三 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Relationship", value = "急联系人三 关系"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Sex", value = "急联系人三 性别"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Phone1", value = "急联系人三 电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Phone2", value = "急联系人三 备用电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Address", value = "急联系人三 地址"),
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id"),
    })
    public ResponseData<ContactInformation> add(ContactInformation contactInformation, int parentId) {
        ResponseData<ContactInformation> informationPersonalResponseData = new ResponseData<>();
        contactInformation.setParentId(parentId);
        iContactInformationService.insert(contactInformation);
        informationPersonalResponseData.setDataCollection(contactInformation);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑采集人紧急联系人")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "ContactInformation_id"),
            @ApiImplicitParam(required = true, name = "occupyHomeType", value = "志愿者一"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers1Phone", value = "志愿者一电话"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers2", value = "志愿者二"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers2Phone", value = "志愿者二电话"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers3", value = "志愿者三"),
            @ApiImplicitParam(required = true, name = "contactInformationVolunteers3Phone", value = "志愿者三电话"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseName", value = "配偶紧急联系人一 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseRelationship", value = "配偶紧急联系人一 关系"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseSex", value = "配偶紧急联系人一 性别"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseAge", value = "配偶紧急联系人一 年龄"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseEthnic", value = "配偶紧急联系人一 名族"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseIdcard", value = "配偶紧急联系人一 身份证"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseResidence", value = "配偶紧急联系人一 户口所在地"),
            @ApiImplicitParam(required = true, name = "contactInformationSpousePhone", value = "急联系人一 电话"),
            @ApiImplicitParam(required = true, name = "contactInformationSpouseAddress", value = "急联系人一 地址"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Name", value = "急联系人二 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Relationship", value = "急联系人二 关系"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Sex", value = "急联系人二 性别"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Phone1", value = "急联系人二 电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Phone2", value = "急联系人二 备用电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact2Address", value = "急联系人二 地址"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Name", value = "紧急联系人三 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Name", value = "急联系人三 姓名"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Relationship", value = "急联系人三 关系"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Sex", value = "急联系人三 性别"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Phone1", value = "急联系人三 电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Phone2", value = "急联系人三 备用电话"),
            @ApiImplicitParam(required = true, name = "contactInformationContact3Address", value = "急联系人三 地址"),
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id"),
    })
    public ResponseData<ContactInformation> edit(ContactInformation contactInformation, int parentId) {
        ResponseData<ContactInformation> informationPersonalResponseData = new ResponseData<>();
        contactInformation.setParentId(parentId);
        iContactInformationService.updateById(contactInformation);
        informationPersonalResponseData.setDataCollection(contactInformation);
        return informationPersonalResponseData;
    }
    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ApiOperation("获取采集人紧急联系人")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "parentId", value = "InfomationPersonal_id", paramType = "query")
    })
    public ResponseData<ContactInformation> getData(Integer parentId) throws Exception {
        ResponseData<ContactInformation> informationPersonalResponseData = new ResponseData<>();
        EntityWrapper<ContactInformation> informationPersonalEntityWrapper = new EntityWrapper<>();
        informationPersonalEntityWrapper.eq("parentId",parentId);
        informationPersonalResponseData.setDataCollection(iContactInformationService.selectOne(informationPersonalEntityWrapper));
        return informationPersonalResponseData;
    }
}
