package com.ghrk.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghrk.common.entity.CaptchaEntity;

import java.awt.image.BufferedImage;

/**
 * 验证码
 */
public interface CaptchaService extends IService<CaptchaEntity> {

    /**
     * 获取图片验证码
     */
    String getCaptcha(String uuid);

    String getUser();

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}
