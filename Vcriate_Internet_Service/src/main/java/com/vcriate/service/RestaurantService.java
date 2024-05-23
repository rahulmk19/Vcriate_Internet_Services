package com.vcriate.service;

import java.util.List;

import com.vcriate.model.MenuItem;

public interface RestaurantService {

	public MenuItem addMenuItem(MenuItem menuItem);

	public List<MenuItem> getMenu();

	public MenuItem getMenuItem(Long id);

	public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails);

	public String deleteMenuItem(Long id);

}
