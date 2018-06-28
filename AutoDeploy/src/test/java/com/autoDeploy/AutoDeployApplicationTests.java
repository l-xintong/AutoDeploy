package com.autoDeploy;

import com.autoDeploy.entity.City;
import com.autoDeploy.entity.User;
import com.autoDeploy.service.CityService;
import com.autoDeploy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AutoDeployApplicationTests{


	//模拟mvc对象类.
	@Autowired
	private MockMvc mvc;

	@Test
	public void selectByid() throws Exception {


	}

	@Autowired
	private CityService cityService;

	@Autowired
	private UserService userService;


	@Test
	public void  shiWuTest(){
		City city = new City();
		city.setCityName("巴中");
		cityService.insert(city);

		User u = new User();
		u.setUsername("xintong");
		userService.insert(u);

	}





}
