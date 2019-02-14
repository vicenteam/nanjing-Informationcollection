package com.stylefeng.guns.modular.api.controller;

import com.stylefeng.guns.modular.api.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apifacecontroller")
public class ApiFaceController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiFaceController.class);

}
