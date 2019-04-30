package com.stylefeng.guns.modular.api.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "首次走访能力评估判断model")
public class FirstVisitStatusModel {
    @ApiModelProperty("是否首次走访能力评估信息 0存在信息,1不存在信息")
    private Integer num;
    @ApiModelProperty("文本")
    private String text;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
