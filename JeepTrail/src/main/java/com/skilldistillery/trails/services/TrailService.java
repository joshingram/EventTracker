package com.skilldistillery.trails.services;

import java.util.List;

import com.skilldistillery.trails.entities.Trail;

public interface TrailService {
	
	List <Trail> listAllTrails();
	
	Trail showTrail(int trailId);
	
	Trail create(Trail trail);
	
	Trail update(int trailId, Trail trail);
	
	boolean delete(int trailId);
	
	List <Trail> findAllOrderByHighestElevation();

}
