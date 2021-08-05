package com.organization.mvcproject.api.model;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.model.GameImpl;

public interface MockGameDAO {

	public List<Game> retrieveAllGames();
	
	
	public Game saveGame(Game game);
	
	public Game updateGame(Game game);
	
	public Boolean deleteGame(Long id);
	
	
	
}
