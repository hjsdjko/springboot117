package com.cl.dao;

import com.cl.entity.XueshengjiangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengjiangchengView;


/**
 * 学生奖惩
 * 
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface XueshengjiangchengDao extends BaseMapper<XueshengjiangchengEntity> {
	
	List<XueshengjiangchengView> selectListView(@Param("ew") Wrapper<XueshengjiangchengEntity> wrapper);

	List<XueshengjiangchengView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengjiangchengEntity> wrapper);
	
	XueshengjiangchengView selectView(@Param("ew") Wrapper<XueshengjiangchengEntity> wrapper);
	

}
