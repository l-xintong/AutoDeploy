package com.autoDeploy.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BarcodeUtilTest {



	@Test
	public  void test(){
		BarcodeUtil b = new BarcodeUtil();
		String msg = "123456789";
		String path = "barcode.png";
		b.generateFile(msg,path);
	}


}