package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XueyuanxinxiEntity;
import com.cl.entity.view.XueyuanxinxiView;

import com.cl.service.XueyuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学院信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@RestController
@RequestMapping("/xueyuanxinxi")
public class XueyuanxinxiController {
    @Autowired
    private XueyuanxinxiService xueyuanxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueyuanxinxiEntity xueyuanxinxi,
		HttpServletRequest request){
        EntityWrapper<XueyuanxinxiEntity> ew = new EntityWrapper<XueyuanxinxiEntity>();

		PageUtils page = xueyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueyuanxinxiEntity xueyuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<XueyuanxinxiEntity> ew = new EntityWrapper<XueyuanxinxiEntity>();

		PageUtils page = xueyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueyuanxinxiEntity xueyuanxinxi){
       	EntityWrapper<XueyuanxinxiEntity> ew = new EntityWrapper<XueyuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueyuanxinxi, "xueyuanxinxi")); 
        return R.ok().put("data", xueyuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueyuanxinxiEntity xueyuanxinxi){
        EntityWrapper< XueyuanxinxiEntity> ew = new EntityWrapper< XueyuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueyuanxinxi, "xueyuanxinxi")); 
		XueyuanxinxiView xueyuanxinxiView =  xueyuanxinxiService.selectView(ew);
		return R.ok("查询学院信息成功").put("data", xueyuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueyuanxinxiEntity xueyuanxinxi = xueyuanxinxiService.selectById(id);
		xueyuanxinxi = xueyuanxinxiService.selectView(new EntityWrapper<XueyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", xueyuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueyuanxinxiEntity xueyuanxinxi = xueyuanxinxiService.selectById(id);
		xueyuanxinxi = xueyuanxinxiService.selectView(new EntityWrapper<XueyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", xueyuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueyuanxinxiEntity xueyuanxinxi, HttpServletRequest request){
    	xueyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyuanxinxi);
        xueyuanxinxiService.insert(xueyuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueyuanxinxiEntity xueyuanxinxi, HttpServletRequest request){
    	xueyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyuanxinxi);
        xueyuanxinxiService.insert(xueyuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueyuanxinxiEntity xueyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueyuanxinxi);
        xueyuanxinxiService.updateById(xueyuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueyuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
