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


import com.cl.dao.XueshengjiangchengDao;
import com.cl.entity.XueshengjiangchengEntity;
import com.cl.service.XueshengjiangchengService;
import com.cl.entity.view.XueshengjiangchengView;

@Service("xueshengjiangchengService")
public class XueshengjiangchengServiceImpl extends ServiceImpl<XueshengjiangchengDao, XueshengjiangchengEntity> implements XueshengjiangchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengjiangchengEntity> page = this.selectPage(
                new Query<XueshengjiangchengEntity>(params).getPage(),
                new EntityWrapper<XueshengjiangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengjiangchengEntity> wrapper) {
		  Page<XueshengjiangchengView> page =new Query<XueshengjiangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueshengjiangchengView> selectListView(Wrapper<XueshengjiangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengjiangchengView selectView(Wrapper<XueshengjiangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
