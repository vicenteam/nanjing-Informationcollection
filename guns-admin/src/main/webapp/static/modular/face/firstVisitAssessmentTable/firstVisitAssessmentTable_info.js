/**
 * 初始化基础信息详情对话框
 */
var FirstVisitAssessmentTableInfoDlg = {
    firstVisitAssessmentTableInfoData : {}
};

/**
 * 清除数据
 */
FirstVisitAssessmentTableInfoDlg.clearData = function() {
    this.firstVisitAssessmentTableInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FirstVisitAssessmentTableInfoDlg.set = function(key, val) {
    this.firstVisitAssessmentTableInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FirstVisitAssessmentTableInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
FirstVisitAssessmentTableInfoDlg.close = function() {
    parent.layer.close(window.parent.FirstVisitAssessmentTable.layerIndex);
}

/**
 * 收集数据
 */
FirstVisitAssessmentTableInfoDlg.collectData = function() {
    this
    .set('id')
    .set('firstvisitCommunity1')
    .set('firstvisitCommunity2')
    .set('firstvisitCommunity3')
    .set('firstvisitName')
    .set('firstvisitSex')
    .set('firstvisitLevelEducation')
    .set('firstvisitIdcard')
    .set('firstvisitOthercard')
    .set('firstvisitPhone')
    .set('firstvisitResidentialAddress')
    .set('firstvisitResidentialTime')
    .set('firstvisitEmergencyContact')
    .set('firstvisitProfessional')
    .set('firstvisitCategory')
    .set('firstvisitEconomicSources')
    .set('firstvisitMarital')
    .set('firstvisitChildren')
    .set('firstvisitMedicalCategory')
    .set('firstvisitLiving')
    .set('firstvisitLivingHouse')
    .set('firstvisitLivingElevator')
    .set('firstvisitLivingLayer')
    .set('firstvisitLivingToilet')
    .set('firstvisitLivingBathingFacilities')
    .set('firstvisitOriginalcareSituation')
    .set('firstvisitService')
    .set('firstvisitPhysicalConditionRadio')
    .set('firstvisitPhysicalConditionCheckbox')
    .set('firstvisitPsychological')
    .set('firstvisitSocialActivities')
    .set('firstvisitSocialActivitiesType');
}

/**
 * 提交添加
 */
FirstVisitAssessmentTableInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/firstVisitAssessmentTable/add", function(data){
        Feng.success("添加成功!");
        window.parent.FirstVisitAssessmentTable.table.refresh();
        FirstVisitAssessmentTableInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.firstVisitAssessmentTableInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
FirstVisitAssessmentTableInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/firstVisitAssessmentTable/update", function(data){
        Feng.success("修改成功!");
        window.parent.FirstVisitAssessmentTable.table.refresh();
        FirstVisitAssessmentTableInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.firstVisitAssessmentTableInfoData);
    ajax.start();
}

$(function() {

});
