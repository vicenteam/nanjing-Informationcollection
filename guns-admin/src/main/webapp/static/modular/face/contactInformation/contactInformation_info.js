/**
 * 初始化紧急联系人详情对话框
 */
var ContactInformationInfoDlg = {
    contactInformationInfoData : {}
};

/**
 * 清除数据
 */
ContactInformationInfoDlg.clearData = function() {
    this.contactInformationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ContactInformationInfoDlg.set = function(key, val) {
    this.contactInformationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ContactInformationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ContactInformationInfoDlg.close = function() {
    parent.layer.close(window.parent.ContactInformation.layerIndex);
}

/**
 * 收集数据
 */
ContactInformationInfoDlg.collectData = function() {
    this
    .set('id')
    .set('contactInformationVolunteers1')
    .set('contactInformationVolunteers1Phone')
    .set('contactInformationVolunteers2')
    .set('contactInformationVolunteers2Phone')
    .set('contactInformationVolunteers3')
    .set('contactInformationVolunteers3Phone')
    .set('contactInformationSpouseName')
    .set('contactInformationSpouseRelationship')
    .set('contactInformationSpouseSex')
    .set('contactInformationSpouseAge')
    .set('contactInformationSpouseEthnic')
    .set('contactInformationSpouseIdcard')
    .set('contactInformationSpouseResidence')
    .set('contactInformationSpousePhone')
    .set('contactInformationSpouseAddress')
    .set('contactInformationContact2Name')
    .set('contactInformationContact2Relationship')
    .set('contactInformationContact2Sex')
    .set('contactInformationContact2Phone1')
    .set('contactInformationContact2Phone2')
    .set('contactInformationContact2Address')
    .set('contactInformationContact3Name')
    .set('contactInformationContact3Relationship')
    .set('contactInformationContact3Sex')
    .set('contactInformationContact3Phone1')
    .set('contactInformationContact3Phone2')
    .set('contactInformationContact3Address')
    .set('createtime')
    .set('createuserid')
    .set('deptid');
}

/**
 * 提交添加
 */
ContactInformationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/contactInformation/add", function(data){
        Feng.success("添加成功!");
        window.parent.ContactInformation.table.refresh();
        ContactInformationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.contactInformationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ContactInformationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/contactInformation/update", function(data){
        Feng.success("修改成功!");
        window.parent.ContactInformation.table.refresh();
        ContactInformationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.contactInformationInfoData);
    ajax.start();
}

$(function() {

});
