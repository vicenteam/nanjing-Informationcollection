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
import com.stylefeng.guns.modular.system.model.InformationHealth;
import com.stylefeng.guns.modular.face.service.IInformationHealthService;

/**
 * 采集人健康信息表控制器
 *
 * @author fengshuonan
 * @Date 2019-04-29 17:21:31
 */
@Controller
@RequestMapping("/informationHealth")
public class InformationHealthController extends BaseController {

    private String PREFIX = "/face/informationHealth/";

    @Autowired
    private IInformationHealthService informationHealthService;

    /**
     * 跳转到采集人健康信息表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "informationHealth.html";
    }

    /**
     * 跳转到添加采集人健康信息表
     */
    @RequestMapping("/informationHealth_add")
    public String informationHealthAdd() {
        return PREFIX + "informationHealth_add.html";
    }

    /**
     * 跳转到修改采集人健康信息表
     */
    @RequestMapping("/informationHealth_update/{informationHealthId}")
    public String informationHealthUpdate(@PathVariable Integer informationHealthId, Model model) {
        InformationHealth informationHealth = informationHealthService.selectById(informationHealthId);
        model.addAttribute("item",informationHealth);
        LogObjectHolder.me().set(informationHealth);
        return PREFIX + "informationHealth_edit.html";
    }

    /**
     * 获取采集人健康信息表列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<InformationHealth> page = new PageFactory<InformationHealth>().defaultPage();
        BaseEntityWrapper<InformationHealth> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<InformationHealth> result = informationHealthService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增采集人健康信息表
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(InformationHealth informationHealth) {
        informationHealthService.insert(informationHealth);
        return SUCCESS_TIP;
    }

    /**
     * 删除采集人健康信息表
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer informationHealthId) {
        informationHealthService.deleteById(informationHealthId);
        return SUCCESS_TIP;
    }

    /**
     * 修改采集人健康信息表
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(InformationHealth informationHealth) {
        informationHealthService.updateById(informationHealth);
        return SUCCESS_TIP;
    }

    /**
     * 采集人健康信息表详情
     */
    @RequestMapping(value = "/detail/{informationHealthId}")
    @ResponseBody
    public Object detail(@PathVariable("informationHealthId") Integer informationHealthId) {
        return informationHealthService.selectById(informationHealthId);
    }
}
