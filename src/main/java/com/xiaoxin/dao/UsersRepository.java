package com.xiaoxin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xiaoxin.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public List<Users> findByUserName(String userName);
	
}
