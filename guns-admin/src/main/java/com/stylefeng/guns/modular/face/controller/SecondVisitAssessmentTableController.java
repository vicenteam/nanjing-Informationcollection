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
import com.stylefeng.guns.modular.system.model.SecondVisitAssessmentTable;
import com.stylefeng.guns.modular.face.service.ISecondVisitAssessmentTableService;

/**
 * 第二次走访数据采集控制器
 *
 * @author fengshuonan
 * @Date 2019-04-30 14:47:56
 */
@Controller
@RequestMapping("/secondVisitAssessmentTable")
public class SecondVisitAssessmentTableController extends BaseController {

    private String PREFIX = "/face/secondVisitAssessmentTable/";

    @Autowired
    private ISecondVisitAssessmentTableService secondVisitAssessmentTableService;

    /**
     * 跳转到第二次走访数据采集首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "secondVisitAssessmentTable.html";
    }

    /**
     * 跳转到添加第二次走访数据采集
     */
    @RequestMapping("/secondVisitAssessmentTable_add")
    public String secondVisitAssessmentTableAdd() {
        return PREFIX + "secondVisitAssessmentTable_add.html";
    }

    /**
     * 跳转到修改第二次走访数据采集
     */
    @RequestMapping("/secondVisitAssessmentTable_update/{secondVisitAssessmentTableId}")
    public String secondVisitAssessmentTableUpdate(@PathVariable Integer secondVisitAssessmentTableId, Model model) {
        SecondVisitAssessmentTable secondVisitAssessmentTable = secondVisitAssessmentTableService.selectById(secondVisitAssessmentTableId);
        model.addAttribute("item",secondVisitAssessmentTable);
        LogObjectHolder.me().set(secondVisitAssessmentTable);
        return PREFIX + "secondVisitAssessmentTable_edit.html";
    }

    /**
     * 获取第二次走访数据采集列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<SecondVisitAssessmentTable> page = new PageFactory<SecondVisitAssessmentTable>().defaultPage();
        BaseEntityWrapper<SecondVisitAssessmentTable> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<SecondVisitAssessmentTable> result = secondVisitAssessmentTableService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增第二次走访数据采集
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SecondVisitAssessmentTable secondVisitAssessmentTable) {
        secondVisitAssessmentTableService.insert(secondVisitAssessmentTable);
        return SUCCESS_TIP;
    }

    /**
     * 删除第二次走访数据采集
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer secondVisitAssessmentTableId) {
        secondVisitAssessmentTableService.deleteById(secondVisitAssessmentTableId);
        return SUCCESS_TIP;
    }

    /**
     * 修改第二次走访数据采集
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SecondVisitAssessmentTable secondVisitAssessmentTable) {
        secondVisitAssessmentTableService.updateById(secondVisitAssessmentTable);
        return SUCCESS_TIP;
    }

    /**
     * 第二次走访数据采集详情
     */
    @RequestMapping(value = "/detail/{secondVisitAssessmentTableId}")
    @ResponseBody
    public Object detail(@PathVariable("secondVisitAssessmentTableId") Integer secondVisitAssessmentTableId) {
        return secondVisitAssessmentTableService.selectById(secondVisitAssessmentTableId);
    }
}
