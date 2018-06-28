package com.autoDeploy.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManageDeployControllerTest {


	@Autowired
	private MockMvc mvc;



	@Test
	public void queryList()  throws Exception {
		//设定请求路径及请求方式并执行请求
		MvcResult mvcResult =	mvc.perform(
				MockMvcRequestBuilders.get("/manageDeploy/")
				.contentType(MediaType.APPLICATION_JSON)
				.param("page","1").param("limit","10")

		)
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		//将相应的数据转换为字符串
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);

	}

	@Test
	public void selectById()  throws Exception {
		//设定请求路径及请求方式并执行请求
		mvc.perform(
				MockMvcRequestBuilders.get("/manageDeploy/1")

		)
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
}