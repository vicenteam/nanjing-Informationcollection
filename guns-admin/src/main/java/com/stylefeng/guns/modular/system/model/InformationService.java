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
 * 服务信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-29
 */
@TableName("face_information_service")
@ApiModel(value = "采集人服务信息")
public class InformationService extends Model<InformationService> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("InformationService_id")
    private Integer id;
    /**
     * 服务类型（1.信息服务，2.实体服务）
     */
    @TableField("service_type")
    @ApiModelProperty("服务类型（1.信息服务，2.实体服务）")
    private String serviceType;
    /**
     * 服务状态（ 1 待签约）
     */
    @ApiModelProperty("服务状态（ 1 待签约）")
    private String state;
    /**
     * 用户手机套餐
     */
    @TableField("phone_meal")
    @ApiModelProperty("用户手机套餐")
    private String phoneMeal;
    /**
     * 用户手机型号
     */
    @TableField("phone_type")
    @ApiModelProperty("用户手机型号")
    private String phoneType;
    /**
     * 用户享受的服务类别
     */
    @TableField("person_service_type")
    @ApiModelProperty("用户享受的服务类别")
    private String personServiceType;
    /**
     * 政府援助次数
     */
    @TableField("gov_num")
    @ApiModelProperty("政府援助次数")
    private String govNum;
    /**
     * 状态变更原因
     */
    @TableField("change_status")
    @ApiModelProperty("状态变更原因")
    private String changeStatus;
    /**
     * 审核拒绝原因
     */
    @ApiModelProperty("审核拒绝原因")
    private String refuse;
    /**
     * 主表id
     */
    @TableField("parent_id")
    @ApiModelProperty("主表InformationPersonal id")
    private Integer parentId;
    @TableField("create_date")
    @ApiModelProperty(hidden = true)
    private String createDate;
    @TableField("update_date")
    @ApiModelProperty(hidden = true)
    private String updateDate;
    @ApiModelProperty(hidden = true)
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneMeal() {
        return phoneMeal;
    }

    public void setPhoneMeal(String phoneMeal) {
        this.phoneMeal = phoneMeal;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPersonServiceType() {
        return personServiceType;
    }

    public void setPersonServiceType(String personServiceType) {
        this.personServiceType = personServiceType;
    }

    public String getGovNum() {
        return govNum;
    }

    public void setGovNum(String govNum) {
        this.govNum = govNum;
    }

    public String getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus;
    }

    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "InformationService{" +
        "id=" + id +
        ", serviceType=" + serviceType +
        ", state=" + state +
        ", phoneMeal=" + phoneMeal +
        ", phoneType=" + phoneType +
        ", personServiceType=" + personServiceType +
        ", govNum=" + govNum +
        ", changeStatus=" + changeStatus +
        ", refuse=" + refuse +
        ", parentId=" + parentId +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", status=" + status +
        "}";
    }
}
