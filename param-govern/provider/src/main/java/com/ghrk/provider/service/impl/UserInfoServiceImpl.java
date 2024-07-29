package com.ghrk.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghrk.common.entity.UserInfoEntity;
import com.ghrk.common.service.UserInfoService;
import com.ghrk.common.utils.PageUtils;
import com.ghrk.common.utils.Query;
import com.ghrk.provider.dao.UserInfoDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@DubboService
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        LambdaQueryWrapper<UserInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.likeRight(params.get("userId") != null, UserInfoEntity::getUserId, params.get("userId"));
        IPage<UserInfoEntity> page = this.page(
                new Query<UserInfoEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}