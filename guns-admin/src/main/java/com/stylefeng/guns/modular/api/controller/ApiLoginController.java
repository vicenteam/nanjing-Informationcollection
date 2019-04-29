package com.stylefeng.guns.modular.api.controller;

import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.modular.api.apiparam.ResponseData;
import com.stylefeng.guns.modular.api.base.BaseController;
import com.stylefeng.guns.modular.api.model.user.UserModel;
import com.stylefeng.guns.modular.api.util.ReflectionObject;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.model.Dept;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apilogincontroller")
@Api(value="登陆controller",tags={"登陆操作接口"})
public class ApiLoginController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ApiLoginController.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IDeptService deptService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "username", value = "登录名", paramType = "query"),
            @ApiImplicitParam(required = true, name = "password", value = "登录密码", paramType = "query")
    })
    public ResponseData<UserModel> login(@RequestParam("username") String username,
                                         @RequestParam("password") String password) throws Exception {
        ResponseData<UserModel> userResponseData = new ResponseData<>();
        //封装请求账号密码为shiro可验证的token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password.toCharArray());
        //获取数据库中的账号密码，准备比对
        User user = userMapper.getByAccount(username);
        if (user == null) throw new Exception("用户名不存在!");
        String credentials = user.getPassword();
        String salt = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(salt);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                new ShiroUser(), credentials, credentialsSalt, "");
        //校验用户账号密码
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        boolean passwordTrueFlag = md5CredentialsMatcher.doCredentialsMatch(
                usernamePasswordToken, simpleAuthenticationInfo);
        if (passwordTrueFlag) {
            if (user.getStatus() != 1) throw new Exception("登录失败,请联系管理员!");
            //数据库entity对象转model层对象
            UserModel change = new ReflectionObject<UserModel>().change(user, new UserModel());
            change.setUserId(change.getId());
            change.setAvatar("http://47.104.252.44:8081/kaptcha/" + change.getAvatar());//上线更改地址
            if (change.getDeptid() != null) {
                Dept dept = deptService.selectById(change.getDeptid());
                if (dept != null) change.setDeptName(dept.getFullname());
            }
            userResponseData.setDataCollection(change);
        } else {
            throw new Exception("用户名或密码错误!");
        }
        return userResponseData;
    }
}
