package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * This controller gets game input command and returns game state
 * 
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@RestController
public class PlayController {

    @ModelAttribute("gameState")
    public StoneGame addGamestateToRequest() {
        StoneGame stoneGame = new StoneGame();
        return stoneGame;
    }    
    
    //TODO get command from client and response game state

}
