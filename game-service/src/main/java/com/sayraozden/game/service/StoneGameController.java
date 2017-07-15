package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * This controller gets game input command and returns game state
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@SessionAttributes("stoneGame")
@RestController
@RequestMapping(value = "/stonegame")
public class StoneGameController {

    final static Logger logger = Logger.getLogger(StoneGameController.class);

    @ModelAttribute("stoneGame")
    public StoneGame getStoneGame() {
        StoneGame game = new StoneGame();
        game.addPlayer(0);
        game.addPlayer(1);
        game.start();
        return game;
    }

    /**
     * With this action players can play game as like a console application,
     * also it is possible to use this action for debug
     *
     * @param model
     * @param request
     * @param session
     * @param game
     * @param pitIndex
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/console")
    public String playStoneGameConsole(
            Model model,
            HttpServletRequest request,
            HttpSession session,
            @ModelAttribute("stoneGame") StoneGame game,
            @RequestParam(value = "pitIndex", required = false) Integer pitIndex
    ) {

        try {
            if (pitIndex != null) {
                game.doMove(pitIndex);
            }
        } catch (IllegalStateException e) {
            logger.error(e);
        }

        return game.toString();
    }

    /**
     * Responses game state JSON object, any client can play via this endpoint
     *
     * @param model
     * @param request
     * @param session
     * @param game
     * @param pitIndex
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/play")
    public StoneGame playStoneGame(
            Model model,
            HttpServletRequest request,
            HttpSession session,
            @ModelAttribute("stoneGame") StoneGame game,
            @RequestParam(value = "pitIndex", required = true) int pitIndex
    ) {

        try {
            game.doMove(pitIndex);
        } catch (IllegalStateException e) {
            logger.error(e);
        }

        return game;
    }

}
