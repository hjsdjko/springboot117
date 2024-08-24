package com.cl.dao;

import com.cl.entity.XueshengxuankeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengxuankeView;


/**
 * 学生选课
 * 
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface XueshengxuankeDao extends BaseMapper<XueshengxuankeEntity> {
	
	List<XueshengxuankeView> selectListView(@Param("ew") Wrapper<XueshengxuankeEntity> wrapper);

	List<XueshengxuankeView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengxuankeEntity> wrapper);
	
	XueshengxuankeView selectView(@Param("ew") Wrapper<XueshengxuankeEntity> wrapper);
	

}
