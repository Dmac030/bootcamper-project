package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.app.mockdao.MockGameDAOImpl;
import com.organization.mvcproject.api.model.Game;

@Service("javaGameService")
public class GameServiceImpl implements GameService {

	@Autowired 
	private MockGameDAOImpl  mockDAO;

	@Override
	public List<Game> retrieveAllGames() {
		return mockDAO.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return mockDAO.saveGame(game);
	}

	@Override
	public Boolean deleteGame(Long id) {
		return mockDAO.deleteGame(id);
	}

	@Override
	public Game updateGame(Game game) {
		return mockDAO.updateGame(game);
	}
	
	

}