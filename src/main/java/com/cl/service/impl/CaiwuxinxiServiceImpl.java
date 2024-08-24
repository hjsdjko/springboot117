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


import com.cl.dao.CaiwuxinxiDao;
import com.cl.entity.CaiwuxinxiEntity;
import com.cl.service.CaiwuxinxiService;
import com.cl.entity.view.CaiwuxinxiView;

@Service("caiwuxinxiService")
public class CaiwuxinxiServiceImpl extends ServiceImpl<CaiwuxinxiDao, CaiwuxinxiEntity> implements CaiwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaiwuxinxiEntity> page = this.selectPage(
                new Query<CaiwuxinxiEntity>(params).getPage(),
                new EntityWrapper<CaiwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaiwuxinxiEntity> wrapper) {
		  Page<CaiwuxinxiView> page =new Query<CaiwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CaiwuxinxiView> selectListView(Wrapper<CaiwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaiwuxinxiView selectView(Wrapper<CaiwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
