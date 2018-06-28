package com.autoDeploy.service.Impl.iterator;

import com.autoDeploy.entity.MenuItem;
import com.autoDeploy.service.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BreakfastMenu implements Menu {

	private List<MenuItem> menuItems;

	public BreakfastMenu(){
		menuItems = new ArrayList<>();
	}

	public void addNewMenItem(MenuItem menuItem){
		menuItems.add(menuItem);
	}

	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}
}
