package com.sayraozden.game.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //Command1: {playerID:1, move:5}; || invalid command format
        /*StoneGame stoneGame = new StoneGame();
        

        stoneGame.addPlayer(1);
        stoneGame.addPlayer(2);
        
        stoneGame.startGame();

        stoneGame.doMove(1, 1);        
        stoneGame.doMove(2, 3);
        stoneGame.doMove(1, 4);        
        stoneGame.doMove(2, 5);
        stoneGame.doMove(1, 0);
        stoneGame.doMove(2, 2);
        stoneGame.doMove(1, 3);
        stoneGame.doMove(2, 4);
        stoneGame.doMove(1, 5);
        stoneGame.doMove(2, 0);*/        
    }

}
