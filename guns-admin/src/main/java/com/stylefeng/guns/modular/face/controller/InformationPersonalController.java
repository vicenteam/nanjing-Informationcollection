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
import com.stylefeng.guns.modular.system.model.InformationPersonal;
import com.stylefeng.guns.modular.face.service.IInformationPersonalService;

/**
 * 采集人基础信息控制器
 *
 * @author fengshuonan
 * @Date 2019-04-29 15:39:23
 */
@Controller
@RequestMapping("/informationPersonal")
public class InformationPersonalController extends BaseController {

    private String PREFIX = "/face/informationPersonal/";

    @Autowired
    private IInformationPersonalService informationPersonalService;

    /**
     * 跳转到采集人基础信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "informationPersonal.html";
    }

    /**
     * 跳转到添加采集人基础信息
     */
    @RequestMapping("/informationPersonal_add")
    public String informationPersonalAdd() {
        return PREFIX + "informationPersonal_add.html";
    }





    @RequestMapping("/info/{val}")
    public String info(@PathVariable Integer val, Model model) {
        model.addAttribute("id",val);
        return "/face/info/info.html";
    }
    @RequestMapping("/one/{val}")
    public String one(@PathVariable Integer val) {

        return "/face/one/one.html";
    }
    @RequestMapping("/two/{val}")
    public String two(@PathVariable Integer val) {

        return "/face/two/two.html";
    }










    /**
     * 跳转到修改采集人基础信息
     */
    @RequestMapping("/informationPersonal_update/{informationPersonalId}")
    public String informationPersonalUpdate(@PathVariable Integer informationPersonalId, Model model) {
        InformationPersonal informationPersonal = informationPersonalService.selectById(informationPersonalId);
        model.addAttribute("item",informationPersonal);
        LogObjectHolder.me().set(informationPersonal);
        return "/face/info/info.html";
    }

    /**
     * 获取采集人基础信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<InformationPersonal> page = new PageFactory<InformationPersonal>().defaultPage();
        BaseEntityWrapper<InformationPersonal> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<InformationPersonal> result = informationPersonalService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增采集人基础信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(InformationPersonal informationPersonal) {
        informationPersonalService.insert(informationPersonal);
        return SUCCESS_TIP;
    }

    /**
     * 删除采集人基础信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer informationPersonalId) {
        informationPersonalService.deleteById(informationPersonalId);
        return SUCCESS_TIP;
    }

    /**
     * 修改采集人基础信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(InformationPersonal informationPersonal) {
        informationPersonalService.updateById(informationPersonal);
        return SUCCESS_TIP;
    }

    /**
     * 采集人基础信息详情
     */
    @RequestMapping(value = "/detail/{informationPersonalId}")
    @ResponseBody
    public Object detail(@PathVariable("informationPersonalId") Integer informationPersonalId) {
        return informationPersonalService.selectById(informationPersonalId);
    }
}
