'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', '$log', function(GameService, $log) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.deleteGame = function(game){
				return GameService.deleteGame(game).then(function(response) {
				$log.debug(response);
				self.fetchAllGames();
				self.game={};
				}
			);
		}

		self.updateGame =function(){
			return GameService.updateGame(self.game).then(function(data){
				$log.debug(data);
				self.fetchAllGames();
				self.game={};
			});
		}
		self.loadGameToUpdate= function(game){
			self.game = angular.copy(game);
		}
		self.clearForm= function(game){
			self.game= {};
		}

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
