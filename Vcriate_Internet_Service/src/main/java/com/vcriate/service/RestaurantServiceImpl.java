package com.vcriate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.exception.VcriateException;
import com.vcriate.model.MenuItem;
import com.vcriate.repository.MenuItemRepo;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private MenuItemRepo menuItemRepo;

	public MenuItem addMenuItem(MenuItem menuItem) {
		Optional<MenuItem> menuItems = menuItemRepo.findById(menuItem.getId());
		if (!menuItems.isPresent()) {
			throw new VcriateException("MenuItem not found with id " + menuItem.getId());
		}
		return menuItemRepo.save(menuItem);
	}

	public List<MenuItem> getMenu() {
		return menuItemRepo.findAll();
	}

	public MenuItem getMenuItem(Long id) {
		Optional<MenuItem> menuItem = menuItemRepo.findById(id);
		if (!menuItem.isPresent())
			throw new VcriateException("MenuItem not found with id " + id);
		return menuItem.get();
	}

	public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails) {
		MenuItem menuItem = menuItemRepo.findById(id)
				.orElseThrow(() -> new VcriateException("MenuItem not found with id " + id));

		menuItem.setName(menuItemDetails.getName());
		menuItem.setDescription(menuItemDetails.getDescription());
		menuItem.setPrice(menuItemDetails.getPrice());

		return menuItemRepo.save(menuItem);
	}

	public String deleteMenuItem(Long id) {
		Optional<MenuItem> menuItem = menuItemRepo.findById(id);
		if (!menuItem.isPresent()) {
			throw new VcriateException("MenuItem not found with id " + id);
		}
		menuItemRepo.delete(menuItem.get());
		return "Item Deleted Succesfully";
	}
}
