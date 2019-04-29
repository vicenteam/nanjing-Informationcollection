/**
 * 初始化生活居住状况及社会关系详情对话框
 */
var LivingConditionInfoDlg = {
    livingConditionInfoData : {}
};

/**
 * 清除数据
 */
LivingConditionInfoDlg.clearData = function() {
    this.livingConditionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LivingConditionInfoDlg.set = function(key, val) {
    this.livingConditionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LivingConditionInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
LivingConditionInfoDlg.close = function() {
    parent.layer.close(window.parent.LivingCondition.layerIndex);
}

/**
 * 收集数据
 */
LivingConditionInfoDlg.collectData = function() {
    this
    .set('id')
    .set('liveState')
    .set('needHlep')
    .set('firstHlep')
    .set('severeDisability')
    .set('threeNo')
    .set('fiveInsurance')
    .set('createDate')
    .set('updateDate')
    .set('status');
}

/**
 * 提交添加
 */
LivingConditionInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/livingCondition/add", function(data){
        Feng.success("添加成功!");
        window.parent.LivingCondition.table.refresh();
        LivingConditionInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.livingConditionInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
LivingConditionInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/livingCondition/update", function(data){
        Feng.success("修改成功!");
        window.parent.LivingCondition.table.refresh();
        LivingConditionInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.livingConditionInfoData);
    ajax.start();
}

$(function() {

});
