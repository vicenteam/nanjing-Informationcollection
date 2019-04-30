package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 第二次走访基础信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
@TableName("face_second_visit_assessment_table")
@ApiModel(value = "第二次走访基础信Model")
public class SecondVisitAssessmentTable extends Model<SecondVisitAssessmentTable> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("SecondVisitAssessmentTable_id")
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @TableField("secondvisit_name")
    private String secondvisitName;
    /**
     * 性别(0男 1女)
     */
    @ApiModelProperty("性别(0男 1女)")
    @TableField("secondvisit_sex")
    private String secondvisitSex;
    /**
     * 身份证
     */
    @ApiModelProperty("身份证")
    @TableField("secondvisit_idcard")
    private String secondvisitIdcard;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    @TableField("secondvisit_age")
    private String secondvisitAge;
    /**
     * 社保卡号
     */
    @ApiModelProperty("社保卡号")
    @TableField("secondvisit_othercard")
    private String secondvisitOthercard;
    /**
     * 名族(0汉族 1其他)
     */
    @ApiModelProperty(" 名族(0汉族 1其他)")
    @TableField("secondvisit_ethnic")
    private String secondvisitEthnic;
    /**
     * 教育水平(1文盲 2小学 3初中 4高中/技校/中专 5大学专科及以上 6不详)
     */
    @ApiModelProperty("教育水平(1文盲 2小学 3初中 4高中/技校/中专 5大学专科及以上 6不详)")
    @TableField("secondvisit_level_of_education")
    private String secondvisitLevelOfEducation;
    /**
     * 婚姻状况(1未婚   2 已婚   3丧偶   4离婚   5未说明的婚姻状况)
     */
    @ApiModelProperty("婚姻状况(1未婚   2 已婚   3丧偶   4离婚   5未说明的婚姻状况)")
    @TableField("secondvisit_marital_status")
    private String secondvisitMaritalStatus;
    /**
     * 居住地址
     */
    @ApiModelProperty("居住地址")
    @TableField("secondvisit_address")
    private String secondvisitAddress;
    /**
     * 住宅电话
     */
    @ApiModelProperty("住宅电话")
    @TableField("secondvisit_home_phone")
    private String secondvisitHomePhone;
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    @TableField("secondvisit_phone_number")
    private String secondvisitPhoneNumber;
    /**
     * 居住情况(1独自居住  2 与配偶居住  3 与子女居住  4 其他 )
     */
    @ApiModelProperty("居住情况(1独自居住  2 与配偶居住  3 与子女居住  4 其他 )")
    @TableField("secondvisit_living_situation")
    private String secondvisitLivingSituation;
    /**
     * 医疗费用支付方式(1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗  4贫困救助  5商业医疗保险  6全公费  7全自费  8其他)
     */
    @ApiModelProperty("医疗费用支付方式(1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗  4贫困救助  5商业医疗保险  6全公费  7全自费  8其他)")
    @TableField("secondvisit_medical")
    private String secondvisitMedical;
    /**
     * 走访对象类别(1低保  2低收入  3建档立卡贫困老人  4重点优抚对象)
     */
    @ApiModelProperty("走访对象类别(1低保  2低收入  3建档立卡贫困老人  4重点优抚对象)")
    @TableField("secondvisit_visit_object_categories")
    private String secondvisitVisitObjectCategories;
    /**
     * 期望的养老模式(0居家养老   1社区养老   2机构养老   3其他)
     */
    @ApiModelProperty("期望的养老模式(0居家养老   1社区养老   2机构养老   3其他)")
    @TableField("secondvisit_expectations_pension")
    private String secondvisitExpectationsPension;
    /**
     * 期望的养老服务(0家政服务 1生活照料 2健康咨询 3精神慰藉 4陪同就医 5换季服务 6助浴服务 7助残服务 8助洁服务 9助餐服务 10 助行服务 11定制服务)
     */
    @ApiModelProperty("期望的养老服务(0家政服务 1生活照料 2健康咨询 3精神慰藉 4陪同就医 5换季服务 6助浴服务 7助残服务 8助洁服务 9助餐服务 10 助行服务 11定制服务)")
    @TableField("secondvisit_expectations_pension_server")
    private String secondvisitExpectationsPensionServer;
    @ApiModelProperty(hidden = true)
    private String createtime;
    @ApiModelProperty(hidden = true)
    private Integer createuserid;
    @ApiModelProperty(hidden = true)
    private Integer deptid;
    @ApiModelProperty("Identifytop_id")
    @TableField("face_identify_top_id")
    private Integer faceIdentifyTopId;
    /**
     * 医疗支付方式其他对应文本
     */
    @ApiModelProperty("医疗支付方式其他对应文本")
    @TableField("secondvisit_medical_other_text")
    private String secondvisitMedicalOtherText;
    /**
     * 期望的养老模式其他选择对应文本
     */
    @ApiModelProperty("期望的养老模式其他选择对应文本")
    @TableField("secondvisit_expectations_pension_other_text")
    private String secondvisitExpectationsPensionOtherText;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondvisitName() {
        return secondvisitName;
    }

    public void setSecondvisitName(String secondvisitName) {
        this.secondvisitName = secondvisitName;
    }

    public String getSecondvisitSex() {
        return secondvisitSex;
    }

    public void setSecondvisitSex(String secondvisitSex) {
        this.secondvisitSex = secondvisitSex;
    }

    public String getSecondvisitIdcard() {
        return secondvisitIdcard;
    }

    public void setSecondvisitIdcard(String secondvisitIdcard) {
        this.secondvisitIdcard = secondvisitIdcard;
    }

    public String getSecondvisitAge() {
        return secondvisitAge;
    }

    public void setSecondvisitAge(String secondvisitAge) {
        this.secondvisitAge = secondvisitAge;
    }

    public String getSecondvisitOthercard() {
        return secondvisitOthercard;
    }

    public void setSecondvisitOthercard(String secondvisitOthercard) {
        this.secondvisitOthercard = secondvisitOthercard;
    }

    public String getSecondvisitEthnic() {
        return secondvisitEthnic;
    }

    public void setSecondvisitEthnic(String secondvisitEthnic) {
        this.secondvisitEthnic = secondvisitEthnic;
    }

    public String getSecondvisitLevelOfEducation() {
        return secondvisitLevelOfEducation;
    }

    public void setSecondvisitLevelOfEducation(String secondvisitLevelOfEducation) {
        this.secondvisitLevelOfEducation = secondvisitLevelOfEducation;
    }

    public String getSecondvisitMaritalStatus() {
        return secondvisitMaritalStatus;
    }

    public void setSecondvisitMaritalStatus(String secondvisitMaritalStatus) {
        this.secondvisitMaritalStatus = secondvisitMaritalStatus;
    }

    public String getSecondvisitAddress() {
        return secondvisitAddress;
    }

    public void setSecondvisitAddress(String secondvisitAddress) {
        this.secondvisitAddress = secondvisitAddress;
    }

    public String getSecondvisitHomePhone() {
        return secondvisitHomePhone;
    }

    public void setSecondvisitHomePhone(String secondvisitHomePhone) {
        this.secondvisitHomePhone = secondvisitHomePhone;
    }

    public String getSecondvisitPhoneNumber() {
        return secondvisitPhoneNumber;
    }

    public void setSecondvisitPhoneNumber(String secondvisitPhoneNumber) {
        this.secondvisitPhoneNumber = secondvisitPhoneNumber;
    }

    public String getSecondvisitLivingSituation() {
        return secondvisitLivingSituation;
    }

    public void setSecondvisitLivingSituation(String secondvisitLivingSituation) {
        this.secondvisitLivingSituation = secondvisitLivingSituation;
    }

    public String getSecondvisitMedical() {
        return secondvisitMedical;
    }

    public void setSecondvisitMedical(String secondvisitMedical) {
        this.secondvisitMedical = secondvisitMedical;
    }

    public String getSecondvisitVisitObjectCategories() {
        return secondvisitVisitObjectCategories;
    }

    public void setSecondvisitVisitObjectCategories(String secondvisitVisitObjectCategories) {
        this.secondvisitVisitObjectCategories = secondvisitVisitObjectCategories;
    }

    public String getSecondvisitExpectationsPension() {
        return secondvisitExpectationsPension;
    }

    public void setSecondvisitExpectationsPension(String secondvisitExpectationsPension) {
        this.secondvisitExpectationsPension = secondvisitExpectationsPension;
    }

    public String getSecondvisitExpectationsPensionServer() {
        return secondvisitExpectationsPensionServer;
    }

    public void setSecondvisitExpectationsPensionServer(String secondvisitExpectationsPensionServer) {
        this.secondvisitExpectationsPensionServer = secondvisitExpectationsPensionServer;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getFaceIdentifyTopId() {
        return faceIdentifyTopId;
    }

    public void setFaceIdentifyTopId(Integer faceIdentifyTopId) {
        this.faceIdentifyTopId = faceIdentifyTopId;
    }

    public String getSecondvisitMedicalOtherText() {
        return secondvisitMedicalOtherText;
    }

    public void setSecondvisitMedicalOtherText(String secondvisitMedicalOtherText) {
        this.secondvisitMedicalOtherText = secondvisitMedicalOtherText;
    }

    public String getSecondvisitExpectationsPensionOtherText() {
        return secondvisitExpectationsPensionOtherText;
    }

    public void setSecondvisitExpectationsPensionOtherText(String secondvisitExpectationsPensionOtherText) {
        this.secondvisitExpectationsPensionOtherText = secondvisitExpectationsPensionOtherText;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SecondVisitAssessmentTable{" +
                "id=" + id +
                ", secondvisitName=" + secondvisitName +
                ", secondvisitSex=" + secondvisitSex +
                ", secondvisitIdcard=" + secondvisitIdcard +
                ", secondvisitAge=" + secondvisitAge +
                ", secondvisitOthercard=" + secondvisitOthercard +
                ", secondvisitEthnic=" + secondvisitEthnic +
                ", secondvisitLevelOfEducation=" + secondvisitLevelOfEducation +
                ", secondvisitMaritalStatus=" + secondvisitMaritalStatus +
                ", secondvisitAddress=" + secondvisitAddress +
                ", secondvisitHomePhone=" + secondvisitHomePhone +
                ", secondvisitPhoneNumber=" + secondvisitPhoneNumber +
                ", secondvisitLivingSituation=" + secondvisitLivingSituation +
                ", secondvisitMedical=" + secondvisitMedical +
                ", secondvisitVisitObjectCategories=" + secondvisitVisitObjectCategories +
                ", secondvisitExpectationsPension=" + secondvisitExpectationsPension +
                ", secondvisitExpectationsPensionServer=" + secondvisitExpectationsPensionServer +
                ", createtime=" + createtime +
                ", createuserid=" + createuserid +
                ", deptid=" + deptid +
                ", faceIdentifyTopId=" + faceIdentifyTopId +
                ", secondvisitMedicalOtherText=" + secondvisitMedicalOtherText +
                ", secondvisitExpectationsPensionOtherText=" + secondvisitExpectationsPensionOtherText +
                "}";
    }
}
