package com.stylefeng.guns.modular.system.controller;

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
import com.stylefeng.guns.modular.system.model.FaceIdentifyTop;
import com.stylefeng.guns.modular.system.service.IFaceIdentifyTopService;

/**
 * 采集基础信息控制器
 *
 * @author fengshuonan
 * @Date 2019-02-18 10:08:46
 */
@Controller
@RequestMapping("/faceIdentifyTop")
public class FaceIdentifyTopController extends BaseController {

    private String PREFIX = "/system/faceIdentifyTop/";

    @Autowired
    private IFaceIdentifyTopService faceIdentifyTopService;

    /**
     * 跳转到采集基础信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "faceIdentifyTop.html";
    }

    /**
     * 跳转到添加采集基础信息
     */
    @RequestMapping("/faceIdentifyTop_add")
    public String faceIdentifyTopAdd() {
        return PREFIX + "faceIdentifyTop_add.html";
    }

    /**
     * 跳转到修改采集基础信息
     */
    @RequestMapping("/faceIdentifyTop_update/{faceIdentifyTopId}")
    public String faceIdentifyTopUpdate(@PathVariable Integer faceIdentifyTopId, Model model) {
        FaceIdentifyTop faceIdentifyTop = faceIdentifyTopService.selectById(faceIdentifyTopId);
        model.addAttribute("item",faceIdentifyTop);
        LogObjectHolder.me().set(faceIdentifyTop);
        return PREFIX + "faceIdentifyTop_edit.html";
    }

    /**
     * 获取采集基础信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<FaceIdentifyTop> page = new PageFactory<FaceIdentifyTop>().defaultPage();
        BaseEntityWrapper<FaceIdentifyTop> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<FaceIdentifyTop> result = faceIdentifyTopService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增采集基础信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(FaceIdentifyTop faceIdentifyTop) {
        faceIdentifyTopService.insert(faceIdentifyTop);
        return SUCCESS_TIP;
    }

    /**
     * 删除采集基础信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer faceIdentifyTopId) {
        faceIdentifyTopService.deleteById(faceIdentifyTopId);
        return SUCCESS_TIP;
    }

    /**
     * 修改采集基础信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(FaceIdentifyTop faceIdentifyTop) {
        faceIdentifyTopService.updateById(faceIdentifyTop);
        return SUCCESS_TIP;
    }

    /**
     * 采集基础信息详情
     */
    @RequestMapping(value = "/detail/{faceIdentifyTopId}")
    @ResponseBody
    public Object detail(@PathVariable("faceIdentifyTopId") Integer faceIdentifyTopId) {
        return faceIdentifyTopService.selectById(faceIdentifyTopId);
    }
}
