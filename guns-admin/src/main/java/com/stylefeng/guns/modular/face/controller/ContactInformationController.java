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
import com.stylefeng.guns.modular.system.model.ContactInformation;
import com.stylefeng.guns.modular.face.service.IContactInformationService;

/**
 * 紧急联系人控制器
 *
 * @author fengshuonan
 * @Date 2019-04-30 13:21:18
 */
@Controller
@RequestMapping("/contactInformation")
public class ContactInformationController extends BaseController {

    private String PREFIX = "/face/contactInformation/";

    @Autowired
    private IContactInformationService contactInformationService;

    /**
     * 跳转到紧急联系人首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "contactInformation.html";
    }

    /**
     * 跳转到添加紧急联系人
     */
    @RequestMapping("/contactInformation_add")
    public String contactInformationAdd() {
        return PREFIX + "contactInformation_add.html";
    }

    /**
     * 跳转到修改紧急联系人
     */
    @RequestMapping("/contactInformation_update/{contactInformationId}")
    public String contactInformationUpdate(@PathVariable Integer contactInformationId, Model model) {
        ContactInformation contactInformation = contactInformationService.selectById(contactInformationId);
        model.addAttribute("item",contactInformation);
        LogObjectHolder.me().set(contactInformation);
        return PREFIX + "contactInformation_edit.html";
    }

    /**
     * 获取紧急联系人列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<ContactInformation> page = new PageFactory<ContactInformation>().defaultPage();
        BaseEntityWrapper<ContactInformation> baseEntityWrapper = new BaseEntityWrapper<>();
        Page<ContactInformation> result = contactInformationService.selectPage(page, baseEntityWrapper);
        return super.packForBT(result);
    }

    /**
     * 新增紧急联系人
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ContactInformation contactInformation) {
        contactInformationService.insert(contactInformation);
        return SUCCESS_TIP;
    }

    /**
     * 删除紧急联系人
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer contactInformationId) {
        contactInformationService.deleteById(contactInformationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改紧急联系人
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ContactInformation contactInformation) {
        contactInformationService.updateById(contactInformation);
        return SUCCESS_TIP;
    }

    /**
     * 紧急联系人详情
     */
    @RequestMapping(value = "/detail/{contactInformationId}")
    @ResponseBody
    public Object detail(@PathVariable("contactInformationId") Integer contactInformationId) {
        return contactInformationService.selectById(contactInformationId);
    }
}
