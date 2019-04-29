/**
 * 初始化居家养老信息详情对话框
 */
var OccupyHomeInfoDlg = {
    occupyHomeInfoData : {}
};

/**
 * 清除数据
 */
OccupyHomeInfoDlg.clearData = function() {
    this.occupyHomeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OccupyHomeInfoDlg.set = function(key, val) {
    this.occupyHomeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OccupyHomeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OccupyHomeInfoDlg.close = function() {
    parent.layer.close(window.parent.OccupyHome.layerIndex);
}

/**
 * 收集数据
 */
OccupyHomeInfoDlg.collectData = function() {
    this
    .set('id')
    .set('occupyHomeType')
    .set('occupyHomeGovernmentPurchases')
    .set('occupyHomeUpStandard1')
    .set('occupyHomeUpStandard2')
    .set('occupyHomeGovernmentToBuy')
    .set('occupyHomeExpectPension')
    .set('occupyHomeExpectServer')
    .set('createtime')
    .set('createuserid')
    .set('deptid')
    .set('parentId')
    .set('occupyHomeTypeOtherText')
    .set('occupyHomeExpectPensionOtherText');
}

/**
 * 提交添加
 */
OccupyHomeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/occupyHome/add", function(data){
        Feng.success("添加成功!");
        window.parent.OccupyHome.table.refresh();
        OccupyHomeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.occupyHomeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OccupyHomeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/occupyHome/update", function(data){
        Feng.success("修改成功!");
        window.parent.OccupyHome.table.refresh();
        OccupyHomeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.occupyHomeInfoData);
    ajax.start();
}

$(function() {

});
