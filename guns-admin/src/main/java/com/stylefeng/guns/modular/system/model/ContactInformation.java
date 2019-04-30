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
 * 紧急联系人基础信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
@TableName("face_contact_information")
@ApiModel(value = "紧急联系人Model")
public class ContactInformation extends Model<ContactInformation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("ContactInformation_id")
    private Integer id;
    /**
     * 志愿者一
     */
    @ApiModelProperty("志愿者一")
    @TableField("contact_information_volunteers1")
    private String contactInformationVolunteers1;
    /**
     * 志愿者一电话
     */
    @ApiModelProperty("志愿者一电话")
    @TableField("contact_information_volunteers1_phone")
    private String contactInformationVolunteers1Phone;
    @ApiModelProperty("志愿者二")
    @TableField("contact_information_volunteers2")
    private String contactInformationVolunteers2;
    @ApiModelProperty("志愿者二电话")
    @TableField("contact_information_volunteers2_phone")
    private String contactInformationVolunteers2Phone;
    @TableField("contact_information_volunteers3")
    @ApiModelProperty("志愿者三")
    private String contactInformationVolunteers3;
    @ApiModelProperty("志愿者三电话")
    @TableField("contact_information_volunteers3_phone")
    private String contactInformationVolunteers3Phone;
    /**
     * 配偶紧急联系人一 姓名
     */
    @ApiModelProperty("配偶紧急联系人一 姓名")
    @TableField("contact_information_spouse_name")
    private String contactInformationSpouseName;
    /**
     * 关系
     */
    @ApiModelProperty("配偶紧急联系人一 关系")
    @TableField("contact_information_spouse_relationship")
    private String contactInformationSpouseRelationship;
    /**
     * 性别
     */
    @ApiModelProperty("配偶紧急联系人一 性别")
    @TableField("contact_information_spouse_sex")
    private String contactInformationSpouseSex;
    /**
     * 年龄
     */
    @ApiModelProperty("配偶紧急联系人一 年龄")
    @TableField("contact_information_spouse_age")
    private String contactInformationSpouseAge;
    /**
     * 名族
     */
    @ApiModelProperty("配偶紧急联系人一 名族")
    @TableField("contact_information_spouse_ethnic")
    private String contactInformationSpouseEthnic;
    /**
     * 身份证
     */
    @ApiModelProperty("配偶紧急联系人一 身份证")
    @TableField("contact_information_spouse_idcard")
    private String contactInformationSpouseIdcard;
    /**
     * 户口所在地
     */
    @ApiModelProperty("配偶紧急联系人一 户口所在地")
    @TableField("contact_information_spouse_residence")
    private String contactInformationSpouseResidence;
    /**
     * 联 系 电 话
     */
    @ApiModelProperty("急联系人一 电话")
    @TableField("contact_information_spouse_phone")
    private String contactInformationSpousePhone;
    /**
     * 联 系 地 址
     */
    @ApiModelProperty("急联系人一 地址")
    @TableField("contact_information_spouse_address")
    private String contactInformationSpouseAddress;
    /**
     * 姓  名
     */
    @ApiModelProperty("急联系人二 姓名")
    @TableField("contact_information_contact2_name")
    private String contactInformationContact2Name;
    /**
     * 关系
     */
    @ApiModelProperty("急联系人二 关系")
    @TableField("contact_information_contact2_relationship")
    private String contactInformationContact2Relationship;
    /**
     * 性别
     */
    @ApiModelProperty("急联系人二 性别")
    @TableField("contact_information_contact2_sex")
    private String contactInformationContact2Sex;
    /**
     * 联系电话
     */
    @ApiModelProperty("急联系人二 电话")
    @TableField("contact_information_contact2_phone1")
    private String contactInformationContact2Phone1;
    /**
     * 备用电话
     */
    @ApiModelProperty("急联系人二 备用电话")
    @TableField("contact_information_contact2_phone2")
    private String contactInformationContact2Phone2;
    /**
     * 联系地址
     */
    @ApiModelProperty("急联系人二 地址")
    @TableField("contact_information_contact2_address")
    private String contactInformationContact2Address;
    @ApiModelProperty("紧急联系人三 姓名")
    @TableField("contact_information_contact3_name")
    private String contactInformationContact3Name;
    @ApiModelProperty("紧急联系人三 关系")
    @TableField("contact_information_contact3_relationship")
    private String contactInformationContact3Relationship;
    @TableField("contact_information_contact3_sex")
    @ApiModelProperty("紧急联系人三 性别")
    private String contactInformationContact3Sex;
    @TableField("contact_information_contact3_phone1")
    @ApiModelProperty("紧急联系人三 电话")
    private String contactInformationContact3Phone1;
    @TableField("contact_information_contact3_phone2")
    @ApiModelProperty("紧急联系人三 备用电话")
    private String contactInformationContact3Phone2;
    @TableField("contact_information_contact3_address")
    @ApiModelProperty("紧急联系人三 地址")
    private String contactInformationContact3Address;
    @ApiModelProperty(hidden = true)
    private String createtime;
    @ApiModelProperty(hidden = true)
    private Integer createuserid;
    @ApiModelProperty(hidden = true)
    private Integer deptid;
    @ApiModelProperty("InfomationPersonal_id")
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

    public String getContactInformationVolunteers1() {
        return contactInformationVolunteers1;
    }

    public void setContactInformationVolunteers1(String contactInformationVolunteers1) {
        this.contactInformationVolunteers1 = contactInformationVolunteers1;
    }

    public String getContactInformationVolunteers1Phone() {
        return contactInformationVolunteers1Phone;
    }

    public void setContactInformationVolunteers1Phone(String contactInformationVolunteers1Phone) {
        this.contactInformationVolunteers1Phone = contactInformationVolunteers1Phone;
    }

    public String getContactInformationVolunteers2() {
        return contactInformationVolunteers2;
    }

    public void setContactInformationVolunteers2(String contactInformationVolunteers2) {
        this.contactInformationVolunteers2 = contactInformationVolunteers2;
    }

    public String getContactInformationVolunteers2Phone() {
        return contactInformationVolunteers2Phone;
    }

    public void setContactInformationVolunteers2Phone(String contactInformationVolunteers2Phone) {
        this.contactInformationVolunteers2Phone = contactInformationVolunteers2Phone;
    }

    public String getContactInformationVolunteers3() {
        return contactInformationVolunteers3;
    }

    public void setContactInformationVolunteers3(String contactInformationVolunteers3) {
        this.contactInformationVolunteers3 = contactInformationVolunteers3;
    }

    public String getContactInformationVolunteers3Phone() {
        return contactInformationVolunteers3Phone;
    }

    public void setContactInformationVolunteers3Phone(String contactInformationVolunteers3Phone) {
        this.contactInformationVolunteers3Phone = contactInformationVolunteers3Phone;
    }

    public String getContactInformationSpouseName() {
        return contactInformationSpouseName;
    }

    public void setContactInformationSpouseName(String contactInformationSpouseName) {
        this.contactInformationSpouseName = contactInformationSpouseName;
    }

    public String getContactInformationSpouseRelationship() {
        return contactInformationSpouseRelationship;
    }

    public void setContactInformationSpouseRelationship(String contactInformationSpouseRelationship) {
        this.contactInformationSpouseRelationship = contactInformationSpouseRelationship;
    }

    public String getContactInformationSpouseSex() {
        return contactInformationSpouseSex;
    }

    public void setContactInformationSpouseSex(String contactInformationSpouseSex) {
        this.contactInformationSpouseSex = contactInformationSpouseSex;
    }

    public String getContactInformationSpouseAge() {
        return contactInformationSpouseAge;
    }

    public void setContactInformationSpouseAge(String contactInformationSpouseAge) {
        this.contactInformationSpouseAge = contactInformationSpouseAge;
    }

    public String getContactInformationSpouseEthnic() {
        return contactInformationSpouseEthnic;
    }

    public void setContactInformationSpouseEthnic(String contactInformationSpouseEthnic) {
        this.contactInformationSpouseEthnic = contactInformationSpouseEthnic;
    }

    public String getContactInformationSpouseIdcard() {
        return contactInformationSpouseIdcard;
    }

    public void setContactInformationSpouseIdcard(String contactInformationSpouseIdcard) {
        this.contactInformationSpouseIdcard = contactInformationSpouseIdcard;
    }

    public String getContactInformationSpouseResidence() {
        return contactInformationSpouseResidence;
    }

    public void setContactInformationSpouseResidence(String contactInformationSpouseResidence) {
        this.contactInformationSpouseResidence = contactInformationSpouseResidence;
    }

    public String getContactInformationSpousePhone() {
        return contactInformationSpousePhone;
    }

    public void setContactInformationSpousePhone(String contactInformationSpousePhone) {
        this.contactInformationSpousePhone = contactInformationSpousePhone;
    }

    public String getContactInformationSpouseAddress() {
        return contactInformationSpouseAddress;
    }

    public void setContactInformationSpouseAddress(String contactInformationSpouseAddress) {
        this.contactInformationSpouseAddress = contactInformationSpouseAddress;
    }

    public String getContactInformationContact2Name() {
        return contactInformationContact2Name;
    }

    public void setContactInformationContact2Name(String contactInformationContact2Name) {
        this.contactInformationContact2Name = contactInformationContact2Name;
    }

    public String getContactInformationContact2Relationship() {
        return contactInformationContact2Relationship;
    }

    public void setContactInformationContact2Relationship(String contactInformationContact2Relationship) {
        this.contactInformationContact2Relationship = contactInformationContact2Relationship;
    }

    public String getContactInformationContact2Sex() {
        return contactInformationContact2Sex;
    }

    public void setContactInformationContact2Sex(String contactInformationContact2Sex) {
        this.contactInformationContact2Sex = contactInformationContact2Sex;
    }

    public String getContactInformationContact2Phone1() {
        return contactInformationContact2Phone1;
    }

    public void setContactInformationContact2Phone1(String contactInformationContact2Phone1) {
        this.contactInformationContact2Phone1 = contactInformationContact2Phone1;
    }

    public String getContactInformationContact2Phone2() {
        return contactInformationContact2Phone2;
    }

    public void setContactInformationContact2Phone2(String contactInformationContact2Phone2) {
        this.contactInformationContact2Phone2 = contactInformationContact2Phone2;
    }

    public String getContactInformationContact2Address() {
        return contactInformationContact2Address;
    }

    public void setContactInformationContact2Address(String contactInformationContact2Address) {
        this.contactInformationContact2Address = contactInformationContact2Address;
    }

    public String getContactInformationContact3Name() {
        return contactInformationContact3Name;
    }

    public void setContactInformationContact3Name(String contactInformationContact3Name) {
        this.contactInformationContact3Name = contactInformationContact3Name;
    }

    public String getContactInformationContact3Relationship() {
        return contactInformationContact3Relationship;
    }

    public void setContactInformationContact3Relationship(String contactInformationContact3Relationship) {
        this.contactInformationContact3Relationship = contactInformationContact3Relationship;
    }

    public String getContactInformationContact3Sex() {
        return contactInformationContact3Sex;
    }

    public void setContactInformationContact3Sex(String contactInformationContact3Sex) {
        this.contactInformationContact3Sex = contactInformationContact3Sex;
    }

    public String getContactInformationContact3Phone1() {
        return contactInformationContact3Phone1;
    }

    public void setContactInformationContact3Phone1(String contactInformationContact3Phone1) {
        this.contactInformationContact3Phone1 = contactInformationContact3Phone1;
    }

    public String getContactInformationContact3Phone2() {
        return contactInformationContact3Phone2;
    }

    public void setContactInformationContact3Phone2(String contactInformationContact3Phone2) {
        this.contactInformationContact3Phone2 = contactInformationContact3Phone2;
    }

    public String getContactInformationContact3Address() {
        return contactInformationContact3Address;
    }

    public void setContactInformationContact3Address(String contactInformationContact3Address) {
        this.contactInformationContact3Address = contactInformationContact3Address;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
        "id=" + id +
        ", contactInformationVolunteers1=" + contactInformationVolunteers1 +
        ", contactInformationVolunteers1Phone=" + contactInformationVolunteers1Phone +
        ", contactInformationVolunteers2=" + contactInformationVolunteers2 +
        ", contactInformationVolunteers2Phone=" + contactInformationVolunteers2Phone +
        ", contactInformationVolunteers3=" + contactInformationVolunteers3 +
        ", contactInformationVolunteers3Phone=" + contactInformationVolunteers3Phone +
        ", contactInformationSpouseName=" + contactInformationSpouseName +
        ", contactInformationSpouseRelationship=" + contactInformationSpouseRelationship +
        ", contactInformationSpouseSex=" + contactInformationSpouseSex +
        ", contactInformationSpouseAge=" + contactInformationSpouseAge +
        ", contactInformationSpouseEthnic=" + contactInformationSpouseEthnic +
        ", contactInformationSpouseIdcard=" + contactInformationSpouseIdcard +
        ", contactInformationSpouseResidence=" + contactInformationSpouseResidence +
        ", contactInformationSpousePhone=" + contactInformationSpousePhone +
        ", contactInformationSpouseAddress=" + contactInformationSpouseAddress +
        ", contactInformationContact2Name=" + contactInformationContact2Name +
        ", contactInformationContact2Relationship=" + contactInformationContact2Relationship +
        ", contactInformationContact2Sex=" + contactInformationContact2Sex +
        ", contactInformationContact2Phone1=" + contactInformationContact2Phone1 +
        ", contactInformationContact2Phone2=" + contactInformationContact2Phone2 +
        ", contactInformationContact2Address=" + contactInformationContact2Address +
        ", contactInformationContact3Name=" + contactInformationContact3Name +
        ", contactInformationContact3Relationship=" + contactInformationContact3Relationship +
        ", contactInformationContact3Sex=" + contactInformationContact3Sex +
        ", contactInformationContact3Phone1=" + contactInformationContact3Phone1 +
        ", contactInformationContact3Phone2=" + contactInformationContact3Phone2 +
        ", contactInformationContact3Address=" + contactInformationContact3Address +
        ", createtime=" + createtime +
        ", createuserid=" + createuserid +
        ", deptid=" + deptid +
        "}";
    }
}
