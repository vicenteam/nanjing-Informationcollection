/**
 * 采集人健康信息表管理初始化
 */
var InformationHealth = {
    id: "InformationHealthTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
InformationHealth.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '听力（1.良好，2.一般，3.很大声才能听见，4.听不见）', field: 'hearing', visible: true, align: 'center', valign: 'middle'},
            {title: '是否佩戴助听器（1.是，2.否）', field: 'helpHear', visible: true, align: 'center', valign: 'middle'},
            {title: '病史（1.健康   2.高血压   3.糖尿病   4.冠心病   5.恶性肿瘤   6.结核病   7.肝炎   8.脑卒中  9.精神疾病  10.慢性阻塞性肺疾病  11.慢性支气管炎  12.帕金森综合症  13.腰椎间盘突出  14.阿尔茨海默病  15.心脏病  16.肺气肿  17.白内障  18.脑血栓  19.风湿病  20.脑中风  21.高脂血症  22.哮喘  23.意外伤害  24.其他_____）', field: 'health', visible: true, align: 'center', valign: 'middle'},
            {title: '药物过敏情况', field: 'allergy', visible: true, align: 'center', valign: 'middle'},
            {title: '药物过敏史（1.是，2.否）', field: 'allergyHistory', visible: true, align: 'center', valign: 'middle'},
            {title: '过敏类型（1药物过敏  2化工金属  3植物过敏  4食物过敏  5动物过敏  6其他_____）', field: 'allergyType', visible: true, align: 'center', valign: 'middle'},
            {title: '经常服用药物', field: 'everyEatDrugs', visible: true, align: 'center', valign: 'middle'},
            {title: '血型', field: 'bloodType', visible: true, align: 'center', valign: 'middle'},
            {title: '老人自理类别（1自理  2失能  3半失能  4失智  5轻度依赖  6重度依赖  7不能自理）', field: 'ziLiType', visible: true, align: 'center', valign: 'middle'},
            {title: '绑定设备', field: 'imei', visible: true, align: 'center', valign: 'middle'},
            {title: '健康记录', field: 'healthRecord', visible: true, align: 'center', valign: 'middle'},
            {title: '体检记录', field: 'testRecord', visible: true, align: 'center', valign: 'middle'},
            {title: '过敏类型其他对应文本', field: 'allergyTypeOtherText', visible: true, align: 'center', valign: 'middle'},
            {title: '病史其他对应文本', field: 'healthOtherText', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
InformationHealth.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        InformationHealth.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加采集人健康信息表
 */
InformationHealth.openAddInformationHealth = function () {
    var index = layer.open({
        type: 2,
        title: '添加采集人健康信息表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/informationHealth/informationHealth_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看采集人健康信息表详情
 */
InformationHealth.openInformationHealthDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '采集人健康信息表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/informationHealth/informationHealth_update/' + InformationHealth.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除采集人健康信息表
 */
InformationHealth.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/informationHealth/delete", function (data) {
            Feng.success("删除成功!");
            InformationHealth.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("informationHealthId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询采集人健康信息表列表
 */
InformationHealth.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    InformationHealth.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = InformationHealth.initColumn();
    var table = new BSTable(InformationHealth.id, "/informationHealth/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    InformationHealth.table = table.init();
});
