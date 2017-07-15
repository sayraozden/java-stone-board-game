/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayraozden.game.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@Controller
public class StoneGameController {

    /**
     *
     * @return
     */
    @RequestMapping("/play")
    public String play() {        
        return "play";
    }
    
    /**
     *
     * @return
     */
    @RequestMapping("/play/stone")
    public String playStone() {        
        return "game/stone";
    }
    
}
