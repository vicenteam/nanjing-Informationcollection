/**
 * 初始化媒体信息详情对话框
 */
var IdentiflMediaResouceInfoDlg = {
    identiflMediaResouceInfoData : {}
};

/**
 * 清除数据
 */
IdentiflMediaResouceInfoDlg.clearData = function() {
    this.identiflMediaResouceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IdentiflMediaResouceInfoDlg.set = function(key, val) {
    this.identiflMediaResouceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IdentiflMediaResouceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IdentiflMediaResouceInfoDlg.close = function() {
    parent.layer.close(window.parent.IdentiflMediaResouce.layerIndex);
}

/**
 * 收集数据
 */
IdentiflMediaResouceInfoDlg.collectData = function() {
    this
    .set('id')
    .set('tableid')
    .set('vmediaurl')
    .set('smediaurl')
    .set('imgurl')
    .set('createtime')
    .set('updatetime')
    .set('status')
    .set('createuserid')
    .set('deptid');
}

/**
 * 提交添加
 */
IdentiflMediaResouceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/identiflMediaResouce/add", function(data){
        Feng.success("添加成功!");
        window.parent.IdentiflMediaResouce.table.refresh();
        IdentiflMediaResouceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.identiflMediaResouceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IdentiflMediaResouceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/identiflMediaResouce/update", function(data){
        Feng.success("修改成功!");
        window.parent.IdentiflMediaResouce.table.refresh();
        IdentiflMediaResouceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.identiflMediaResouceInfoData);
    ajax.start();
}

$(function() {

});
