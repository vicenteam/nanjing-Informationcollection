/**
 * 首次走访信息管理初始化
 */
var FirstVisitAssessmentTable = {
    id: "FirstVisitAssessmentTableTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
FirstVisitAssessmentTable.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '所在社区1', field: 'firstvisitCommunity1', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'firstvisitCommunity2', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'firstvisitCommunity3', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'firstvisitName', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'firstvisitSex', visible: true, align: 'center', valign: 'middle'},
            {title: '文化程度', field: 'firstvisitLevelEducation', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号码', field: 'firstvisitIdcard', visible: true, align: 'center', valign: 'middle'},
            {title: '社会保障卡号', field: 'firstvisitOthercard', visible: true, align: 'center', valign: 'middle'},
            {title: '联系电话', field: 'firstvisitPhone', visible: true, align: 'center', valign: 'middle'},
            {title: '居住地址', field: 'firstvisitResidentialAddress', visible: true, align: 'center', valign: 'middle'},
            {title: '常住时间( 0 :1年以下 1: 1-3年  2 :3年以上)', field: 'firstvisitResidentialTime', visible: true, align: 'center', valign: 'middle'},
            {title: '紧急联系人(,号隔开 共计4次)', field: 'firstvisitEmergencyContact', visible: true, align: 'center', valign: 'middle'},
            {title: '原职业(0公务员 1军人 2事业职工 3企业职工 4农民 5其它职业 6无职业)', field: 'firstvisitProfessional', visible: true, align: 'center', valign: 'middle'},
            {title: '人员类别(0离休 1退休 2低保户 3低保边缘户 4城市三无 5农村五保 6供养人员 7其他)', field: 'firstvisitCategory', visible: true, align: 'center', valign: 'middle'},
            {title: '经济来源(0离休金/退休金 1养老保险 2子女补贴 3亲友资助 4低保金 5供养人员补贴拆迁补助 6失地农民补助 7其他              （    元/月）)', field: 'firstvisitEconomicSources', visible: true, align: 'center', valign: 'middle'},
            {title: '婚姻状况(0未婚  1已婚  2丧偶  3离婚  4未说明的婚姻状况)', field: 'firstvisitMarital', visible: true, align: 'center', valign: 'middle'},
            {title: '子女状况(0有子女 1无子女)', field: 'firstvisitChildren', visible: true, align: 'center', valign: 'middle'},
            {title: '医疗类别(0公费 1职工医保 2居民医保 3新农合 4自费)', field: 'firstvisitMedicalCategory', visible: true, align: 'center', valign: 'middle'},
            {title: '居住状况(0独居 1空巢（与配偶/伴侣居住） 2与子女居住 3与其他亲属（含父母、兄弟姐妹等）居住 4与非亲属关系的居住 5养老机构)', field: 'firstvisitLiving', visible: true, align: 'center', valign: 'middle'},
            {title: '是否自有房屋：0是1否', field: 'firstvisitLivingHouse', visible: true, align: 'center', valign: 'middle'},
            {title: '楼层电梯：0有1无', field: 'firstvisitLivingElevator', visible: true, align: 'center', valign: 'middle'},
            {title: '居住楼层(无电梯的)：0一层 1二层 2三层以上；', field: 'firstvisitLivingLayer', visible: true, align: 'center', valign: 'middle'},
            {title: '室内厕所：0有1无；', field: 'firstvisitLivingToilet', visible: true, align: 'center', valign: 'middle'},
            {title: '室内洗浴设备：0有1无', field: 'firstvisitLivingBathingFacilities', visible: true, align: 'center', valign: 'middle'},
            {title: '原照料情况 0自我照料 1配偶照顾 2子女照顾 3自购家政服务 4送餐服务 5互助门铃 6居家照料 7紧急呼叫终端 8老年人意外伤害保险 9其他', field: 'firstvisitOriginalCareSituation', visible: true, align: 'center', valign: 'middle'},
            {title: '服务需求(0家务料理  1代购物品 2康复保健  3紧急呼叫  4心理关爱  5法律援助  6文化娱乐 7助餐  8送餐  9陪聊  10陪住  11陪外出  12日托  13入住老年人福利机构; 14其他:)', field: 'firstvisitService', visible: true, align: 'center', valign: 'middle'},
            {title: '身体状况单选(0健康 1重病 2慢性病 )', field: 'firstvisitPhysicalConditionRadio', visible: true, align: 'center', valign: 'middle'},
            {title: '身体状况多选(0恶性肿瘤 1尿毒症透析 2器官移植(含手术后的抗排异治疗) 3白血病 4急性心肌梗塞 5脑中风 6急性坏死性胰腺炎 7脑外伤 8主动脉手术 9冠状动脉旁路手术 10慢性肾功能性衰竭 11急慢性重症肝炎 12危及生命的良性脑瘤 13重症糖尿病 14消化道出血 15系统性红斑狼疮 16慢性再生障碍性贫血 17血友病 18重病精神病  19高血压 20冠心病 21前列腺增生 22糖尿病 23其他   )', field: 'firstvisitPhysicalConditionCheckbox', visible: true, align: 'center', valign: 'middle'},
            {title: '心理状况(0正常  1偶有孤独感  2经常觉得很孤独)', field: 'firstvisitPsychological', visible: true, align: 'center', valign: 'middle'},
            {title: '社会活动(0 经常 1偶尔 2从不)', field: 'firstvisitSocialActivities', visible: true, align: 'center', valign: 'middle'},
            {title: '社会活动类型：0文娱类 1教育类 2健身类 3慈善类 4经济类 5宗教类 6其他', field: 'firstvisitSocialActivitiesType', visible: true, align: 'center', valign: 'middle'},
            {title: '经济来源其他对应文本', field: 'firstvisitEconomicSourcesOtherText', visible: true, align: 'center', valign: 'middle'},
            {title: '身体状况其他对应文本', field: 'firstvisitPhysicalConditionCheckboxOtherText', visible: true, align: 'center', valign: 'middle'},
            {title: 'identifytop_id', field: 'faceIdentifyTopId', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
FirstVisitAssessmentTable.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        FirstVisitAssessmentTable.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加首次走访信息
 */
FirstVisitAssessmentTable.openAddFirstVisitAssessmentTable = function () {
    var index = layer.open({
        type: 2,
        title: '添加首次走访信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/firstVisitAssessmentTable/firstVisitAssessmentTable_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看首次走访信息详情
 */
FirstVisitAssessmentTable.openFirstVisitAssessmentTableDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '首次走访信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/firstVisitAssessmentTable/firstVisitAssessmentTable_update/' + FirstVisitAssessmentTable.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除首次走访信息
 */
FirstVisitAssessmentTable.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/firstVisitAssessmentTable/delete", function (data) {
            Feng.success("删除成功!");
            FirstVisitAssessmentTable.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("firstVisitAssessmentTableId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询首次走访信息列表
 */
FirstVisitAssessmentTable.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    FirstVisitAssessmentTable.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = FirstVisitAssessmentTable.initColumn();
    var table = new BSTable(FirstVisitAssessmentTable.id, "/firstVisitAssessmentTable/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    FirstVisitAssessmentTable.table = table.init();
});
