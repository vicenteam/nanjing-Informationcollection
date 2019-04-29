/**
 * 初始化采集人基础信息详情对话框
 */
var InformationPersonalInfoDlg = {
    informationPersonalInfoData : {}
};

/**
 * 清除数据
 */
InformationPersonalInfoDlg.clearData = function() {
    this.informationPersonalInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InformationPersonalInfoDlg.set = function(key, val) {
    this.informationPersonalInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InformationPersonalInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
InformationPersonalInfoDlg.close = function() {
    parent.layer.close(window.parent.InformationPersonal.layerIndex);
}

/**
 * 收集数据
 */
InformationPersonalInfoDlg.collectData = function() {
    this
    .set('id')
    .set('fullName')
    .set('sex')
    .set('minZu')
    .set('age')
    .set('birthDate')
    .set('cardId')
    .set('telephone')
    .set('telHome')
    .set('userType')
    .set('areaType')
    .set('address')
    .set('nowAddress')
    .set('maritalStatus')
    .set('economics')
    .set('certificateNum')
    .set('certificateNumType')
    .set('oldPosition')
    .set('hobby')
    .set('parentId')
    .set('createDate')
    .set('updateDate')
    .set('status');
}

/**
 * 提交添加
 */
InformationPersonalInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/informationPersonal/add", function(data){
        Feng.success("添加成功!");
        window.parent.InformationPersonal.table.refresh();
        InformationPersonalInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.informationPersonalInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
InformationPersonalInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/informationPersonal/update", function(data){
        Feng.success("修改成功!");
        window.parent.InformationPersonal.table.refresh();
        InformationPersonalInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.informationPersonalInfoData);
    ajax.start();
}

$(function() {

});
