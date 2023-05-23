package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class PlayerSelectionScreen implements Screen {
    ShapeRenderer shape;
    final Game game;
    OrthographicCamera camera;
    int x = 50;
    int inkrement = 5;
    Vector3 clickPos;

    public PlayerSelectionScreen(final Game game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        clickPos = new Vector3();
        shape = new ShapeRenderer();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
       /* Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(x+50 > Gdx.graphics.getWidth()|| x<0){
            inkrement = -inkrement;
        }
        x += inkrement;

        */

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(x, 50, 50, 50);
        shape.end();
        if (Gdx.input.isTouched()) {
            clickPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); //when the screen is touched, the coordinates are inserted into the vector
            camera.unproject(clickPos); // calibrates the input to your camera's dimentions
            if (clickPos.x > 50 && clickPos.x < 50 + 50) {
                if (clickPos.y > 50 && clickPos.y < 50 + 50) {
                    System.out.println("click");
                    game.setScreen(new Startscreen(game));

                }
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
