package com.dao.Dev_user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Dev_user;

public interface DevDao {
	
	/**
	 * �����˺Ų�ѯ
	 * @param devCode
	 * @return
	 */
	public Dev_user getDveCode(String devCode); 
	
}
