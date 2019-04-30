package com.stylefeng.guns.modular.face.service.impl;

import com.stylefeng.guns.modular.system.model.ContactInformation;
import com.stylefeng.guns.modular.system.dao.ContactInformationMapper;
import com.stylefeng.guns.modular.face.service.IContactInformationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 紧急联系人基础信息表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
@Service
public class ContactInformationServiceImpl extends ServiceImpl<ContactInformationMapper, ContactInformation> implements IContactInformationService {

}
