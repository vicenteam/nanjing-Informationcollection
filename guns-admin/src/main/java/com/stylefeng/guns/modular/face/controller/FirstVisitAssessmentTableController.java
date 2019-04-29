package com.stylefeng.guns.modular.face.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.common.BaseEntityWrapper.BaseEntityWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.FirstVisitAssessmentTable;
import com.stylefeng.guns.modular.face.service.IFirstVisitAssessmentTableService;

/**
 * 基础信息控制器
 *
 * @author fengshuonan
 * @Date 2019-04-29 15:22:49
 */
@Controller
@RequestMapping("/firstVisitAssessmentTable")
public class FirstVisitAssessmentTableController extends BaseController {

    private String PREFIX = "/face/firstVisitAssessmentTable/";

    @Autowired
    private IFirstVisitAssessmentTableService firstVisitAssessmentTableService;

    /**
     * 跳转到基础信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "firstVisitAssessmentTable.html";
    }

    /**
     * 跳转到添加基础信息
     */
    @RequestMapping("/firstVisitAssessmentTable_add")
    public String firstVisitAssessmentTableAdd() {
        return PREFIX + "firstVisitAssessmentTable_add.html";
    }

    /**
     * 跳转到修改基础信息
     */
    @RequestMapping("/firstVisitAssessmentTable_update/{firstVisitAssessmentTableId}")
    public String firstVisitAssessmentTableUpdate(@PathVariable Integer firstVisitAssessmentTableId, Model model) {
        FirstVisitAssessmentTable firstVisitAssessmentTable = firstVisitAssessmentTableService.selectById(firstVisitAssessmentTableId);
        model.addAttribute("item",firstVisitAssessmentTable);
        LogObjectHolder.me().set(firstVisitAssessmentTable);
        return PREFIX + "firstVisitAssessmentTable_edit.html";
    }

    /**
     * 获取基础信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<FirstVisitAssessmentTable> page = new PageFactory<FirstVisitAssessmentTable>().defaultPage();
        BaseEntityWrapper<FirstVisitAssessmentTable> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<FirstVisitAssessmentTable> result = firstVisitAssessmentTableService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增基础信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(FirstVisitAssessmentTable firstVisitAssessmentTable) {
        firstVisitAssessmentTableService.insert(firstVisitAssessmentTable);
        return SUCCESS_TIP;
    }

    /**
     * 删除基础信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer firstVisitAssessmentTableId) {
        firstVisitAssessmentTableService.deleteById(firstVisitAssessmentTableId);
        return SUCCESS_TIP;
    }

    /**
     * 修改基础信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(FirstVisitAssessmentTable firstVisitAssessmentTable) {
        firstVisitAssessmentTableService.updateById(firstVisitAssessmentTable);
        return SUCCESS_TIP;
    }

    /**
     * 基础信息详情
     */
    @RequestMapping(value = "/detail/{firstVisitAssessmentTableId}")
    @ResponseBody
    public Object detail(@PathVariable("firstVisitAssessmentTableId") Integer firstVisitAssessmentTableId) {
        return firstVisitAssessmentTableService.selectById(firstVisitAssessmentTableId);
    }
}
