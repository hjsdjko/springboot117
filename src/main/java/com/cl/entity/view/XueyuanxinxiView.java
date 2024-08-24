package com.cl.entity.view;

import com.cl.entity.XueyuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学院信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@TableName("xueyuanxinxi")
public class XueyuanxinxiView  extends XueyuanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueyuanxinxiView(){
	}
 
 	public XueyuanxinxiView(XueyuanxinxiEntity xueyuanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, xueyuanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
