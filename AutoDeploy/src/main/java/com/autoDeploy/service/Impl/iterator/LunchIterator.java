package com.autoDeploy.service.Impl.iterator;

import com.autoDeploy.entity.MenuItem;

import java.util.Iterator;

public class LunchIterator implements Iterator {
	private MenuItem[] menuItems;
	private int position =0;


	public LunchIterator(MenuItem[] _menuItems){
		this.menuItems = _menuItems;
	}

	@Override
	public boolean hasNext() {
		if(menuItems ==null){
			return false;
		}
		return position<menuItems.length;
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems[position];
		position++;
		return menuItem;
	}
}
