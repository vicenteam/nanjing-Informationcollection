/**
 * 采集人基础信息管理初始化
 */
var InformationPersonal = {
    id: "InformationPersonalTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
InformationPersonal.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '姓名', field: 'fullName', visible: true, align: 'center', valign: 'middle'},
        {title: '性别', field: 'sex', visible: true, align: 'center', valign: 'middle'},
        // {title: '民族', field: 'minZu', visible: true, align: 'center', valign: 'middle'},
        {title: '年龄', field: 'age', visible: true, align: 'center', valign: 'middle'},
        {title: '出生日期', field: 'birthDate', visible: true, align: 'center', valign: 'middle'},
        {title: '身份证号', field: 'cardId', visible: true, align: 'center', valign: 'middle'},
        {title: '手机号', field: 'telephone', visible: true, align: 'center', valign: 'middle'},
        {
            title: '基本详情',
            field: 'id',
            visible: true,
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return '<a onclick="InformationPersonal.info('+value+')"> 查看</a>';
            }
        },{
            title: '首次走访信息',
            field: 'id',
            visible: true,
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return '<a onclick="InformationPersonal.one('+value+')"> 查看</a>';
            }
        },{
            title: '第二次走访能力评估表',
            field: 'id',
            visible: true,
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return '<a onclick="InformationPersonal.two('+value+')"> 查看</a>';
            }
        }
        // {title: '手机号', field: 'telephone', visible: true, align: 'center', valign: 'middle'},
        // {title: '座机', field: 'telHome', visible: true, align: 'center', valign: 'middle'},
        // {title: '用户类型(1.政府援助用户,2.商业用户)', field: 'userType', visible: true, align: 'center', valign: 'middle'},
        // {title: '生活区域(1.城市,2.农村)', field: 'areaType', visible: true, align: 'center', valign: 'middle'},
        // {title: '', field: 'address', visible: true, align: 'center', valign: 'middle'},
        // {title: '现居住地址', field: 'nowAddress', visible: true, align: 'center', valign: 'middle'},
        // {title: '婚姻状况(1.未婚，2.已婚，3.离异，4.丧偶)', field: 'maritalStatus', visible: true, align: 'center', valign: 'middle'},
        // {title: '经济来源（1.养老金，2.子女供养，3.救济优抚，4.兼职，5.其他）', field: 'economics', visible: true, align: 'center', valign: 'middle'},
        // {title: '证号', field: 'certificateNum', visible: true, align: 'center', valign: 'middle'},
        // {title: '证号类型（1.低保，2.优抚，3.失独，4.其他）', field: 'certificateNumType', visible: true, align: 'center', valign: 'middle'},
        // {title: '退休前职位', field: 'oldPosition', visible: true, align: 'center', valign: 'middle'},
        // {title: '爱好', field: 'hobby', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
InformationPersonal.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        InformationPersonal.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加采集人基础信息
 */
InformationPersonal.openAddInformationPersonal = function () {
    var index = layer.open({
        type: 2,
        title: '添加采集人基础信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/informationPersonal/informationPersonal_add'
    });
    this.layerIndex = index;
};
InformationPersonal.info = function (val) {
    var index = layer.open({
        type: 2,
        title: '基础信息',
        area: ['900px', '520px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/informationPersonal/info/'+val
    });
    this.layerIndex = index;
};
InformationPersonal.one = function (val) {
    var index = layer.open({
        type: 2,
        title: '首次走访信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/informationPersonal/one/'+val
    });
    this.layerIndex = index;
};
InformationPersonal.two = function (val) {
    var index = layer.open({
        type: 2,
        title: '第二次走访能力评估表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/informationPersonal/two/'+val
    });
    this.layerIndex = index;
};
/**
 * 打开查看采集人基础信息详情
 */
InformationPersonal.openInformationPersonalDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '采集人基础信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/informationPersonal/informationPersonal_update/' + InformationPersonal.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除采集人基础信息
 */
InformationPersonal.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/informationPersonal/delete", function (data) {
            Feng.success("删除成功!");
            InformationPersonal.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("informationPersonalId", this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询采集人基础信息列表
 */
InformationPersonal.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    InformationPersonal.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = InformationPersonal.initColumn();
    var table = new BSTable(InformationPersonal.id, "/informationPersonal/list", defaultColunms);
    //table.setPaginationType("client");
    table.setPaginationType("server");
    InformationPersonal.table = table.init();
});
