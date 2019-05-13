package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.face.service.IIdentiflMediaResouceService;
import com.stylefeng.guns.modular.face.service.IOccupyHomeService;
import com.stylefeng.guns.modular.system.model.IdentiflMediaResouce;
import com.stylefeng.guns.modular.system.model.OccupyHome;
import com.stylefeng.guns.modular.system.model.SecondVisitAssessmentTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/api/apiidentiflmediaresoucecontroller")
@Api(value="媒体信息controller",tags={"媒体信息接口"})
public class ApiIdentiflMediaResouceController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiIdentiflMediaResouceController.class);
    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
   private IIdentiflMediaResouceService identiflMediaResouceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增媒体信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "tableid", value = "所属表单Id=第一次（第二次）评估信息保存后返回的id", paramType = "query"),
            @ApiImplicitParam(required = true, name = "vmediaurl", value = "视频图片地址（ ,  逗号隔开）", paramType = "query"),
            @ApiImplicitParam(required = true, name = "smediaurl", value = "音频媒体资源", paramType = "query"),
            @ApiImplicitParam(required = true, name = "imgurl", value = "签名图片名称", paramType = "query"),
            @ApiImplicitParam(required = true, name = "createtime", value = "创建时间", paramType = "query"),
            @ApiImplicitParam(required = true, name = "status", value = "资源来源状态 0第一次走访评估信息 1第二次走评估访信息", paramType = "query"),
    })
    public ResponseData<IdentiflMediaResouce> add(IdentiflMediaResouce identiflMediaResouce, int parentId) {
        if(identiflMediaResouce.getId()!=null&&identiflMediaResouce.getId()==-1)identiflMediaResouce.setId(null);
        ResponseData<IdentiflMediaResouce> informationPersonalResponseData = new ResponseData<>();
//        identiflMediaResouce.setTableid(parentId);
        identiflMediaResouceService.insert(identiflMediaResouce);
        informationPersonalResponseData.setDataCollection(identiflMediaResouce);
        return informationPersonalResponseData;
    }



    @RequestMapping("/uploadObject")
    @ApiOperation(value = "上传媒体文件", httpMethod = "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(required = true, name = "file", value = "文件", paramType = "query"),
//    })
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public ResponseData<String> uploadObject(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        ResponseData<String> responseData = new ResponseData<>();
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(file.getOriginalFilename());
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            file.transferTo(new File(fileSavePath + pictureName));
            responseData.setResultMessage(pictureName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        responseData.setDataCollection("");
        return responseData;
    }
}
