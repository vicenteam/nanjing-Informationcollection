package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 采集人基本信息
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-29
 */
@TableName("face_information_personal")
@ApiModel(value = "采集人基本信息")
public class InformationPersonal extends Model<InformationPersonal> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("InformationPersonal_id")
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String fullName;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 民族
     */
    @ApiModelProperty("民族")
    private String minZu;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private String birthDate;
    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String cardId;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String telephone;
    /**
     * 座机
     */
    @ApiModelProperty("座机")
    private String telHome;
    /**
     * 用户类型(1.政府援助用户,2.商业用户)
     */
    @ApiModelProperty("用户类型(1.政府援助用户,2.商业用户)")
    private Integer userType;
    /**
     * 生活区域(1.城市,2.农村)
     */
    @ApiModelProperty("生活区域(1.城市,2.农村)")
    private Integer areaType;
    @ApiModelProperty("地址")
    private String address;
    /**
     * 现居住地址
     */
    @ApiModelProperty("现居住地址")
    private String nowAddress;
    /**
     * 婚姻状况(1.未婚，2.已婚，3.离异，4.丧偶)
     */
    @ApiModelProperty("婚姻状况(1.未婚，2.已婚，3.离异，4.丧偶)")
    private Integer maritalStatus;
    /**
     * 经济来源（1.养老金，2.子女供养，3.救济优抚，4.兼职，5.其他）
     */
    @ApiModelProperty("经济来源（1.养老金，2.子女供养，3.救济优抚，4.兼职，5.其他）")
    private String economics;
    /**
     * 证号
     */
    @ApiModelProperty("证号")
    private String certificateNum;
    /**
     * 证号类型（1.低保，2.优抚，3.失独，4.其他）
     */
    @ApiModelProperty("证号类型（1.低保，2.优抚，3.失独，4.其他）")
    private String certificateNumType;
    /**
     * 退休前职位
     */
    @ApiModelProperty("退休前职位")
    private String oldPosition;
    /**
     * 爱好
     */
    @ApiModelProperty("爱好")
    private String hobby;
    /**
     * 主表id
     */
    @ApiModelProperty("FaceIdentifyTop_id")
    private Integer parentId;
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String createDate;
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String updateDate;
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMinZu() {
        return minZu;
    }

    public void setMinZu(String minZu) {
        this.minZu = minZu;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEconomics() {
        return economics;
    }

    public void setEconomics(String economics) {
        this.economics = economics;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public String getCertificateNumType() {
        return certificateNumType;
    }

    public void setCertificateNumType(String certificateNumType) {
        this.certificateNumType = certificateNumType;
    }

    public String getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(String oldPosition) {
        this.oldPosition = oldPosition;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    @JsonIgnore
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
        return "InformationPersonal{" +
        "id=" + id +
        ", fullName=" + fullName +
        ", sex=" + sex +
        ", minZu=" + minZu +
        ", age=" + age +
        ", birthDate=" + birthDate +
        ", cardId=" + cardId +
        ", telephone=" + telephone +
        ", telHome=" + telHome +
        ", userType=" + userType +
        ", areaType=" + areaType +
        ", address=" + address +
        ", nowAddress=" + nowAddress +
        ", maritalStatus=" + maritalStatus +
        ", economics=" + economics +
        ", certificateNum=" + certificateNum +
        ", certificateNumType=" + certificateNumType +
        ", oldPosition=" + oldPosition +
        ", hobby=" + hobby +
        ", parentId=" + parentId +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", status=" + status +
        "}";
    }
}
