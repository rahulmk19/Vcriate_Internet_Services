package com.vcriate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.model.MenuItem;
import com.vcriate.service.RestaurantService;

@RestController
@RequestMapping("/Vcriate/menu")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantSer;

	@GetMapping
	public ResponseEntity<List<MenuItem>> getMenu() {
		List<MenuItem> menuItem = restaurantSer.getMenu();
		return new ResponseEntity<>(menuItem, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
		MenuItem menuItems = restaurantSer.addMenuItem(menuItem);
		return new ResponseEntity<>(menuItems, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable Long id) {
		MenuItem menuItems = restaurantSer.getMenuItem(id);
		return new ResponseEntity<>(menuItems, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItemDetails) {
		MenuItem menuItems = restaurantSer.updateMenuItem(id, menuItemDetails);
		return new ResponseEntity<>(menuItems, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
		String menuItems = restaurantSer.deleteMenuItem(id);
		return new ResponseEntity<>(menuItems, HttpStatus.OK);
	}
}
