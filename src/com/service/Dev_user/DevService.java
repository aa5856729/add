package com.service.Dev_user;

import com.entity.Dev_user;

public interface DevService {
	
	/**
	 * ��¼
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public Dev_user login(String devCode,String devPassword);
}
