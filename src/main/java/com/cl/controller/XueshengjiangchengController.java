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

import com.cl.entity.XueshengjiangchengEntity;
import com.cl.entity.view.XueshengjiangchengView;

import com.cl.service.XueshengjiangchengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生奖惩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@RestController
@RequestMapping("/xueshengjiangcheng")
public class XueshengjiangchengController {
    @Autowired
    private XueshengjiangchengService xueshengjiangchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengjiangchengEntity xueshengjiangcheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengjiangcheng.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengjiangchengEntity> ew = new EntityWrapper<XueshengjiangchengEntity>();

		PageUtils page = xueshengjiangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengjiangcheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengjiangchengEntity xueshengjiangcheng, 
		HttpServletRequest request){
        EntityWrapper<XueshengjiangchengEntity> ew = new EntityWrapper<XueshengjiangchengEntity>();

		PageUtils page = xueshengjiangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengjiangcheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengjiangchengEntity xueshengjiangcheng){
       	EntityWrapper<XueshengjiangchengEntity> ew = new EntityWrapper<XueshengjiangchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengjiangcheng, "xueshengjiangcheng")); 
        return R.ok().put("data", xueshengjiangchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengjiangchengEntity xueshengjiangcheng){
        EntityWrapper< XueshengjiangchengEntity> ew = new EntityWrapper< XueshengjiangchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengjiangcheng, "xueshengjiangcheng")); 
		XueshengjiangchengView xueshengjiangchengView =  xueshengjiangchengService.selectView(ew);
		return R.ok("查询学生奖惩成功").put("data", xueshengjiangchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengjiangchengEntity xueshengjiangcheng = xueshengjiangchengService.selectById(id);
		xueshengjiangcheng = xueshengjiangchengService.selectView(new EntityWrapper<XueshengjiangchengEntity>().eq("id", id));
        return R.ok().put("data", xueshengjiangcheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengjiangchengEntity xueshengjiangcheng = xueshengjiangchengService.selectById(id);
		xueshengjiangcheng = xueshengjiangchengService.selectView(new EntityWrapper<XueshengjiangchengEntity>().eq("id", id));
        return R.ok().put("data", xueshengjiangcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengjiangchengEntity xueshengjiangcheng, HttpServletRequest request){
    	xueshengjiangcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengjiangcheng);
        xueshengjiangchengService.insert(xueshengjiangcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengjiangchengEntity xueshengjiangcheng, HttpServletRequest request){
    	xueshengjiangcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengjiangcheng);
        xueshengjiangchengService.insert(xueshengjiangcheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengjiangchengEntity xueshengjiangcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengjiangcheng);
        xueshengjiangchengService.updateById(xueshengjiangcheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengjiangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
