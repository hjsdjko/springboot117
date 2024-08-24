package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BanjixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanjixinxiView;


/**
 * 班级信息
 *
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface BanjixinxiService extends IService<BanjixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BanjixinxiView> selectListView(Wrapper<BanjixinxiEntity> wrapper);
   	
   	BanjixinxiView selectView(@Param("ew") Wrapper<BanjixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BanjixinxiEntity> wrapper);
   	

}

