/**
 * 第二次走访数据采集管理初始化
 */
var SecondVisitAssessmentTable = {
    id: "SecondVisitAssessmentTableTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SecondVisitAssessmentTable.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'secondvisitName', visible: true, align: 'center', valign: 'middle'},
            {title: '性别(0男 1女)', field: 'secondvisitSex', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证', field: 'secondvisitIdcard', visible: true, align: 'center', valign: 'middle'},
            {title: '年龄', field: 'secondvisitAge', visible: true, align: 'center', valign: 'middle'},
            {title: '社保卡号', field: 'secondvisitOthercard', visible: true, align: 'center', valign: 'middle'},
            {title: '名族(0汉族 1其他)', field: 'secondvisitEthnic', visible: true, align: 'center', valign: 'middle'},
            {title: '教育水平(1文盲 2小学 3初中 4高中/技校/中专 5大学专科及以上 6不详)', field: 'secondvisitLevelOfEducation', visible: true, align: 'center', valign: 'middle'},
            {title: '婚姻状况(1未婚   2 已婚   3丧偶   4离婚   5未说明的婚姻状况)', field: 'secondvisitMaritalStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '居住地址', field: 'secondvisitAddress', visible: true, align: 'center', valign: 'middle'},
            {title: '住宅电话', field: 'secondvisitHomePhone', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号码', field: 'secondvisitPhoneNumber', visible: true, align: 'center', valign: 'middle'},
            {title: '居住情况(1独自居住  2 与配偶居住  3 与子女居住  4 其他 )', field: 'secondvisitLivingSituation', visible: true, align: 'center', valign: 'middle'},
            {title: '医疗费用支付方式(1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗  4贫困救助  5商业医疗保险  6全公费  7全自费  8其他)', field: 'secondvisitMedical', visible: true, align: 'center', valign: 'middle'},
            {title: '走访对象类别(1低保  2低收入  3建档立卡贫困老人  4重点优抚对象)', field: 'secondvisitVisitObjectCategories', visible: true, align: 'center', valign: 'middle'},
            {title: '期望的养老模式(0居家养老   1社区养老   2机构养老   3其他)', field: 'secondvisitExpectationsPension', visible: true, align: 'center', valign: 'middle'},
            {title: '期望的养老服务(0家政服务 1生活照料 2健康咨询 3精神慰藉 4陪同就医 5换季服务 6助浴服务 7助残服务 8助洁服务 9助餐服务 10 助行服务 11定制服务)', field: 'secondvisitExpectationsPensionServer', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createuserid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'deptid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'faceIdentifyTopId', visible: true, align: 'center', valign: 'middle'},
            {title: '医疗支付方式其他对应文本', field: 'secondvisitMedicalOtherText', visible: true, align: 'center', valign: 'middle'},
            {title: '期望的养老模式其他选择对应文本', field: 'secondvisitExpectationsPensionOtherText', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SecondVisitAssessmentTable.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SecondVisitAssessmentTable.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加第二次走访数据采集
 */
SecondVisitAssessmentTable.openAddSecondVisitAssessmentTable = function () {
    var index = layer.open({
        type: 2,
        title: '添加第二次走访数据采集',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/secondVisitAssessmentTable/secondVisitAssessmentTable_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看第二次走访数据采集详情
 */
SecondVisitAssessmentTable.openSecondVisitAssessmentTableDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '第二次走访数据采集详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/secondVisitAssessmentTable/secondVisitAssessmentTable_update/' + SecondVisitAssessmentTable.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除第二次走访数据采集
 */
SecondVisitAssessmentTable.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/secondVisitAssessmentTable/delete", function (data) {
            Feng.success("删除成功!");
            SecondVisitAssessmentTable.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("secondVisitAssessmentTableId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询第二次走访数据采集列表
 */
SecondVisitAssessmentTable.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SecondVisitAssessmentTable.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SecondVisitAssessmentTable.initColumn();
    var table = new BSTable(SecondVisitAssessmentTable.id, "/secondVisitAssessmentTable/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    SecondVisitAssessmentTable.table = table.init();
});
