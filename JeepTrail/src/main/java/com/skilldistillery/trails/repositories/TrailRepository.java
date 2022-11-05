package com.skilldistillery.trails.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.trails.entities.Trail;

public interface TrailRepository extends JpaRepository<Trail, Integer> {
	
	Trail findById(int id);

}
