package com.service.Dev_user;

import com.entity.Dev_user;

public interface DevService {
	
	/**
	 * µÇÂ¼
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public Dev_user login(String devCode,String devPassword);
}
