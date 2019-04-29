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
 * 采集用户健康信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-29
 */
@TableName("face_information_health")
@ApiModel(value = "采集用户健康信息")
public class InformationHealth extends Model<InformationHealth> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("InformationHealth_id")
    private Integer id;
    /**
     * 听力（1.良好，2.一般，3.很大声才能听见，4.听不见）
     */
    @ApiModelProperty("听力（1.良好，2.一般，3.很大声才能听见，4.听不见）")
    private String hearing;
    /**
     * 是否佩戴助听器（1.是，2.否）
     */
    @TableField("help_hear")
    @ApiModelProperty("是否佩戴助听器（1.是，2.否）")
    private String helpHear;
    /**
     * 病史（1.健康   2.高血压   3.糖尿病   4.冠心病   5.恶性肿瘤   6.结核病   7.肝炎   8.脑卒中  9.精神疾病  10.慢性阻塞性肺疾病  11.慢性支气管炎  12.帕金森综合症  13.腰椎间盘突出  14.阿尔茨海默病  15.心脏病  16.肺气肿  17.白内障  18.脑血栓  19.风湿病  20.脑中风  21.高脂血症  22.哮喘  23.意外伤害  24.其他_____）
     */
    @ApiModelProperty("病史（1.健康   2.高血压   3.糖尿病   4.冠心病   5.恶性肿瘤   6.结核病   7.肝炎   8.脑卒中  9.精神疾病  10.慢性阻塞性肺疾病  11.慢性支气管炎  12.帕金森综合症  13.腰椎间盘突出  14.阿尔茨海默病  15.心脏病  16.肺气肿  17.白内障  18.脑血栓  19.风湿病  20.脑中风  21.高脂血症  22.哮喘  23.意外伤害  24.其他_____）")
    private String health;
    /**
     * 药物过敏情况
     */
    @ApiModelProperty("药物过敏情况")
    private String allergy;
    /**
     * 药物过敏史（1.是，2.否）
     */
    @ApiModelProperty("药物过敏史（1.是，2.否）")
    @TableField("allergy_history")
    private String allergyHistory;
    /**
     * 过敏类型（1药物过敏  2化工金属  3植物过敏  4食物过敏  5动物过敏  6其他_____）
     */
    @ApiModelProperty("过敏类型（1药物过敏  2化工金属  3植物过敏  4食物过敏  5动物过敏  6其他_____）")
    @TableField("allergy_type")
    private String allergyType;
    /**
     * 经常服用药物
     */
    @ApiModelProperty("经常服用药物")
    @TableField("every_eat_drugs")
    private String everyEatDrugs;
    /**
     * 血型
     */
    @ApiModelProperty("血型")
    @TableField("blood_type")
    private String bloodType;
    /**
     * 老人自理类别（1自理  2失能  3半失能  4失智  5轻度依赖  6重度依赖  7不能自理）
     */
    @ApiModelProperty(" 老人自理类别（1自理  2失能  3半失能  4失智  5轻度依赖  6重度依赖  7不能自理）")
    @TableField("zi_li_type")
    private String ziLiType;
    /**
     * 绑定设备
     */

    @TableField("IMEI")
    @ApiModelProperty(hidden = true)
    private String imei;
    /**
     * 健康记录
     */
    @TableField("health_record")
    @ApiModelProperty(hidden = true)
    private String healthRecord;
    /**
     * 体检记录
     */
    @TableField("test_record")
    @ApiModelProperty(hidden = true)
    private String testRecord;
    /**
     * 过敏类型其他对应文本
     */
    @ApiModelProperty("过敏类型其他对应文本")
    @TableField("allergy_type_other_text")
    private String allergyTypeOtherText;
    /**
     * 病史其他对应文本
     */
    @ApiModelProperty("病史其他对应文本")
    @TableField("health_other_text")
    private String healthOtherText;
    @ApiModelProperty("主表id")
    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHearing() {
        return hearing;
    }

    public void setHearing(String hearing) {
        this.hearing = hearing;
    }

    public String getHelpHear() {
        return helpHear;
    }

    public void setHelpHear(String helpHear) {
        this.helpHear = helpHear;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(String allergyHistory) {
        this.allergyHistory = allergyHistory;
    }

    public String getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(String allergyType) {
        this.allergyType = allergyType;
    }

    public String getEveryEatDrugs() {
        return everyEatDrugs;
    }

    public void setEveryEatDrugs(String everyEatDrugs) {
        this.everyEatDrugs = everyEatDrugs;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getZiLiType() {
        return ziLiType;
    }

    public void setZiLiType(String ziLiType) {
        this.ziLiType = ziLiType;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(String healthRecord) {
        this.healthRecord = healthRecord;
    }

    public String getTestRecord() {
        return testRecord;
    }

    public void setTestRecord(String testRecord) {
        this.testRecord = testRecord;
    }

    public String getAllergyTypeOtherText() {
        return allergyTypeOtherText;
    }

    public void setAllergyTypeOtherText(String allergyTypeOtherText) {
        this.allergyTypeOtherText = allergyTypeOtherText;
    }

    public String getHealthOtherText() {
        return healthOtherText;
    }

    public void setHealthOtherText(String healthOtherText) {
        this.healthOtherText = healthOtherText;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "InformationHealth{" +
        "id=" + id +
        ", hearing=" + hearing +
        ", helpHear=" + helpHear +
        ", health=" + health +
        ", allergy=" + allergy +
        ", allergyHistory=" + allergyHistory +
        ", allergyType=" + allergyType +
        ", everyEatDrugs=" + everyEatDrugs +
        ", bloodType=" + bloodType +
        ", ziLiType=" + ziLiType +
        ", imei=" + imei +
        ", healthRecord=" + healthRecord +
        ", testRecord=" + testRecord +
        ", allergyTypeOtherText=" + allergyTypeOtherText +
        ", healthOtherText=" + healthOtherText +
        "}";
    }
}
