package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyuanxinxiView;


/**
 * 学院信息
 *
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface XueyuanxinxiService extends IService<XueyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyuanxinxiView> selectListView(Wrapper<XueyuanxinxiEntity> wrapper);
   	
   	XueyuanxinxiView selectView(@Param("ew") Wrapper<XueyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyuanxinxiEntity> wrapper);
   	

}

