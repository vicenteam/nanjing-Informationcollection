package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 首次走访基础信息采集表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-29
 */
@TableName("face_first_visit_assessment_table")
public class FirstVisitAssessmentTable extends Model<FirstVisitAssessmentTable> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 所在社区1
     */
    @TableField("firstvisit_community_1")
    private String firstvisitCommunity1;
    @TableField("firstvisit_community_2")
    private String firstvisitCommunity2;
    @TableField("firstvisit_community_3")
    private String firstvisitCommunity3;
    /**
     * 姓名
     */
    @TableField("firstvisit_name")
    private String firstvisitName;
    /**
     * 性别
     */
    @TableField("firstvisit_sex")
    private String firstvisitSex;
    /**
     * 文化程度
     */
    @TableField("firstvisit_level_education")
    private String firstvisitLevelEducation;
    /**
     * 身份证号码
     */
    @TableField("firstvisit_idcard")
    private String firstvisitIdcard;
    /**
     * 社会保障卡号
     */
    @TableField("firstvisit_othercard")
    private String firstvisitOthercard;
    /**
     * 联系电话
     */
    @TableField("firstvisit_phone")
    private String firstvisitPhone;
    /**
     * 居住地址
     */
    @TableField("firstvisit_residential_address")
    private String firstvisitResidentialAddress;
    /**
     * 常住时间( 0 :1年以下 1: 1-3年  2 :3年以上)
     */
    @TableField("firstvisit_residential_time")
    private String firstvisitResidentialTime;
    /**
     * 紧急联系人(,号隔开 共计4次)
     */
    @TableField("firstvisit_emergency_contact")
    private String firstvisitEmergencyContact;
    /**
     * 原职业(0公务员 1军人 2事业职工 3企业职工 4农民 5其它职业 6无职业)
     */
    @TableField("firstvisit_professional")
    private String firstvisitProfessional;
    /**
     * 人员类别(0离休 1退休 2低保户 3低保边缘户 4城市三无 5农村五保 6供养人员 7其他)
     */
    @TableField("firstvisit_category")
    private String firstvisitCategory;
    /**
     * 经济来源(0离休金/退休金 1养老保险 2子女补贴 3亲友资助 4低保金 5供养人员补贴拆迁补助 6失地农民补助 7其他              （    元/月）)
     */
    @TableField("firstvisit_economic_sources")
    private String firstvisitEconomicSources;
    /**
     * 婚姻状况(0未婚  1已婚  2丧偶  3离婚  4未说明的婚姻状况)
     */
    @TableField("firstvisit_marital")
    private String firstvisitMarital;
    /**
     * 子女状况(0有子女 1无子女)
     */
    @TableField("firstvisit_children")
    private String firstvisitChildren;
    /**
     * 医疗类别(0公费 1职工医保 2居民医保 3新农合 4自费)
     */
    @TableField("firstvisit_medical_category")
    private String firstvisitMedicalCategory;
    /**
     * 居住状况(0独居 1空巢（与配偶/伴侣居住） 2与子女居住 3与其他亲属（含父母、兄弟姐妹等）居住 4与非亲属关系的居住 5养老机构)
     */
    @TableField("firstvisit_living")
    private String firstvisitLiving;
    /**
     * 是否自有房屋：0是1否
     */
    @TableField("firstvisit_living_house")
    private String firstvisitLivingHouse;
    /**
     * 楼层电梯：0有1无
     */
    @TableField("firstvisit_living_elevator")
    private String firstvisitLivingElevator;
    /**
     * 居住楼层(无电梯的)：0一层 1二层 2三层以上；
     */
    @TableField("firstvisit_living_layer")
    private String firstvisitLivingLayer;
    /**
     * 室内厕所：0有1无；
     */
    @TableField("firstvisit_living_toilet")
    private String firstvisitLivingToilet;
    /**
     * 室内洗浴设备：0有1无
     */
    @TableField("firstvisit_living_bathing_facilities")
    private String firstvisitLivingBathingFacilities;
    /**
     * 0自我照料 1配偶照顾 2子女照顾 3自购家政服务 4送餐服务 5互助门铃 6居家照料 7紧急呼叫终端 8老年人意外伤害保险 9其他
     */
    @TableField("firstvisit_original_care_situation")
    private String firstvisitOriginalcareSituation;
    /**
     * 服务需求(0家务料理  1代购物品 2康复保健  3紧急呼叫  4心理关爱  5法律援助  6文化娱乐 7助餐  8送餐  9陪聊  10陪住  11陪外出  12日托  13入住老年人福利机构; 14其他:)
     */
    @TableField("firstvisit_service")
    private String firstvisitService;
    /**
     * 身体状况单选(0健康 1重病 2慢性病 )
     */
    @TableField("firstvisit_physical_condition_radio")
    private String firstvisitPhysicalConditionRadio;
    /**
     * 身体状况多选(0恶性肿瘤 1尿毒症透析 2器官移植(含手术后的抗排异治疗) 3白血病 4急性心肌梗塞 5脑中风 6急性坏死性胰腺炎 7脑外伤 8主动脉手术 9冠状动脉旁路手术 10慢性肾功能性衰竭 11急慢性重症肝炎 12危及生命的良性脑瘤 13重症糖尿病 14消化道出血 15系统性红斑狼疮 16慢性再生障碍性贫血 17血友病 18重病精神病  19高血压 20冠心病 21前列腺增生 22糖尿病 23其他   )
     */
    @TableField("firstvisit_physical_condition_checkbox")
    private String firstvisitPhysicalConditionCheckbox;
    /**
     * 心理状况(0正常  1偶有孤独感  2经常觉得很孤独)
     */
    @TableField("firstvisit_psychological")
    private String firstvisitPsychological;
    /**
     * 社会活动(0 经常 1偶尔 2从不)
     */
    @TableField("firstvisit_social_activities")
    private String firstvisitSocialActivities;
    /**
     * 社会活动类型：0文娱类 1教育类 2健身类 3慈善类 4经济类 5宗教类 6其他
     */
    @TableField("firstvisit_social_activities_type")
    private String firstvisitSocialActivitiesType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstvisitCommunity1() {
        return firstvisitCommunity1;
    }

    public void setFirstvisitCommunity1(String firstvisitCommunity1) {
        this.firstvisitCommunity1 = firstvisitCommunity1;
    }

    public String getFirstvisitCommunity2() {
        return firstvisitCommunity2;
    }

    public void setFirstvisitCommunity2(String firstvisitCommunity2) {
        this.firstvisitCommunity2 = firstvisitCommunity2;
    }

    public String getFirstvisitCommunity3() {
        return firstvisitCommunity3;
    }

    public void setFirstvisitCommunity3(String firstvisitCommunity3) {
        this.firstvisitCommunity3 = firstvisitCommunity3;
    }

    public String getFirstvisitName() {
        return firstvisitName;
    }

    public void setFirstvisitName(String firstvisitName) {
        this.firstvisitName = firstvisitName;
    }

    public String getFirstvisitSex() {
        return firstvisitSex;
    }

    public void setFirstvisitSex(String firstvisitSex) {
        this.firstvisitSex = firstvisitSex;
    }

    public String getFirstvisitLevelEducation() {
        return firstvisitLevelEducation;
    }

    public void setFirstvisitLevelEducation(String firstvisitLevelEducation) {
        this.firstvisitLevelEducation = firstvisitLevelEducation;
    }

    public String getFirstvisitIdcard() {
        return firstvisitIdcard;
    }

    public void setFirstvisitIdcard(String firstvisitIdcard) {
        this.firstvisitIdcard = firstvisitIdcard;
    }

    public String getFirstvisitOthercard() {
        return firstvisitOthercard;
    }

    public void setFirstvisitOthercard(String firstvisitOthercard) {
        this.firstvisitOthercard = firstvisitOthercard;
    }

    public String getFirstvisitPhone() {
        return firstvisitPhone;
    }

    public void setFirstvisitPhone(String firstvisitPhone) {
        this.firstvisitPhone = firstvisitPhone;
    }

    public String getFirstvisitResidentialAddress() {
        return firstvisitResidentialAddress;
    }

    public void setFirstvisitResidentialAddress(String firstvisitResidentialAddress) {
        this.firstvisitResidentialAddress = firstvisitResidentialAddress;
    }

    public String getFirstvisitResidentialTime() {
        return firstvisitResidentialTime;
    }

    public void setFirstvisitResidentialTime(String firstvisitResidentialTime) {
        this.firstvisitResidentialTime = firstvisitResidentialTime;
    }

    public String getFirstvisitEmergencyContact() {
        return firstvisitEmergencyContact;
    }

    public void setFirstvisitEmergencyContact(String firstvisitEmergencyContact) {
        this.firstvisitEmergencyContact = firstvisitEmergencyContact;
    }

    public String getFirstvisitProfessional() {
        return firstvisitProfessional;
    }

    public void setFirstvisitProfessional(String firstvisitProfessional) {
        this.firstvisitProfessional = firstvisitProfessional;
    }

    public String getFirstvisitCategory() {
        return firstvisitCategory;
    }

    public void setFirstvisitCategory(String firstvisitCategory) {
        this.firstvisitCategory = firstvisitCategory;
    }

    public String getFirstvisitEconomicSources() {
        return firstvisitEconomicSources;
    }

    public void setFirstvisitEconomicSources(String firstvisitEconomicSources) {
        this.firstvisitEconomicSources = firstvisitEconomicSources;
    }

    public String getFirstvisitMarital() {
        return firstvisitMarital;
    }

    public void setFirstvisitMarital(String firstvisitMarital) {
        this.firstvisitMarital = firstvisitMarital;
    }

    public String getFirstvisitChildren() {
        return firstvisitChildren;
    }

    public void setFirstvisitChildren(String firstvisitChildren) {
        this.firstvisitChildren = firstvisitChildren;
    }

    public String getFirstvisitMedicalCategory() {
        return firstvisitMedicalCategory;
    }

    public void setFirstvisitMedicalCategory(String firstvisitMedicalCategory) {
        this.firstvisitMedicalCategory = firstvisitMedicalCategory;
    }

    public String getFirstvisitLiving() {
        return firstvisitLiving;
    }

    public void setFirstvisitLiving(String firstvisitLiving) {
        this.firstvisitLiving = firstvisitLiving;
    }

    public String getFirstvisitLivingHouse() {
        return firstvisitLivingHouse;
    }

    public void setFirstvisitLivingHouse(String firstvisitLivingHouse) {
        this.firstvisitLivingHouse = firstvisitLivingHouse;
    }

    public String getFirstvisitLivingElevator() {
        return firstvisitLivingElevator;
    }

    public void setFirstvisitLivingElevator(String firstvisitLivingElevator) {
        this.firstvisitLivingElevator = firstvisitLivingElevator;
    }

    public String getFirstvisitLivingLayer() {
        return firstvisitLivingLayer;
    }

    public void setFirstvisitLivingLayer(String firstvisitLivingLayer) {
        this.firstvisitLivingLayer = firstvisitLivingLayer;
    }

    public String getFirstvisitLivingToilet() {
        return firstvisitLivingToilet;
    }

    public void setFirstvisitLivingToilet(String firstvisitLivingToilet) {
        this.firstvisitLivingToilet = firstvisitLivingToilet;
    }

    public String getFirstvisitLivingBathingFacilities() {
        return firstvisitLivingBathingFacilities;
    }

    public void setFirstvisitLivingBathingFacilities(String firstvisitLivingBathingFacilities) {
        this.firstvisitLivingBathingFacilities = firstvisitLivingBathingFacilities;
    }


    public String getFirstvisitOriginalcareSituation() {
        return firstvisitOriginalcareSituation;
    }

    public void setFirstvisitOriginalcareSituation(String firstvisitOriginalcareSituation) {
        this.firstvisitOriginalcareSituation = firstvisitOriginalcareSituation;
    }

    public String getFirstvisitService() {
        return firstvisitService;
    }

    public void setFirstvisitService(String firstvisitService) {
        this.firstvisitService = firstvisitService;
    }

    public String getFirstvisitPhysicalConditionRadio() {
        return firstvisitPhysicalConditionRadio;
    }

    public void setFirstvisitPhysicalConditionRadio(String firstvisitPhysicalConditionRadio) {
        this.firstvisitPhysicalConditionRadio = firstvisitPhysicalConditionRadio;
    }

    public String getFirstvisitPhysicalConditionCheckbox() {
        return firstvisitPhysicalConditionCheckbox;
    }

    public void setFirstvisitPhysicalConditionCheckbox(String firstvisitPhysicalConditionCheckbox) {
        this.firstvisitPhysicalConditionCheckbox = firstvisitPhysicalConditionCheckbox;
    }

    public String getFirstvisitPsychological() {
        return firstvisitPsychological;
    }

    public void setFirstvisitPsychological(String firstvisitPsychological) {
        this.firstvisitPsychological = firstvisitPsychological;
    }

    public String getFirstvisitSocialActivities() {
        return firstvisitSocialActivities;
    }

    public void setFirstvisitSocialActivities(String firstvisitSocialActivities) {
        this.firstvisitSocialActivities = firstvisitSocialActivities;
    }

    public String getFirstvisitSocialActivitiesType() {
        return firstvisitSocialActivitiesType;
    }

    public void setFirstvisitSocialActivitiesType(String firstvisitSocialActivitiesType) {
        this.firstvisitSocialActivitiesType = firstvisitSocialActivitiesType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FirstVisitAssessmentTable{" +
        "id=" + id +
        ", firstvisitCommunity1=" + firstvisitCommunity1 +
        ", firstvisitCommunity2=" + firstvisitCommunity2 +
        ", firstvisitCommunity3=" + firstvisitCommunity3 +
        ", firstvisitName=" + firstvisitName +
        ", firstvisitSex=" + firstvisitSex +
        ", firstvisitLevelEducation=" + firstvisitLevelEducation +
        ", firstvisitIdcard=" + firstvisitIdcard +
        ", firstvisitOthercard=" + firstvisitOthercard +
        ", firstvisitPhone=" + firstvisitPhone +
        ", firstvisitResidentialAddress=" + firstvisitResidentialAddress +
        ", firstvisitResidentialTime=" + firstvisitResidentialTime +
        ", firstvisitEmergencyContact=" + firstvisitEmergencyContact +
        ", firstvisitProfessional=" + firstvisitProfessional +
        ", firstvisitCategory=" + firstvisitCategory +
        ", firstvisitEconomicSources=" + firstvisitEconomicSources +
        ", firstvisitMarital=" + firstvisitMarital +
        ", firstvisitChildren=" + firstvisitChildren +
        ", firstvisitMedicalCategory=" + firstvisitMedicalCategory +
        ", firstvisitLiving=" + firstvisitLiving +
        ", firstvisitLivingHouse=" + firstvisitLivingHouse +
        ", firstvisitLivingElevator=" + firstvisitLivingElevator +
        ", firstvisitLivingLayer=" + firstvisitLivingLayer +
        ", firstvisitLivingToilet=" + firstvisitLivingToilet +
        ", firstvisitLivingBathingFacilities=" + firstvisitLivingBathingFacilities +
        ", firstvisitService=" + firstvisitService +
        ", firstvisitPhysicalConditionRadio=" + firstvisitPhysicalConditionRadio +
        ", firstvisitPhysicalConditionCheckbox=" + firstvisitPhysicalConditionCheckbox +
        ", firstvisitPsychological=" + firstvisitPsychological +
        ", firstvisitSocialActivities=" + firstvisitSocialActivities +
        ", firstvisitSocialActivitiesType=" + firstvisitSocialActivitiesType +
        "}";
    }
}
