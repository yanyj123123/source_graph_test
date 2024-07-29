package com.ghrk.consumer.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ghrk.common.service.CaptchaService;
import com.ghrk.common.utils.R;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class LoginController {

    @DubboReference
    private CaptchaService captchaService;

    //@Autowired
    //private UserInfoService userInfoService;
    //
    //@Autowired
    //private UserAuthService userAuthService;
    //
    //@Autowired
    //private JwtUtil jwtUtil;

    /**
     * 验证码
     */
    @GetMapping("/captcha")
    public R captcha(String uuid) {
        String captcha = captchaService.getCaptcha(uuid);
        return R.ok().put("captcha", captcha);
    }

    @GetMapping("hello")
    public R getHello(){
        String user = captchaService.getUser();
        return R.ok().put("data", user);
    }

    /**
     * 登录接口
     * @param form 登录表单参数
     * @return R
     */
    //@PostMapping("/login")
    //public R login(@RequestBody LoginForm form){
    //    boolean captcha = captchaService.validate(form.getUuid(), form.getCaptcha());
    //    if(!captcha){
    //        return R.error("验证码不正确");
    //    }
    //
    //    //用户信息
    //    UserInfoEntity user = userInfoService.getOne(
    //            new LambdaQueryWrapper<UserInfoEntity>().eq(UserInfoEntity::getUserId, form.getUserId()));
    //
    //    //账号不存在、密码错误
    //    if(user == null || !user.getPassword().equals(form.getPassword())) {
    //        return R.error("账号或密码不正确");
    //    }
    //    //生成token
    //    String token = jwtUtil.generateToken(user.getUserId());
    //    HashMap<String, String> data = new HashMap<>();
    //    data.put(jwtUtil.getHeader(), token);
    //    return R.ok().put("data", data);
    //
    //}
}
