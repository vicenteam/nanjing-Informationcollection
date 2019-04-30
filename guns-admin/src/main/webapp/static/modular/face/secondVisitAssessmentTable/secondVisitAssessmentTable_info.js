/**
 * 初始化第二次走访数据采集详情对话框
 */
var SecondVisitAssessmentTableInfoDlg = {
    secondVisitAssessmentTableInfoData : {}
};

/**
 * 清除数据
 */
SecondVisitAssessmentTableInfoDlg.clearData = function() {
    this.secondVisitAssessmentTableInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SecondVisitAssessmentTableInfoDlg.set = function(key, val) {
    this.secondVisitAssessmentTableInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SecondVisitAssessmentTableInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SecondVisitAssessmentTableInfoDlg.close = function() {
    parent.layer.close(window.parent.SecondVisitAssessmentTable.layerIndex);
}

/**
 * 收集数据
 */
SecondVisitAssessmentTableInfoDlg.collectData = function() {
    this
    .set('id')
    .set('secondvisitName')
    .set('secondvisitSex')
    .set('secondvisitIdcard')
    .set('secondvisitAge')
    .set('secondvisitOthercard')
    .set('secondvisitEthnic')
    .set('secondvisitLevelOfEducation')
    .set('secondvisitMaritalStatus')
    .set('secondvisitAddress')
    .set('secondvisitHomePhone')
    .set('secondvisitPhoneNumber')
    .set('secondvisitLivingSituation')
    .set('secondvisitMedical')
    .set('secondvisitVisitObjectCategories')
    .set('secondvisitExpectationsPension')
    .set('secondvisitExpectationsPensionServer')
    .set('createtime')
    .set('createuserid')
    .set('deptid')
    .set('faceIdentifyTopId')
    .set('secondvisitMedicalOtherText')
    .set('secondvisitExpectationsPensionOtherText');
}

/**
 * 提交添加
 */
SecondVisitAssessmentTableInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/secondVisitAssessmentTable/add", function(data){
        Feng.success("添加成功!");
        window.parent.SecondVisitAssessmentTable.table.refresh();
        SecondVisitAssessmentTableInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondVisitAssessmentTableInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SecondVisitAssessmentTableInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/secondVisitAssessmentTable/update", function(data){
        Feng.success("修改成功!");
        window.parent.SecondVisitAssessmentTable.table.refresh();
        SecondVisitAssessmentTableInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondVisitAssessmentTableInfoData);
    ajax.start();
}

$(function() {

});
