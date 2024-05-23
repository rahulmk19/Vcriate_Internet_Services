package com.vcriate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcriate.model.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

}
