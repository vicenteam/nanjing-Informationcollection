/**
 * 媒体信息管理初始化
 */
var IdentiflMediaResouce = {
    id: "IdentiflMediaResouceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IdentiflMediaResouce.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '所属表单', field: 'tableid', visible: true, align: 'center', valign: 'middle'},
            {title: '视频图片地址（ ,  逗号隔开）', field: 'vmediaurl', visible: true, align: 'center', valign: 'middle'},
            {title: '音频媒体资源名称', field: 'smediaurl', visible: true, align: 'center', valign: 'middle'},
            {title: '签名图片url名称', field: 'imgurl', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'updatetime', visible: true, align: 'center', valign: 'middle'},
            {title: '资源来源状态 0第一次走访信息 1第二次走访信息', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人', field: 'createuserid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'deptid', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
IdentiflMediaResouce.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        IdentiflMediaResouce.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加媒体信息
 */
IdentiflMediaResouce.openAddIdentiflMediaResouce = function () {
    var index = layer.open({
        type: 2,
        title: '添加媒体信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/identiflMediaResouce/identiflMediaResouce_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看媒体信息详情
 */
IdentiflMediaResouce.openIdentiflMediaResouceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '媒体信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/identiflMediaResouce/identiflMediaResouce_update/' + IdentiflMediaResouce.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除媒体信息
 */
IdentiflMediaResouce.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/identiflMediaResouce/delete", function (data) {
            Feng.success("删除成功!");
            IdentiflMediaResouce.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("identiflMediaResouceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询媒体信息列表
 */
IdentiflMediaResouce.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    IdentiflMediaResouce.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = IdentiflMediaResouce.initColumn();
    var table = new BSTable(IdentiflMediaResouce.id, "/identiflMediaResouce/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    IdentiflMediaResouce.table = table.init();
});
