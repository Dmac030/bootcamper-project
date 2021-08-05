package com.organization.mvcproject.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.ReviewImpl;
import com.organization.mvcproject.api.model.Review;
import com.organization.mvcproject.api.service.GameService;


@Controller
public class GameController {

	@Autowired
	private GameService javaGameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("review", "command", new ReviewImpl());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("result", "submittedReview", review);
	}

	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("games", "command", new GameImpl());
	}

	@GetMapping(value = "game/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(value = "game/createGame",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	 @DeleteMapping(value = "game/{id}")
	    public ResponseEntity<?> deleteGame(@PathVariable("id") Long id) {
	        Boolean isRemoved = javaGameService.deleteGame(id);
	        if (!isRemoved) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(id, HttpStatus.OK);
	   } 
	 
	 @PutMapping(value = "game/updateGame",consumes = MediaType.APPLICATION_JSON_VALUE )
		public ResponseEntity<Void> updateGame(@RequestBody GameImpl game) {
			javaGameService.updateGame(game);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

}