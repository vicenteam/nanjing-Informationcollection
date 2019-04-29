/**
 * 服务信息管理初始化
 */
var InformationService = {
    id: "InformationServiceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
InformationService.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '服务类型（1.信息服务，2.实体服务）', field: 'serviceType', visible: true, align: 'center', valign: 'middle'},
            {title: '服务状态（）', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '用户手机套餐', field: 'phoneMeal', visible: true, align: 'center', valign: 'middle'},
            {title: '用户手机型号', field: 'phoneType', visible: true, align: 'center', valign: 'middle'},
            {title: '用户享受的服务类别', field: 'personServiceType', visible: true, align: 'center', valign: 'middle'},
            {title: '政府援助次数', field: 'govNum', visible: true, align: 'center', valign: 'middle'},
            {title: '状态变更原因', field: 'changeStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '审核拒绝原因', field: 'refuse', visible: true, align: 'center', valign: 'middle'},
            {title: '主表id', field: 'parentId', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createDate', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'updateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
InformationService.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        InformationService.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加服务信息
 */
InformationService.openAddInformationService = function () {
    var index = layer.open({
        type: 2,
        title: '添加服务信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/informationService/informationService_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看服务信息详情
 */
InformationService.openInformationServiceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '服务信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/informationService/informationService_update/' + InformationService.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除服务信息
 */
InformationService.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/informationService/delete", function (data) {
            Feng.success("删除成功!");
            InformationService.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("informationServiceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询服务信息列表
 */
InformationService.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    InformationService.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = InformationService.initColumn();
    var table = new BSTable(InformationService.id, "/informationService/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    InformationService.table = table.init();
});
