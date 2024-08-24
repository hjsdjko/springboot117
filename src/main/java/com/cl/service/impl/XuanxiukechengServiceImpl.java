package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XuanxiukechengDao;
import com.cl.entity.XuanxiukechengEntity;
import com.cl.service.XuanxiukechengService;
import com.cl.entity.view.XuanxiukechengView;

@Service("xuanxiukechengService")
public class XuanxiukechengServiceImpl extends ServiceImpl<XuanxiukechengDao, XuanxiukechengEntity> implements XuanxiukechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuanxiukechengEntity> page = this.selectPage(
                new Query<XuanxiukechengEntity>(params).getPage(),
                new EntityWrapper<XuanxiukechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuanxiukechengEntity> wrapper) {
		  Page<XuanxiukechengView> page =new Query<XuanxiukechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XuanxiukechengView> selectListView(Wrapper<XuanxiukechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuanxiukechengView selectView(Wrapper<XuanxiukechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
