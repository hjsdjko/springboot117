package com.cl.dao;

import com.cl.entity.XueyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyuanxinxiView;


/**
 * 学院信息
 * 
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface XueyuanxinxiDao extends BaseMapper<XueyuanxinxiEntity> {
	
	List<XueyuanxinxiView> selectListView(@Param("ew") Wrapper<XueyuanxinxiEntity> wrapper);

	List<XueyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XueyuanxinxiEntity> wrapper);
	
	XueyuanxinxiView selectView(@Param("ew") Wrapper<XueyuanxinxiEntity> wrapper);
	

}
