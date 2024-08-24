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

import com.cl.entity.XuanxiukechengEntity;
import com.cl.entity.view.XuanxiukechengView;

import com.cl.service.XuanxiukechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 选修课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@RestController
@RequestMapping("/xuanxiukecheng")
public class XuanxiukechengController {
    @Autowired
    private XuanxiukechengService xuanxiukechengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuanxiukechengEntity xuanxiukecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			xuanxiukecheng.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuanxiukechengEntity> ew = new EntityWrapper<XuanxiukechengEntity>();

		PageUtils page = xuanxiukechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuanxiukecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuanxiukechengEntity xuanxiukecheng, 
		HttpServletRequest request){
        EntityWrapper<XuanxiukechengEntity> ew = new EntityWrapper<XuanxiukechengEntity>();

		PageUtils page = xuanxiukechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuanxiukecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuanxiukechengEntity xuanxiukecheng){
       	EntityWrapper<XuanxiukechengEntity> ew = new EntityWrapper<XuanxiukechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuanxiukecheng, "xuanxiukecheng")); 
        return R.ok().put("data", xuanxiukechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuanxiukechengEntity xuanxiukecheng){
        EntityWrapper< XuanxiukechengEntity> ew = new EntityWrapper< XuanxiukechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuanxiukecheng, "xuanxiukecheng")); 
		XuanxiukechengView xuanxiukechengView =  xuanxiukechengService.selectView(ew);
		return R.ok("查询选修课程成功").put("data", xuanxiukechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuanxiukechengEntity xuanxiukecheng = xuanxiukechengService.selectById(id);
		xuanxiukecheng = xuanxiukechengService.selectView(new EntityWrapper<XuanxiukechengEntity>().eq("id", id));
        return R.ok().put("data", xuanxiukecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuanxiukechengEntity xuanxiukecheng = xuanxiukechengService.selectById(id);
		xuanxiukecheng = xuanxiukechengService.selectView(new EntityWrapper<XuanxiukechengEntity>().eq("id", id));
        return R.ok().put("data", xuanxiukecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuanxiukechengEntity xuanxiukecheng, HttpServletRequest request){
    	xuanxiukecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuanxiukecheng);
        xuanxiukechengService.insert(xuanxiukecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuanxiukechengEntity xuanxiukecheng, HttpServletRequest request){
    	xuanxiukecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuanxiukecheng);
        xuanxiukechengService.insert(xuanxiukecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuanxiukechengEntity xuanxiukecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuanxiukecheng);
        xuanxiukechengService.updateById(xuanxiukecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuanxiukechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
