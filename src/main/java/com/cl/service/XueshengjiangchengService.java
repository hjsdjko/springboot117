package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueshengjiangchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengjiangchengView;


/**
 * 学生奖惩
 *
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
public interface XueshengjiangchengService extends IService<XueshengjiangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengjiangchengView> selectListView(Wrapper<XueshengjiangchengEntity> wrapper);
   	
   	XueshengjiangchengView selectView(@Param("ew") Wrapper<XueshengjiangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengjiangchengEntity> wrapper);
   	

}

