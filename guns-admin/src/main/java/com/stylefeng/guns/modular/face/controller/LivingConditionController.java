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
import com.stylefeng.guns.modular.system.model.LivingCondition;
import com.stylefeng.guns.modular.face.service.ILivingConditionService;

/**
 * 生活居住状况及社会关系控制器
 *
 * @author fengshuonan
 * @Date 2019-04-29 16:56:30
 */
@Controller
@RequestMapping("/livingCondition")
public class LivingConditionController extends BaseController {

    private String PREFIX = "/face/livingCondition/";

    @Autowired
    private ILivingConditionService livingConditionService;

    /**
     * 跳转到生活居住状况及社会关系首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "livingCondition.html";
    }

    /**
     * 跳转到添加生活居住状况及社会关系
     */
    @RequestMapping("/livingCondition_add")
    public String livingConditionAdd() {
        return PREFIX + "livingCondition_add.html";
    }

    /**
     * 跳转到修改生活居住状况及社会关系
     */
    @RequestMapping("/livingCondition_update/{livingConditionId}")
    public String livingConditionUpdate(@PathVariable Integer livingConditionId, Model model) {
        LivingCondition livingCondition = livingConditionService.selectById(livingConditionId);
        model.addAttribute("item",livingCondition);
        LogObjectHolder.me().set(livingCondition);
        return PREFIX + "livingCondition_edit.html";
    }

    /**
     * 获取生活居住状况及社会关系列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<LivingCondition> page = new PageFactory<LivingCondition>().defaultPage();
        BaseEntityWrapper<LivingCondition> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<LivingCondition> result = livingConditionService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增生活居住状况及社会关系
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(LivingCondition livingCondition) {
        livingConditionService.insert(livingCondition);
        return SUCCESS_TIP;
    }

    /**
     * 删除生活居住状况及社会关系
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer livingConditionId) {
        livingConditionService.deleteById(livingConditionId);
        return SUCCESS_TIP;
    }

    /**
     * 修改生活居住状况及社会关系
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(LivingCondition livingCondition) {
        livingConditionService.updateById(livingCondition);
        return SUCCESS_TIP;
    }

    /**
     * 生活居住状况及社会关系详情
     */
    @RequestMapping(value = "/detail/{livingConditionId}")
    @ResponseBody
    public Object detail(@PathVariable("livingConditionId") Integer livingConditionId) {
        return livingConditionService.selectById(livingConditionId);
    }
}
