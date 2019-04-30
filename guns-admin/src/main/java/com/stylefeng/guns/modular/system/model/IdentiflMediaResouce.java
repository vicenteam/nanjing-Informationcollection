package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 媒体信息
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
@TableName("face_identifl_media_resouce")
@ApiModel(value = "媒体信息Model")
public class IdentiflMediaResouce extends Model<IdentiflMediaResouce> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("IdentiflMediaResouce_id")
    private Integer id;
    /**
     * 所属表单
     */
    @ApiModelProperty("所属表单")
    private Integer tableid;
    /**
     * 视频图片地址（ ,  逗号隔开）
     */
    @ApiModelProperty("视频图片地址（ ,  逗号隔开）")
    private String vmediaurl;
    /**
     * 音频媒体资源名称
     */
    @ApiModelProperty("音频媒体资源")
    private String smediaurl;
    /**
     * 签名图片url名称
     */
    @ApiModelProperty("签名图片名称")
    private String imgurl;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createtime;
    @ApiModelProperty(hidden = true)
    private String updatetime;
    /**
     * 资源来源状态 0第一次走访信息 1第二次走访信息
     */
    @ApiModelProperty("资源来源状态 0第一次走访信息 1第二次走访信息")
    private String status;
    /**
     * 创建人
     */
    @ApiModelProperty(hidden = true)
    private Integer createuserid;
    @ApiModelProperty(hidden = true)
    private Integer deptid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getVmediaurl() {
        return vmediaurl;
    }

    public void setVmediaurl(String vmediaurl) {
        this.vmediaurl = vmediaurl;
    }

    public String getSmediaurl() {
        return smediaurl;
    }

    public void setSmediaurl(String smediaurl) {
        this.smediaurl = smediaurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "IdentiflMediaResouce{" +
        "id=" + id +
        ", tableid=" + tableid +
        ", vmediaurl=" + vmediaurl +
        ", smediaurl=" + smediaurl +
        ", imgurl=" + imgurl +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", status=" + status +
        ", createuserid=" + createuserid +
        ", deptid=" + deptid +
        "}";
    }
}
