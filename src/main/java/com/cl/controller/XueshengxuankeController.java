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

import com.cl.entity.XueshengxuankeEntity;
import com.cl.entity.view.XueshengxuankeView;

import com.cl.service.XueshengxuankeService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生选课
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@RestController
@RequestMapping("/xueshengxuanke")
public class XueshengxuankeController {
    @Autowired
    private XueshengxuankeService xueshengxuankeService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengxuankeEntity xueshengxuanke,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			xueshengxuanke.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			xueshengxuanke.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengxuankeEntity> ew = new EntityWrapper<XueshengxuankeEntity>();

		PageUtils page = xueshengxuankeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengxuanke), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengxuankeEntity xueshengxuanke, 
		HttpServletRequest request){
        EntityWrapper<XueshengxuankeEntity> ew = new EntityWrapper<XueshengxuankeEntity>();

		PageUtils page = xueshengxuankeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengxuanke), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengxuankeEntity xueshengxuanke){
       	EntityWrapper<XueshengxuankeEntity> ew = new EntityWrapper<XueshengxuankeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengxuanke, "xueshengxuanke")); 
        return R.ok().put("data", xueshengxuankeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengxuankeEntity xueshengxuanke){
        EntityWrapper< XueshengxuankeEntity> ew = new EntityWrapper< XueshengxuankeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengxuanke, "xueshengxuanke")); 
		XueshengxuankeView xueshengxuankeView =  xueshengxuankeService.selectView(ew);
		return R.ok("查询学生选课成功").put("data", xueshengxuankeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengxuankeEntity xueshengxuanke = xueshengxuankeService.selectById(id);
		xueshengxuanke = xueshengxuankeService.selectView(new EntityWrapper<XueshengxuankeEntity>().eq("id", id));
        return R.ok().put("data", xueshengxuanke);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengxuankeEntity xueshengxuanke = xueshengxuankeService.selectById(id);
		xueshengxuanke = xueshengxuankeService.selectView(new EntityWrapper<XueshengxuankeEntity>().eq("id", id));
        return R.ok().put("data", xueshengxuanke);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengxuankeEntity xueshengxuanke, HttpServletRequest request){
    	xueshengxuanke.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengxuanke);
        xueshengxuankeService.insert(xueshengxuanke);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengxuankeEntity xueshengxuanke, HttpServletRequest request){
    	xueshengxuanke.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengxuanke);
        xueshengxuankeService.insert(xueshengxuanke);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengxuankeEntity xueshengxuanke, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengxuanke);
        xueshengxuankeService.updateById(xueshengxuanke);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengxuankeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
