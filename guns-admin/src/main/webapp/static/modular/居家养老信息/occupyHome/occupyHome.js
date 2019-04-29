/**
 * face管理初始化
 */
var OccupyHome = {
    id: "OccupyHomeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OccupyHome.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '老人类别(0特困老人  1低保老人  2建档立卡贫困老人优抚对象  3失独老人  4残疾老人 
5计划生育特殊家庭成员  6其他 7空巢老人  8农村留守老人_)', field: 'occupyHomeType', visible: true, align: 'center', valign: 'middle'},
            {title: '政府购买对象(0 70岁以上享受城乡低保待遇  1 80岁以上重点优抚对象 2 80岁以上失独老人)', field: 'occupyHomeGovernmentPurchases', visible: true, align: 'center', valign: 'middle'},
            {title: '达到标准1(0介助   1介护)', field: 'occupyHomeUpStandard1', visible: true, align: 'center', valign: 'middle'},
            {title: '达到标准2(0介助   1介护)', field: 'occupyHomeUpStandard2', visible: true, align: 'center', valign: 'middle'},
            {title: '是否为政府购买对象(0 是 1否)', field: 'occupyHomeGovernment toBuy', visible: true, align: 'center', valign: 'middle'},
            {title: '期望养老模式(0居家养老      1社区养老      2机构养老      3其他)', field: 'occupyHomeExpectPension', visible: true, align: 'center', valign: 'middle'},
            {title: '期望的服务(0家政服务 1生活照料 2健康咨询  3精神慰藉  4陪同就医  5换季服务 )', field: 'occupyHomeExpectServer', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createuserid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'deptid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'parentId', visible: true, align: 'center', valign: 'middle'},
            {title: '老人类别其他对应文本', field: 'occupyHomeTypeOtherText', visible: true, align: 'center', valign: 'middle'},
            {title: '期望养老模式其他类型对应文本', field: 'occupyHomeExpectPensionOtherText', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OccupyHome.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OccupyHome.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加face
 */
OccupyHome.openAddOccupyHome = function () {
    var index = layer.open({
        type: 2,
        title: '添加face',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/occupyHome/occupyHome_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看face详情
 */
OccupyHome.openOccupyHomeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'face详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/occupyHome/occupyHome_update/' + OccupyHome.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除face
 */
OccupyHome.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/occupyHome/delete", function (data) {
            Feng.success("删除成功!");
            OccupyHome.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("occupyHomeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询face列表
 */
OccupyHome.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OccupyHome.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OccupyHome.initColumn();
    var table = new BSTable(OccupyHome.id, "/occupyHome/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    OccupyHome.table = table.init();
});
