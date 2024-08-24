package com.cl.entity.view;

import com.cl.entity.XuanxiukechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 选修课程
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@TableName("xuanxiukecheng")
public class XuanxiukechengView  extends XuanxiukechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuanxiukechengView(){
	}
 
 	public XuanxiukechengView(XuanxiukechengEntity xuanxiukechengEntity){
 	try {
			BeanUtils.copyProperties(this, xuanxiukechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
