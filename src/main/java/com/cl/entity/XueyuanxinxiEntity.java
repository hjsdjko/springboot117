package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 学院信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-01 19:28:54
 */
@TableName("xueyuanxinxi")
public class XueyuanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XueyuanxinxiEntity() {
		
	}
	
	public XueyuanxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 学院名称
	 */
					
	private String xueyuanmingcheng;
	
	/**
	 * 学院图片
	 */
					
	private String xueyuantupian;
	
	/**
	 * 学院人数
	 */
					
	private Integer xueyuanrenshu;
	
	/**
	 * 成立时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chenglishijian;
	
	/**
	 * 院长姓名
	 */
					
	private String yuanzhangxingming;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 学院专业
	 */
					
	private String xueyuanzhuanye;
	
	/**
	 * 学院介绍
	 */
					
	private String xueyuanjieshao;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：学院名称
	 */
	public void setXueyuanmingcheng(String xueyuanmingcheng) {
		this.xueyuanmingcheng = xueyuanmingcheng;
	}
	/**
	 * 获取：学院名称
	 */
	public String getXueyuanmingcheng() {
		return xueyuanmingcheng;
	}
	/**
	 * 设置：学院图片
	 */
	public void setXueyuantupian(String xueyuantupian) {
		this.xueyuantupian = xueyuantupian;
	}
	/**
	 * 获取：学院图片
	 */
	public String getXueyuantupian() {
		return xueyuantupian;
	}
	/**
	 * 设置：学院人数
	 */
	public void setXueyuanrenshu(Integer xueyuanrenshu) {
		this.xueyuanrenshu = xueyuanrenshu;
	}
	/**
	 * 获取：学院人数
	 */
	public Integer getXueyuanrenshu() {
		return xueyuanrenshu;
	}
	/**
	 * 设置：成立时间
	 */
	public void setChenglishijian(Date chenglishijian) {
		this.chenglishijian = chenglishijian;
	}
	/**
	 * 获取：成立时间
	 */
	public Date getChenglishijian() {
		return chenglishijian;
	}
	/**
	 * 设置：院长姓名
	 */
	public void setYuanzhangxingming(String yuanzhangxingming) {
		this.yuanzhangxingming = yuanzhangxingming;
	}
	/**
	 * 获取：院长姓名
	 */
	public String getYuanzhangxingming() {
		return yuanzhangxingming;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：学院专业
	 */
	public void setXueyuanzhuanye(String xueyuanzhuanye) {
		this.xueyuanzhuanye = xueyuanzhuanye;
	}
	/**
	 * 获取：学院专业
	 */
	public String getXueyuanzhuanye() {
		return xueyuanzhuanye;
	}
	/**
	 * 设置：学院介绍
	 */
	public void setXueyuanjieshao(String xueyuanjieshao) {
		this.xueyuanjieshao = xueyuanjieshao;
	}
	/**
	 * 获取：学院介绍
	 */
	public String getXueyuanjieshao() {
		return xueyuanjieshao;
	}

}
