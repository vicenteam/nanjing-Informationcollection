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
import com.stylefeng.guns.modular.system.model.IdentiflMediaResouce;
import com.stylefeng.guns.modular.face.service.IIdentiflMediaResouceService;

/**
 * 媒体信息控制器
 *
 * @author fengshuonan
 * @Date 2019-04-30 15:07:06
 */
@Controller
@RequestMapping("/identiflMediaResouce")
public class IdentiflMediaResouceController extends BaseController {

    private String PREFIX = "/face/identiflMediaResouce/";

    @Autowired
    private IIdentiflMediaResouceService identiflMediaResouceService;

    /**
     * 跳转到媒体信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "identiflMediaResouce.html";
    }

    /**
     * 跳转到添加媒体信息
     */
    @RequestMapping("/identiflMediaResouce_add")
    public String identiflMediaResouceAdd() {
        return PREFIX + "identiflMediaResouce_add.html";
    }

    /**
     * 跳转到修改媒体信息
     */
    @RequestMapping("/identiflMediaResouce_update/{identiflMediaResouceId}")
    public String identiflMediaResouceUpdate(@PathVariable Integer identiflMediaResouceId, Model model) {
        IdentiflMediaResouce identiflMediaResouce = identiflMediaResouceService.selectById(identiflMediaResouceId);
        model.addAttribute("item",identiflMediaResouce);
        LogObjectHolder.me().set(identiflMediaResouce);
        return PREFIX + "identiflMediaResouce_edit.html";
    }

    /**
     * 获取媒体信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<IdentiflMediaResouce> page = new PageFactory<IdentiflMediaResouce>().defaultPage();
        BaseEntityWrapper<IdentiflMediaResouce> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<IdentiflMediaResouce> result = identiflMediaResouceService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增媒体信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(IdentiflMediaResouce identiflMediaResouce) {
        identiflMediaResouceService.insert(identiflMediaResouce);
        return SUCCESS_TIP;
    }

    /**
     * 删除媒体信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer identiflMediaResouceId) {
        identiflMediaResouceService.deleteById(identiflMediaResouceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改媒体信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(IdentiflMediaResouce identiflMediaResouce) {
        identiflMediaResouceService.updateById(identiflMediaResouce);
        return SUCCESS_TIP;
    }

    /**
     * 媒体信息详情
     */
    @RequestMapping(value = "/detail/{identiflMediaResouceId}")
    @ResponseBody
    public Object detail(@PathVariable("identiflMediaResouceId") Integer identiflMediaResouceId) {
        return identiflMediaResouceService.selectById(identiflMediaResouceId);
    }
}
