package com.autoDeploy.entity;

import lombok.Data;

@Data
public class MenuItem {

	private String name;

	private double price;

	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
}
