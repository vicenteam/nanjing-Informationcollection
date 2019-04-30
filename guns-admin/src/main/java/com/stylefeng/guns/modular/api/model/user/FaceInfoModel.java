package com.stylefeng.guns.modular.api.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "识别结果model")
public class FaceInfoModel {
    @ApiModelProperty("识别结果类型 0存在信息,1不存在信息")
    private Integer type;
    @ApiModelProperty("识别结果(身份证)")
    private String idCard;
    @ApiModelProperty("识别结果(姓名)")
    private String name;
    @ApiModelProperty("识别结果(头像地址)")
    private String imgUrl;

//    @ApiModelProperty("识别结果(头像base64字符)")
//    private String imgBase64;

    @ApiModelProperty("识别结果(FaceIdentifyTop_id)")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getImgBase64() {
//        return imgBase64;
//    }
//
//    public void setImgBase64(String imgBase64) {
//        this.imgBase64 = imgBase64;
//    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
