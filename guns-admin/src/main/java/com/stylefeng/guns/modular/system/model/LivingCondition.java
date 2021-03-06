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
 * 生活居住状况及社会关系
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-29
 */
@TableName("face_living_condition")
@ApiModel(value = "采集人生活居住状况及社会关系")
public class LivingCondition extends Model<LivingCondition> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("LivingCondition_id")
    private Integer id;
    /**
     * 居住状态
     */
    @ApiModelProperty("居住状态（1其他情况,2与子女居住,3与配偶居住,4独居）")
    @TableField("live_state")
    private String liveState;
    /**
     * 是否特困或者失能
     */
    @TableField("need_hlep")
//    @ApiModelProperty("是否特困或者失能")
    @ApiModelProperty(hidden = true)
    private String needHlep;
    /**
     * 是否重点优抚
     */
    @TableField("first_hlep")
//    @ApiModelProperty("是否重点优抚")
    @ApiModelProperty(hidden = true)
    private String firstHlep;
    /**
     * 是否重度残疾
     */
    @TableField("severe_disability")
//    @ApiModelProperty("是否重度残疾")
    @ApiModelProperty(hidden = true)
    private String severeDisability;
    /**
     * 是否城市三无
     */
    @TableField("three_no")
//    @ApiModelProperty("是否城市三无（0是，1否）")
    @ApiModelProperty(hidden = true)
    private String threeNo;
    /**
     * 是否农村五保
     */
    @TableField("five_insurance")
//    @ApiModelProperty("是否农村五保(0是，1否)")
    @ApiModelProperty(hidden = true)
    private String fiveInsurance;
    @ApiModelProperty("人脸识别&注册返回的 id (FaceIdentifyTop_id)")
    private Integer parentId;

    @TableField("create_date")
    @ApiModelProperty(hidden = true)
    private String createDate;
    @TableField("update_date")
    @ApiModelProperty(hidden = true)
    private String updateDate;
    @ApiModelProperty(hidden = true)
    private Integer status;
    @ApiModelProperty("人员类型（0特困失能 1重点优抚 2城市三五 3农村五保 4重度残疾 5其他）")
    private String pestype;
    @ApiModelProperty("人员类别其他文本")
    private String pestypeothertext;
    @ApiModelProperty("居住情况其他文本")
    private String liveStateOtherText;


    public String getPestype() {
        return pestype;
    }

    public void setPestype(String pestype) {
        this.pestype = pestype;
    }

    public String getPestypeothertext() {
        return pestypeothertext;
    }

    public void setPestypeothertext(String pestypeothertext) {
        this.pestypeothertext = pestypeothertext;
    }

    public String getLiveStateOtherText() {
        return liveStateOtherText;
    }

    public void setLiveStateOtherText(String liveStateOtherText) {
        this.liveStateOtherText = liveStateOtherText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiveState() {
        return liveState;
    }

    public void setLiveState(String liveState) {
        this.liveState = liveState;
    }

    public String getNeedHlep() {
        return needHlep;
    }

    public void setNeedHlep(String needHlep) {
        this.needHlep = needHlep;
    }

    public String getFirstHlep() {
        return firstHlep;
    }

    public void setFirstHlep(String firstHlep) {
        this.firstHlep = firstHlep;
    }

    public String getSevereDisability() {
        return severeDisability;
    }

    public void setSevereDisability(String severeDisability) {
        this.severeDisability = severeDisability;
    }

    public String getThreeNo() {
        return threeNo;
    }

    public void setThreeNo(String threeNo) {
        this.threeNo = threeNo;
    }

    public String getFiveInsurance() {
        return fiveInsurance;
    }

    public void setFiveInsurance(String fiveInsurance) {
        this.fiveInsurance = fiveInsurance;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LivingCondition{" +
        "id=" + id +
        ", liveState=" + liveState +
        ", needHlep=" + needHlep +
        ", firstHlep=" + firstHlep +
        ", severeDisability=" + severeDisability +
        ", threeNo=" + threeNo +
        ", fiveInsurance=" + fiveInsurance +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", status=" + status +
        "}";
    }
}
