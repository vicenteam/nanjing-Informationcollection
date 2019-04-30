/**
 * 紧急联系人管理初始化
 */
var ContactInformation = {
    id: "ContactInformationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ContactInformation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '志愿者一', field: 'contactInformationVolunteers1', visible: true, align: 'center', valign: 'middle'},
            {title: '志愿者一电话', field: 'contactInformationVolunteers1Phone', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationVolunteers2', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationVolunteers2Phone', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationVolunteers3', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationVolunteers3Phone', visible: true, align: 'center', valign: 'middle'},
            {title: '配偶紧急联系人一 姓名', field: 'contactInformationSpouseName', visible: true, align: 'center', valign: 'middle'},
            {title: '关系', field: 'contactInformationSpouseRelationship', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'contactInformationSpouseSex', visible: true, align: 'center', valign: 'middle'},
            {title: '年龄', field: 'contactInformationSpouseAge', visible: true, align: 'center', valign: 'middle'},
            {title: '名族', field: 'contactInformationSpouseEthnic', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证', field: 'contactInformationSpouseIdcard', visible: true, align: 'center', valign: 'middle'},
            {title: '户口所在地', field: 'contactInformationSpouseResidence', visible: true, align: 'center', valign: 'middle'},
            {title: '联 系 电 话', field: 'contactInformationSpousePhone', visible: true, align: 'center', valign: 'middle'},
            {title: '联 系 地 址', field: 'contactInformationSpouseAddress', visible: true, align: 'center', valign: 'middle'},
            {title: '姓  名', field: 'contactInformationContact2Name', visible: true, align: 'center', valign: 'middle'},
            {title: '关系', field: 'contactInformationContact2Relationship', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'contactInformationContact2Sex', visible: true, align: 'center', valign: 'middle'},
            {title: '联系电话', field: 'contactInformationContact2Phone1', visible: true, align: 'center', valign: 'middle'},
            {title: '备用电话', field: 'contactInformationContact2Phone2', visible: true, align: 'center', valign: 'middle'},
            {title: '联系地址', field: 'contactInformationContact2Address', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationContact3Name', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationContact3Relationship', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationContact3Sex', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationContact3Phone1', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationContact3Phone2', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'contactInformationContact3Address', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createuserid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'deptid', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ContactInformation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ContactInformation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加紧急联系人
 */
ContactInformation.openAddContactInformation = function () {
    var index = layer.open({
        type: 2,
        title: '添加紧急联系人',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/contactInformation/contactInformation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看紧急联系人详情
 */
ContactInformation.openContactInformationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '紧急联系人详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/contactInformation/contactInformation_update/' + ContactInformation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除紧急联系人
 */
ContactInformation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/contactInformation/delete", function (data) {
            Feng.success("删除成功!");
            ContactInformation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("contactInformationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询紧急联系人列表
 */
ContactInformation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ContactInformation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ContactInformation.initColumn();
    var table = new BSTable(ContactInformation.id, "/contactInformation/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    ContactInformation.table = table.init();
});
