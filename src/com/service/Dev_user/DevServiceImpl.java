package com.service.Dev_user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dao.Dev_user.DevDao;
import com.entity.Dev_user;

@Service("devService")
public class DevServiceImpl implements DevService {
	
	@Resource
	private DevDao devDao;

	public DevDao getDevDxao() {
		return devDao;
	}


	public void setDevDxao(DevDao devDao) {
		this.devDao = devDao;
	}


	@Override
	public Dev_user login(String devCode, String devPassword) {
		Dev_user dev = null;
		try {
			dev = devDao.getDveCode(devCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dev);
		if(dev != null) {
			if(dev.getDevPassword().equals(devPassword)) {
				return dev;
			}else {
				throw new RuntimeException("密码输入错误");
			}
		}else {
			throw new RuntimeException("用户名不存在");
		}
	}
	
}
