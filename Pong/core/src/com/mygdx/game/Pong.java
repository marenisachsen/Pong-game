package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pong extends ApplicationAdapter {

    public static final int WORLD_WIDTH = 600;
    public static final int WORLD_HEIGHT = 400;




    State play;
    State pause;

    State state;

    public Pong () {
        play = new Play();
        pause = new Pause();

        state = new Play();

        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            state = pause;
        }
    }

    public  void setPongState(State newState) {
        state = newState;

    }

    public void Game(){
        state.Game();
    }


    public State getPlayState(){
        return play;
    }
    public State getPauseState(){
        return pause;
    }

    @Override
    public void render() {
        Game();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void create() {

    }
}
