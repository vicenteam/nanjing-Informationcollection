package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 采集用户识别基础库
 * </p>
 *
 * @author stylefeng
 * @since 2019-02-18
 */
@TableName("face_identify_top")
public class FaceIdentifyTop extends Model<FaceIdentifyTop> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 姓名
     */
    private String username;
    /**
     * 百度aifacetocken
     */
    @TableField("face_token")
    private String faceToken;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 修改时间
     */
    private String updatetime;
    /**
     * 创建人
     */
    private String createuserid;
    private Integer status;
    /**
     * 修改人id
     */
    private String updateuserid;
    private Integer deptid;
    /**
     * 采集信息base64图片字符串
     */
    private String imgbase64;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getImgbase64() {
        return imgbase64;
    }

    public void setImgbase64(String imgbase64) {
        this.imgbase64 = imgbase64;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FaceIdentifyTop{" +
        "id=" + id +
        ", idcard=" + idcard +
        ", username=" + username +
        ", faceToken=" + faceToken +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", createuserid=" + createuserid +
        ", status=" + status +
        ", updateuserid=" + updateuserid +
        ", deptid=" + deptid +
        ", imgbase64=" + imgbase64 +
        "}";
    }
}
