package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.api.model.user.FirstVisitStatusModel;
import com.stylefeng.guns.modular.api.util.HttpsUtil;
import com.stylefeng.guns.modular.face.service.IFirstVisitAssessmentTableService;
import com.stylefeng.guns.modular.face.service.IOccupyHomeService;
import com.stylefeng.guns.modular.system.model.FirstVisitAssessmentTable;
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

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/apifirstvisitassessmenttablecontroller")
@Api(value = "采集人第一次走访能力评估controller", tags = {"采集人第一次走访能力评估接口"})
public class ApiFirstVisitAssessmentTableController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiFirstVisitAssessmentTableController.class);

    @Autowired
    private IFirstVisitAssessmentTableService firstVisitAssessmentTableService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增采集人第一次走访能力评估")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "firstvisitCommunity1", value = "所在社区县（区）"),
            @ApiImplicitParam(required = true, name = "firstvisitCommunity2", value = "街道（乡镇）"),
            @ApiImplicitParam(required = true, name = "firstvisitCommunity3", value = "社区（村居）"),
            @ApiImplicitParam(required = true, name = "firstvisitSex", value = "性别"),
            @ApiImplicitParam(required = true, name = "firstvisitLevelEducation", value = "文化程度"),
            @ApiImplicitParam(required = true, name = "firstvisitIdcard", value = "身份证号码"),
            @ApiImplicitParam(required = true, name = "firstvisitOthercard", value = "社会保障卡号"),
            @ApiImplicitParam(required = true, name = "firstvisitPhone", value = "联系电话"),
            @ApiImplicitParam(required = true, name = "firstvisitResidentialAddress", value = "居住地址"),
            @ApiImplicitParam(required = true, name = "firstvisitResidentialTime", value = "常住时间( 0 :1年以下 1: 1-3年  2 :3年以上)"),
            @ApiImplicitParam(required = true, name = "firstvisitEmergencyContact", value = "紧急联系人(,号隔开 共计4次)"),
            @ApiImplicitParam(required = true, name = "firstvisitProfessional", value = "原职业(0公务员 1军人 2事业职工 3企业职工 4农民 5其它职业 6无职业)"),
            @ApiImplicitParam(required = true, name = "firstvisitCategory", value = "人员类别(0离休 1退休 2低保户 3低保边缘户 4城市三无 5农村五保 6供养人员 7其他)"),
            @ApiImplicitParam(required = true, name = "firstvisitEconomicSources", value = "经济来源(0离休金/退休金 1养老保险 2子女补贴 3亲友资助 4低保金 5供养人员补贴拆迁补助 6失地农民补助 7其他              （    元/月）)"),
            @ApiImplicitParam(required = true, name = "firstvisitMarital", value = "婚姻状况(0未婚  1已婚  2丧偶  3离婚  4未说明的婚姻状况)"),
            @ApiImplicitParam(required = true, name = "firstvisitChildren", value = "子女状况(0有子女 1无子女)"),
            @ApiImplicitParam(required = true, name = "firstvisitMedicalCategory", value = "医疗类别(0公费 1职工医保 2居民医保 3新农合 4自费)"),
            @ApiImplicitParam(required = true, name = "firstvisitLiving", value = "居住状况(0独居 1空巢（与配偶/伴侣居住） 2与子女居住 3与其他亲属（含父母、兄弟姐妹等）居住 4与非亲属关系的居住 5养老机构)"),
            @ApiImplicitParam(required = true, name = "firstvisitLivingHouse", value = "是否自有房屋：0是1否"),
            @ApiImplicitParam(required = true, name = "firstvisitLivingElevator", value = "楼层电梯：0有1无"),
            @ApiImplicitParam(required = true, name = "firstvisitLivingLayer", value = "居住楼层(无电梯的)：0一层 1二层 2三层以上；"),
            @ApiImplicitParam(required = true, name = "firstvisitLivingToilet", value = "室内厕所：0有1无"),
            @ApiImplicitParam(required = true, name = "firstvisitLivingBathingFacilities", value = "室内洗浴设备：0有1无"),
            @ApiImplicitParam(required = true, name = "firstvisitOriginalCareSituation", value = "原照料情况 0自我照料 1配偶照顾 2子女照顾 3自购家政服务 4送餐服务 5互助门铃 6居家照料 7紧急呼叫终端 8老年人意外伤害保险 9其他"),
            @ApiImplicitParam(required = true, name = "firstvisitService", value = "服务需求(0家务料理  1代购物品 2康复保健  3紧急呼叫  4心理关爱  5法律援助  6文化娱乐 7助餐  8送餐  9陪聊  10陪住  11陪外出  12日托  13入住老年人福利机构; 14其他:)"),
            @ApiImplicitParam(required = true, name = "firstvisitPhysicalConditionRadio", value = "身体状况单选(0健康 1重病 2慢性病 )"),
            @ApiImplicitParam(required = true, name = "firstvisitPhysicalConditionCheckbox", value = "身体状况多选(0恶性肿瘤 1尿毒症透析 2器官移植(含手术后的抗排异治疗) 3白血病 4急性心肌梗塞 5脑中风 6急性坏死性胰腺炎 7脑外伤 8主动脉手术 9冠状动脉旁路手术 10慢性肾功能性衰竭 11急慢性重症肝炎 12危及生命的良性脑瘤 13重症糖尿病 14消化道出血 15系统性红斑狼疮 16慢性再生障碍性贫血 17血友病 18重病精神病  19高血压 20冠心病 21前列腺增生 22糖尿病 23其他 )"),
            @ApiImplicitParam(required = true, name = "firstvisitPsychological", value = "心理状况(0正常  1偶有孤独感  2经常觉得很孤独)"),
            @ApiImplicitParam(required = true, name = "firstvisitSocialActivities", value = "社会活动(0 经常 1偶尔 2从不)"),
            @ApiImplicitParam(required = true, name = "firstvisitSocialActivitiesType", value = "社会活动类型：0文娱类 1教育类 2健身类 3慈善类 4经济类 5宗教类 6其他"),
            @ApiImplicitParam(required = true, name = "firstvisitEconomicSourcesOtherText", value = "经济来源其他对应文本"),
            @ApiImplicitParam(required = true, name = "firstvisitPhysicalConditionCheckboxOtherText", value = "身体状况其他对应文本"),
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<FirstVisitAssessmentTable> add(FirstVisitAssessmentTable firstVisitAssessmentTable, int parentId) {
        if(firstVisitAssessmentTable.getId()!=null&&firstVisitAssessmentTable.getId()==-1)firstVisitAssessmentTable.setId(null);
        ResponseData<FirstVisitAssessmentTable> informationPersonalResponseData = new ResponseData<>();
        firstVisitAssessmentTable.setFaceIdentifyTopId(parentId);
        firstVisitAssessmentTableService.insert(firstVisitAssessmentTable);
        informationPersonalResponseData.setDataCollection(firstVisitAssessmentTable);

        Map<String, Object> map = new HashMap<>();
        map.put("city", "南京市");
        map.put("zone", "高新区");
        map.put("street", "秣陵街道");
        map.put("shequ", "东善桥社区");
        map.put("name", firstVisitAssessmentTable.getFirstvisitName());
        map.put("sex", firstVisitAssessmentTable.getFirstvisitSex());
        map.put("nation", "");
        map.put("educationLevel", firstVisitAssessmentTable.getFirstvisitLevelEducation());
        map.put("idNumber", firstVisitAssessmentTable.getFirstvisitIdcard());
        map.put("phone", firstVisitAssessmentTable.getFirstvisitPhone());
        map.put("address", firstVisitAssessmentTable.getFirstvisitResidentialAddress());
        map.put("residentTime", firstVisitAssessmentTable.getFirstvisitResidentialTime());
        map.put("jtcyname1", firstVisitAssessmentTable.getFirstvisitEmergencyContact());
        map.put("jtcyrelation1", firstVisitAssessmentTable.getFirstvisitEmergencyContact());
        map.put("jtcyaddress1", firstVisitAssessmentTable.getFirstvisitEmergencyContact());
        map.put("jtcyphone1", firstVisitAssessmentTable.getFirstvisitEmergencyContact());
        map.put("customerKey", "1");
        map.put("professional", firstVisitAssessmentTable.getFirstvisitProfessional());
        map.put("personType", firstVisitAssessmentTable.getFirstvisitCategory());
        map.put("economicSource", firstVisitAssessmentTable.getFirstvisitEconomicSources());
        map.put("marriageStatus", firstVisitAssessmentTable.getFirstvisitMarital());
        map.put("childStatus", firstVisitAssessmentTable.getFirstvisitChildren());
        map.put("medical", firstVisitAssessmentTable.getFirstvisitMedicalCategory());
        map.put("juzhuCommunity", firstVisitAssessmentTable.getFirstvisitLiving());
        map.put("privateHousing", firstVisitAssessmentTable.getFirstvisitLivingHouse());
        map.put("floorElevator", firstVisitAssessmentTable.getFirstvisitLivingLayer());
        map.put("residentialFloor", firstVisitAssessmentTable.getFirstvisitLivingElevator());
        map.put("indoorToilet", firstVisitAssessmentTable.getFirstvisitLivingToilet());
        map.put("indoorBath", firstVisitAssessmentTable.getFirstvisitLivingBathingFacilities());
        map.put("originalCare", firstVisitAssessmentTable.getFirstvisitOriginalCareSituation());
        map.put("governmentService", firstVisitAssessmentTable.getFirstvisitService());
        map.put("serviceNeeds", firstVisitAssessmentTable.getFirstvisitService());
        map.put("physicalCondition", firstVisitAssessmentTable.getFirstvisitPhysicalConditionCheckbox());
        map.put("mentality", firstVisitAssessmentTable.getFirstvisitPsychological());
        map.put("activities", firstVisitAssessmentTable.getFirstvisitSocialActivities());
        map.put("activitiesType", firstVisitAssessmentTable.getFirstvisitSocialActivitiesType());
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.api = HttpsUtil.CUSTOMER_INFO_UPDATEVISITCUSTOMERS;
        httpsUtil.map_temp = map;
        Thread thread = new Thread(httpsUtil);
        thread.run();
        return informationPersonalResponseData;
    }

    @RequestMapping(value = "/firstVisitStatus", method = RequestMethod.POST)
    @ApiOperation("查询采集人是否存在第一次走访能力评估信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "parentId", value = "FaceIdentifyTop_id", paramType = "query"),
    })
    public ResponseData<FirstVisitStatusModel> firstVisitStatus(int parentId) {
        ResponseData<FirstVisitStatusModel> informationPersonalResponseData = new ResponseData<>();
        FirstVisitStatusModel firstVisitStatusModel = new FirstVisitStatusModel();
//        firstVisitAssessmentTable.setFaceIdentifyTopId(parentId);
        EntityWrapper<FirstVisitAssessmentTable> informationPersonalEntityWrapper = new EntityWrapper<>();
        informationPersonalEntityWrapper.eq("face_identify_top_id", parentId);
        FirstVisitAssessmentTable firstVisitAssessmentTable1 = firstVisitAssessmentTableService.selectOne(informationPersonalEntityWrapper);
        if (firstVisitAssessmentTable1 != null) {
            firstVisitStatusModel.setNum(0);
            firstVisitStatusModel.setText("存在第一次走访能力评估信息，可进行第二次走访能力评估信息数据采集");
        } else {
            firstVisitStatusModel.setNum(1);
            firstVisitStatusModel.setText("不存在第一次走访能力评估信息");
        }
        informationPersonalResponseData.setDataCollection(firstVisitStatusModel);
        return informationPersonalResponseData;
    }
}
