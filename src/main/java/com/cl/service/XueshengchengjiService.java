package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueshengchengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengchengjiView;


/**
 * 学生成绩
 *
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface XueshengchengjiService extends IService<XueshengchengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengchengjiView> selectListView(Wrapper<XueshengchengjiEntity> wrapper);
   	
   	XueshengchengjiView selectView(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengchengjiEntity> wrapper);
   	

}

