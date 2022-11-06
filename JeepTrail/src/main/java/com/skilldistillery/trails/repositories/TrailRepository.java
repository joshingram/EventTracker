package com.skilldistillery.trails.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.trails.entities.Trail;

public interface TrailRepository extends JpaRepository<Trail, Integer> {
	
	Trail findById(int id);
	
	List <Trail> findAllByOrderByHighestElevationAsc();
	
	List <Trail> findAllByOrderByHighestElevationDesc();

	List <Trail> findAllByOrderByDateCompletedAsc();
	
	List <Trail> findAllByOrderByDateCompletedDesc();
	
	List <Trail> findAllByOrderByLengthAsc();
	
	List <Trail> findAllByOrderByLengthDesc();
	
	List <Trail> findByNameLike(String keyword1);
}
