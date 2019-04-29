/**
 * 初始化采集人健康信息表详情对话框
 */
var InformationHealthInfoDlg = {
    informationHealthInfoData : {}
};

/**
 * 清除数据
 */
InformationHealthInfoDlg.clearData = function() {
    this.informationHealthInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InformationHealthInfoDlg.set = function(key, val) {
    this.informationHealthInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InformationHealthInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
InformationHealthInfoDlg.close = function() {
    parent.layer.close(window.parent.InformationHealth.layerIndex);
}

/**
 * 收集数据
 */
InformationHealthInfoDlg.collectData = function() {
    this
    .set('id')
    .set('hearing')
    .set('helpHear')
    .set('health')
    .set('allergy')
    .set('allergyHistory')
    .set('allergyType')
    .set('everyEatDrugs')
    .set('bloodType')
    .set('ziLiType')
    .set('imei')
    .set('healthRecord')
    .set('testRecord')
    .set('allergyTypeOtherText')
    .set('healthOtherText');
}

/**
 * 提交添加
 */
InformationHealthInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/informationHealth/add", function(data){
        Feng.success("添加成功!");
        window.parent.InformationHealth.table.refresh();
        InformationHealthInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.informationHealthInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
InformationHealthInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/informationHealth/update", function(data){
        Feng.success("修改成功!");
        window.parent.InformationHealth.table.refresh();
        InformationHealthInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.informationHealthInfoData);
    ajax.start();
}

$(function() {

});
