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
import com.stylefeng.guns.modular.system.model.InformationService;
import com.stylefeng.guns.modular.face.service.IInformationServiceService;

/**
 * 服务信息控制器
 *
 * @author fengshuonan
 * @Date 2019-04-29 16:32:57
 */
@Controller
@RequestMapping("/informationService")
public class InformationServiceController extends BaseController {

    private String PREFIX = "/face/informationService/";

    @Autowired
    private IInformationServiceService informationServiceService;

    /**
     * 跳转到服务信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "informationService.html";
    }

    /**
     * 跳转到添加服务信息
     */
    @RequestMapping("/informationService_add")
    public String informationServiceAdd() {
        return PREFIX + "informationService_add.html";
    }

    /**
     * 跳转到修改服务信息
     */
    @RequestMapping("/informationService_update/{informationServiceId}")
    public String informationServiceUpdate(@PathVariable Integer informationServiceId, Model model) {
        InformationService informationService = informationServiceService.selectById(informationServiceId);
        model.addAttribute("item",informationService);
        LogObjectHolder.me().set(informationService);
        return PREFIX + "informationService_edit.html";
    }

    /**
     * 获取服务信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<InformationService> page = new PageFactory<InformationService>().defaultPage();
        BaseEntityWrapper<InformationService> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<InformationService> result = informationServiceService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增服务信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(InformationService informationService) {
        informationServiceService.insert(informationService);
        return SUCCESS_TIP;
    }

    /**
     * 删除服务信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer informationServiceId) {
        informationServiceService.deleteById(informationServiceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改服务信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(InformationService informationService) {
        informationServiceService.updateById(informationService);
        return SUCCESS_TIP;
    }

    /**
     * 服务信息详情
     */
    @RequestMapping(value = "/detail/{informationServiceId}")
    @ResponseBody
    public Object detail(@PathVariable("informationServiceId") Integer informationServiceId) {
        return informationServiceService.selectById(informationServiceId);
    }
}
