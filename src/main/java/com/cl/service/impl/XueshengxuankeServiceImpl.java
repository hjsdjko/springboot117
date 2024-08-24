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


import com.cl.dao.XueshengxuankeDao;
import com.cl.entity.XueshengxuankeEntity;
import com.cl.service.XueshengxuankeService;
import com.cl.entity.view.XueshengxuankeView;

@Service("xueshengxuankeService")
public class XueshengxuankeServiceImpl extends ServiceImpl<XueshengxuankeDao, XueshengxuankeEntity> implements XueshengxuankeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengxuankeEntity> page = this.selectPage(
                new Query<XueshengxuankeEntity>(params).getPage(),
                new EntityWrapper<XueshengxuankeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengxuankeEntity> wrapper) {
		  Page<XueshengxuankeView> page =new Query<XueshengxuankeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueshengxuankeView> selectListView(Wrapper<XueshengxuankeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengxuankeView selectView(Wrapper<XueshengxuankeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
