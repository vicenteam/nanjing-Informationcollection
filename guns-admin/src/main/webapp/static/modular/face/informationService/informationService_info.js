/**
 * 初始化服务信息详情对话框
 */
var InformationServiceInfoDlg = {
    informationServiceInfoData : {}
};

/**
 * 清除数据
 */
InformationServiceInfoDlg.clearData = function() {
    this.informationServiceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InformationServiceInfoDlg.set = function(key, val) {
    this.informationServiceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InformationServiceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
InformationServiceInfoDlg.close = function() {
    parent.layer.close(window.parent.InformationService.layerIndex);
}

/**
 * 收集数据
 */
InformationServiceInfoDlg.collectData = function() {
    this
    .set('id')
    .set('serviceType')
    .set('state')
    .set('phoneMeal')
    .set('phoneType')
    .set('personServiceType')
    .set('govNum')
    .set('changeStatus')
    .set('refuse')
    .set('parentId')
    .set('createDate')
    .set('updateDate')
    .set('status');
}

/**
 * 提交添加
 */
InformationServiceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/informationService/add", function(data){
        Feng.success("添加成功!");
        window.parent.InformationService.table.refresh();
        InformationServiceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.informationServiceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
InformationServiceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/informationService/update", function(data){
        Feng.success("修改成功!");
        window.parent.InformationService.table.refresh();
        InformationServiceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.informationServiceInfoData);
    ajax.start();
}

$(function() {

});
