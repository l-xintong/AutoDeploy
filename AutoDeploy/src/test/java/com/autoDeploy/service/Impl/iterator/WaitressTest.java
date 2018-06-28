package com.autoDeploy.service.Impl.iterator;

import com.autoDeploy.entity.MenuItem;
import com.autoDeploy.service.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaitressTest {

	@Autowired
	 private  BreakfastMenu menu ;
	@Autowired
	private LunchMenu men;




	@Test
	public void printMenu() {
		initMenuItem();
		Waitress waitress = new Waitress(menu);
		waitress.printMenu();
		Waitress waitress1 = new Waitress(men);
		waitress1.printMenu();




	}

	public  void initMenuItem() {
		addNewMenuItem(menu, new MenuItem("汉堡", 18.0));
		addNewMenuItem(menu, new MenuItem("鸡翅", 12.0));
		addNewMenuItem(menu, new MenuItem("肉包", 1.5));
		addNewMenuItem(menu, new MenuItem("粽子", 2.0));
	}
	private  void addNewMenuItem(BreakfastMenu menu, MenuItem menuItem) {
		menu.addNewMenItem(menuItem);
	}
}