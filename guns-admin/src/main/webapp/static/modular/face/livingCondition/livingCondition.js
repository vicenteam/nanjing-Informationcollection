/**
 * 生活居住状况及社会关系管理初始化
 */
var LivingCondition = {
    id: "LivingConditionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
LivingCondition.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '居住状态', field: 'liveState', visible: true, align: 'center', valign: 'middle'},
            {title: '是否特困或者失能', field: 'needHlep', visible: true, align: 'center', valign: 'middle'},
            {title: '是否重点优抚', field: 'firstHlep', visible: true, align: 'center', valign: 'middle'},
            {title: '是否重度残疾', field: 'severeDisability', visible: true, align: 'center', valign: 'middle'},
            {title: '是否城市三无', field: 'threeNo', visible: true, align: 'center', valign: 'middle'},
            {title: '是否农村五保', field: 'fiveInsurance', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createDate', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'updateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
LivingCondition.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        LivingCondition.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加生活居住状况及社会关系
 */
LivingCondition.openAddLivingCondition = function () {
    var index = layer.open({
        type: 2,
        title: '添加生活居住状况及社会关系',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/livingCondition/livingCondition_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看生活居住状况及社会关系详情
 */
LivingCondition.openLivingConditionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '生活居住状况及社会关系详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/livingCondition/livingCondition_update/' + LivingCondition.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除生活居住状况及社会关系
 */
LivingCondition.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/livingCondition/delete", function (data) {
            Feng.success("删除成功!");
            LivingCondition.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("livingConditionId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询生活居住状况及社会关系列表
 */
LivingCondition.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    LivingCondition.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = LivingCondition.initColumn();
    var table = new BSTable(LivingCondition.id, "/livingCondition/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    LivingCondition.table = table.init();
});
