package com.xiaoxin.service;

import java.util.List;

import com.xiaoxin.model.Users;

public interface LoginService {
	public List<Users> findUserByName(String userName);
	//短信接口
	public Integer duanxin(String phone) throws Exception;
}
