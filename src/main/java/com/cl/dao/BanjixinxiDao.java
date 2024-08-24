package com.cl.dao;

import com.cl.entity.BanjixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanjixinxiView;


/**
 * 班级信息
 * 
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface BanjixinxiDao extends BaseMapper<BanjixinxiEntity> {
	
	List<BanjixinxiView> selectListView(@Param("ew") Wrapper<BanjixinxiEntity> wrapper);

	List<BanjixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BanjixinxiEntity> wrapper);
	
	BanjixinxiView selectView(@Param("ew") Wrapper<BanjixinxiEntity> wrapper);
	

}
