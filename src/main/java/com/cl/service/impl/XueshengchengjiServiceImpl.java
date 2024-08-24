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


import com.cl.dao.XueshengchengjiDao;
import com.cl.entity.XueshengchengjiEntity;
import com.cl.service.XueshengchengjiService;
import com.cl.entity.view.XueshengchengjiView;

@Service("xueshengchengjiService")
public class XueshengchengjiServiceImpl extends ServiceImpl<XueshengchengjiDao, XueshengchengjiEntity> implements XueshengchengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengchengjiEntity> page = this.selectPage(
                new Query<XueshengchengjiEntity>(params).getPage(),
                new EntityWrapper<XueshengchengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengchengjiEntity> wrapper) {
		  Page<XueshengchengjiView> page =new Query<XueshengchengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueshengchengjiView> selectListView(Wrapper<XueshengchengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengchengjiView selectView(Wrapper<XueshengchengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
