package com.sayraozden.game.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayraozden.game.stone.StoneGame;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class StoneGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void playStoneGameConsoleContainsDefaultValue() throws Exception {
        this.mockMvc.perform(
                post("/stonegame/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Your turn --> Player {0} 06-> 06-> 06-> 06-> 06-> 06-> | 00 | = 36"))
                );
    }

    @Test
    public void playStoneGameContainsJSON() throws Exception {
        StoneGame game = new StoneGame();
        game.addPlayer(0);
        game.addPlayer(1);
        game.start();

        this.mockMvc.perform(post("/stonegame/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(game)))
                .andExpect(status().isOk());
    }
}
