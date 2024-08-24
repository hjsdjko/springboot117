package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CaiwuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaiwuxinxiView;


/**
 * 财务信息
 *
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface CaiwuxinxiService extends IService<CaiwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaiwuxinxiView> selectListView(Wrapper<CaiwuxinxiEntity> wrapper);
   	
   	CaiwuxinxiView selectView(@Param("ew") Wrapper<CaiwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaiwuxinxiEntity> wrapper);
   	

}

