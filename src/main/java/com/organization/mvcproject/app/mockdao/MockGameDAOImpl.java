package com.organization.mvcproject.app.mockdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.MockGameDAO;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.api.service.GameService;


@Repository
public class MockGameDAOImpl implements MockGameDAO{

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setid(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setid(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setid(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	
	public List<Game> retrieveAllGames() {
		return ImmutableList.copyOf(games);
	}

	
	public Game saveGame(Game game) {
		game.setid(++gameId);
		games.add((GameImpl)game);
		return game;
	}
	
	public Game updateGame(Game game) {
		if(game.getId()!= null) {
			Long currentId = game.getId();
			for(int i =0; i< games.size(); i++) {
				if(currentId == games.get(i).getId() ) {
					games.set(i, (GameImpl) game);
				}
			}
		}
		return game;
	}
	
	public Boolean deleteGame(Long id) {
		for (GameImpl game: games) {
			if(game.getId().equals(id)) {
				games.remove(game);
				return true;
			}
		
		}
		return false;
		
	}
	
	
	
	
	
	

}