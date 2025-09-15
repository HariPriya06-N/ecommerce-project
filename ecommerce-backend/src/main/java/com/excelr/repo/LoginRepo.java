package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {
	public Login findByUsername(String username);

}
