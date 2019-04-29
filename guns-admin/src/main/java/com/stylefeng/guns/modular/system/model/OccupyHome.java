package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 居家养老信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-29
 */
@TableName("face_occupy_home")
public class OccupyHome extends Model<OccupyHome> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 老人类别(0特困老人  1低保老人  2建档立卡贫困老人优抚对象  3失独老人  4残疾老人 
5计划生育特殊家庭成员  6其他 7空巢老人  8农村留守老人_)
     */
    @TableField("occupy_home_type")
    private String occupyHomeType;
    /**
     * 政府购买对象(0 70岁以上享受城乡低保待遇  1 80岁以上重点优抚对象 2 80岁以上失独老人)
     */
    @TableField("occupy_home_government_purchases")
    private String occupyHomeGovernmentPurchases;
    /**
     * 达到标准1(0介助   1介护)
     */
    @TableField("occupy_home_up_standard1")
    private String occupyHomeUpStandard1;
    /**
     * 达到标准2(0介助   1介护)
     */
    @TableField("occupy_home_up_standard2")
    private String occupyHomeUpStandard2;
    /**
     * 是否为政府购买对象(0 是 1否)
     */
    @TableField("occupy_home_government_to_buy")
    private String occupyHomeGovernmentToBuy;
    /**
     * 期望养老模式(0居家养老      1社区养老      2机构养老      3其他)
     */
    @TableField("occupy_home_expect_pension")
    private String occupyHomeExpectPension;
    /**
     * 期望的服务(0家政服务 1生活照料 2健康咨询  3精神慰藉  4陪同就医  5换季服务 )
     */
    @TableField("occupy_home_expect_server")
    private String occupyHomeExpectServer;
    private String createtime;
    private String createuserid;
    private Integer deptid;
    private Integer parentId;
    /**
     * 老人类别其他对应文本
     */
    @TableField("occupy_home_type_other_text")
    private String occupyHomeTypeOtherText;
    /**
     * 期望养老模式其他类型对应文本
     */
    @TableField("occupy_home_expect_pension_other_text")
    private String occupyHomeExpectPensionOtherText;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccupyHomeType() {
        return occupyHomeType;
    }

    public void setOccupyHomeType(String occupyHomeType) {
        this.occupyHomeType = occupyHomeType;
    }

    public String getOccupyHomeGovernmentPurchases() {
        return occupyHomeGovernmentPurchases;
    }

    public void setOccupyHomeGovernmentPurchases(String occupyHomeGovernmentPurchases) {
        this.occupyHomeGovernmentPurchases = occupyHomeGovernmentPurchases;
    }

    public String getOccupyHomeUpStandard1() {
        return occupyHomeUpStandard1;
    }

    public void setOccupyHomeUpStandard1(String occupyHomeUpStandard1) {
        this.occupyHomeUpStandard1 = occupyHomeUpStandard1;
    }

    public String getOccupyHomeUpStandard2() {
        return occupyHomeUpStandard2;
    }

    public void setOccupyHomeUpStandard2(String occupyHomeUpStandard2) {
        this.occupyHomeUpStandard2 = occupyHomeUpStandard2;
    }

    public String getOccupyHomeGovernmentToBuy() {
        return occupyHomeGovernmentToBuy;
    }

    public void setOccupyHomeGovernmentToBuy(String occupyHomeGovernmentToBuy) {
        this.occupyHomeGovernmentToBuy = occupyHomeGovernmentToBuy;
    }

    public String getOccupyHomeExpectPension() {
        return occupyHomeExpectPension;
    }

    public void setOccupyHomeExpectPension(String occupyHomeExpectPension) {
        this.occupyHomeExpectPension = occupyHomeExpectPension;
    }

    public String getOccupyHomeExpectServer() {
        return occupyHomeExpectServer;
    }

    public void setOccupyHomeExpectServer(String occupyHomeExpectServer) {
        this.occupyHomeExpectServer = occupyHomeExpectServer;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOccupyHomeTypeOtherText() {
        return occupyHomeTypeOtherText;
    }

    public void setOccupyHomeTypeOtherText(String occupyHomeTypeOtherText) {
        this.occupyHomeTypeOtherText = occupyHomeTypeOtherText;
    }

    public String getOccupyHomeExpectPensionOtherText() {
        return occupyHomeExpectPensionOtherText;
    }

    public void setOccupyHomeExpectPensionOtherText(String occupyHomeExpectPensionOtherText) {
        this.occupyHomeExpectPensionOtherText = occupyHomeExpectPensionOtherText;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OccupyHome{" +
        "id=" + id +
        ", occupyHomeType=" + occupyHomeType +
        ", occupyHomeGovernmentPurchases=" + occupyHomeGovernmentPurchases +
        ", occupyHomeUpStandard1=" + occupyHomeUpStandard1 +
        ", occupyHomeUpStandard2=" + occupyHomeUpStandard2 +
        ", occupyHomeGovernmentToBuy=" + occupyHomeGovernmentToBuy +
        ", occupyHomeExpectPension=" + occupyHomeExpectPension +
        ", occupyHomeExpectServer=" + occupyHomeExpectServer +
        ", createtime=" + createtime +
        ", createuserid=" + createuserid +
        ", deptid=" + deptid +
        ", parentId=" + parentId +
        ", occupyHomeTypeOtherText=" + occupyHomeTypeOtherText +
        ", occupyHomeExpectPensionOtherText=" + occupyHomeExpectPensionOtherText +
        "}";
    }
}
