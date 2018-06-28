package com.autoDeploy.service.Impl;



import com.autoDeploy.entity.ManageDeploy;
import com.autoDeploy.entity.ManageJob;
import com.autoDeploy.mapper.ManageDeployMapper;
import com.autoDeploy.service.ManageDeployService;
import com.autoDeploy.util.HttpUtils;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.http.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lee
 * @since 2018-05-21
 */
@Service
public class ManageDeployServiceImpl extends ServiceImpl<ManageDeployMapper, ManageDeploy> implements ManageDeployService {

   @Autowired
	private ManageDeployMapper manageDeployMapper;


	@Override
	public Page<ManageDeploy> selectPage(Page<ManageDeploy> page, Map<String, Object> map) {
		page.setRecords(manageDeployMapper.queryPage(page, map));
		return page;
	}

	String vcode = null;
	@Override
	public String testCode(String phoneNum) {

		vcode = createRandomVcode();
		String paras = vcode+","+2;
		String host = "http://cowsms.market.alicloudapi.com";
		String path = "/intf/smsapi";
		String method = "GET";
		String appcode = "ee85c7eb2e704c85a16dd7df6a569e05";
		Map<String, String> headers = new HashMap<>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<>();
		querys.put("mobile", phoneNum);
		querys.put("paras", paras);//验证码1234，请在2分钟内提交验证
		querys.put("sign", "斑羚在线");
		querys.put("tpid", "009");


		try {
			/**
			 * 重要提示如下:
			 * HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			System.out.println(response.toString());
			//获取response的body
			System.out.println(EntityUtils.toString(response.getEntity()));
			return vcode;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cuo";

	}

	public  String createRandomVcode(){
		//验证码
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int)(Math.random() * 9);
		}
		return vcode;
	}
}
