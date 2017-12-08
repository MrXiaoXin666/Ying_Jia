package com.xiaoxin.service;

import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoxin.dao.UsersRepository;
import com.xiaoxin.model.Users;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UsersRepository usersRepository;
	@Override
	public List<Users> findUserByName(String userName) {
		return usersRepository.findByUserName(userName);
	}
	//短信接口
	public Integer duanxin(String phone) throws Exception {
		Integer a=(int)(Math.random()*(9999-1000+1))+1000;
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid", "xiaoxin666"),new NameValuePair("Key", "32bbf298c0a0739500db"),new NameValuePair("smsMob",""),new NameValuePair("smsText","验证码："+a)};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result); //打印返回消息状态
		post.releaseConnection();
		return 1234;
	}

}
