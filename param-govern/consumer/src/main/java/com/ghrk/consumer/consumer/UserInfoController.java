package com.ghrk.consumer.controller;

import com.ghrk.common.entity.UserInfoEntity;
import com.ghrk.common.service.UserInfoService;
import com.ghrk.common.utils.PageUtils;
import com.ghrk.common.utils.R;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 用户信息
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @DubboReference
    private UserInfoService userInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        UserInfoEntity userInfo = userInfoService.getById(id);

        return R.ok().put("userInfo", userInfo);
    }

    ///**
    // * 保存
    // */
    //@RequestMapping("/save")
    //public R save(@RequestBody UserInfoEntity userInfo){
    //	userInfoService.save(userInfo);
    //
    //    return R.ok();
    //}
    //
    ///**
    // * 修改
    // */
    //@RequestMapping("/update")
    //public R update(@RequestBody UserInfoEntity userInfo){
    //	userInfoService.updateById(userInfo);
    //
    //    return R.ok();
    //}
    //
    ///**
    // * 删除
    // */
    //@RequestMapping("/delete")
    //public R delete(@RequestBody Long[] ids){
    //	userInfoService.removeByIds(Arrays.asList(ids));
    //
    //    return R.ok();
    //}

}
