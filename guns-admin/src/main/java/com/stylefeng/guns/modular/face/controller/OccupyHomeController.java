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
import com.stylefeng.guns.modular.system.model.OccupyHome;
import com.stylefeng.guns.modular.face.service.IOccupyHomeService;

/**
 * 居家养老信息控制器
 *
 * @author fengshuonan
 * @Date 2019-04-29 17:48:55
 */
@Controller
@RequestMapping("/occupyHome")
public class OccupyHomeController extends BaseController {

    private String PREFIX = "/face/occupyHome/";

    @Autowired
    private IOccupyHomeService occupyHomeService;

    /**
     * 跳转到居家养老信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "occupyHome.html";
    }

    /**
     * 跳转到添加居家养老信息
     */
    @RequestMapping("/occupyHome_add")
    public String occupyHomeAdd() {
        return PREFIX + "occupyHome_add.html";
    }

    /**
     * 跳转到修改居家养老信息
     */
    @RequestMapping("/occupyHome_update/{occupyHomeId}")
    public String occupyHomeUpdate(@PathVariable Integer occupyHomeId, Model model) {
        OccupyHome occupyHome = occupyHomeService.selectById(occupyHomeId);
        model.addAttribute("item",occupyHome);
        LogObjectHolder.me().set(occupyHome);
        return PREFIX + "occupyHome_edit.html";
    }

    /**
     * 获取居家养老信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<OccupyHome> page = new PageFactory<OccupyHome>().defaultPage();
        BaseEntityWrapper<OccupyHome> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<OccupyHome> result = occupyHomeService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增居家养老信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(OccupyHome occupyHome) {
        occupyHomeService.insert(occupyHome);
        return SUCCESS_TIP;
    }

    /**
     * 删除居家养老信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer occupyHomeId) {
        occupyHomeService.deleteById(occupyHomeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改居家养老信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(OccupyHome occupyHome) {
        occupyHomeService.updateById(occupyHome);
        return SUCCESS_TIP;
    }

    /**
     * 居家养老信息详情
     */
    @RequestMapping(value = "/detail/{occupyHomeId}")
    @ResponseBody
    public Object detail(@PathVariable("occupyHomeId") Integer occupyHomeId) {
        return occupyHomeService.selectById(occupyHomeId);
    }
}
