package com.sayraozden.game.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@Component
@Scope("session")
public class SampleResponse {

    private final int id;
    private int count;
    private final String content;

    public SampleResponse(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public void addCount() {
        count++;
    }

    public int getCount() {
        return this.count;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
