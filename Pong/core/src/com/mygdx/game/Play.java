package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Play implements State {

    SpriteBatch batch;
    Texture ball;
    Texture padL;
    Texture padR;
    private double dx = 3;
    private double dy = 3;
    private int initBallPosX = 315;
    private int initBallPosY = 235;
    private int ballPosX = initBallPosX;
    private int ballPosY = initBallPosY;
    private int padPosYR = Pong.WORLD_HEIGHT / 2;
    private int padPosYL = Pong.WORLD_HEIGHT / 2;
    private int padPosRX = Pong.WORLD_WIDTH;
    private int padPosLX = 0;
    private float deltaTime;
    private int padHeigth = 50;
    public int padWidth = 10;
    private int scorep1 = 0;
    private int scorep2 = 0;
    private int ballwidth = 10;
    public BitmapFont font;
    private Pong pong = new Pong();

    @Override
    public void Game() {
        movePad();
        moveBall();
        updateScore();
    }

    public void moveBall() {
            batch.draw(ball, ballPosX, ballPosY, ballwidth, 10);

            if (ballPosX <= padWidth && Math.abs(ballPosY - padPosYR) < padHeigth || ballPosX >= (Pong.WORLD_WIDTH - padWidth - ballwidth) && Math.abs(ballPosY - padPosYL) < padHeigth) {
                dx = -dx * 1.2;
            } else if (ballPosX <= padPosLX) {
                ballPosX = initBallPosX;
                ballPosY = initBallPosY;
                dx = -3;
                dy = -3;

            } else if (ballPosX >= padPosRX) {
                ballPosX = initBallPosX;
                ballPosY = initBallPosY;
                dx = 3;
                dy = 3;

            }

            ballPosX += dx;


            if (ballPosY >= Pong.WORLD_HEIGHT || ballPosY <= 0) {
                dy = -dy;
            }
            ballPosY += dy;
        }


        public void movePad () {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (padPosYR > Pong.WORLD_HEIGHT - padHeigth) {
                    padPosYR -= 0;
                } else padPosYR += 6;

            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (padPosYR < 0) {
                    padPosYR += 0;
                } else padPosYR -= 6;
            }
            batch.draw(padL, 0, padPosYR, padWidth, padHeigth);

            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                if (padPosYL > Pong.WORLD_HEIGHT - padHeigth) {
                    padPosYL -= 0;
                } else padPosYL += 6;

            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                if (padPosYL < 0) {
                    padPosYL += 0;
                } else padPosYL -= 6;
            }

            batch.draw(padR, Pong.WORLD_WIDTH - padWidth, padPosYL, padWidth, padHeigth);
        }

        public void updateScore () {
            if (ballPosX >= (Pong.WORLD_WIDTH - 1)) {
                scorep1++;
                System.out.print("Player one scored " + scorep1);
            }
            if (ballPosX <= 0) {
                scorep2++;
                System.out.print("Player two scored " + scorep2);

            }
            font.draw(batch, "Player 1: " + scorep1, 40, Pong.WORLD_HEIGHT - 40);
            font.draw(batch, "Player 2: " + scorep2, Pong.WORLD_WIDTH - 80, Pong.WORLD_HEIGHT - 40);
        }

        public void setToPause() {
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            pong.setPongState(pong.getPauseState());
        }


    }}

