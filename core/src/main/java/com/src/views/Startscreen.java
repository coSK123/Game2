package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.src.Character;
import com.src.Warrior;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;


public class Startscreen implements Screen {

    final Game game;
    OrthographicCamera camera;

    Vector3 clickPos;
    Character character;
    BitmapFont font = new BitmapFont();
    SpriteBatch batch;
    ShapeRenderer shape;

    public Startscreen(Game game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        clickPos = new Vector3();



    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font.setColor(Color.BLACK);
        shape = new ShapeRenderer();
    }




    public void render( float dt )
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.rect(200,100,100,300, Color.BLACK, Color.BLACK,Color.BLACK,Color.BLACK);
        shape.end();
        batch.begin();
        font.draw(batch, "Warrior", 220, 290);
        batch.end();
        if (Gdx.input.isTouched()) {
            clickPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); //when the screen is touched, the coordinates are inserted into the vector
            camera.unproject(clickPos); // calibrates the input to your camera's dimentions
            if (clickPos.x > 200 && clickPos.x < 200 + 100) {
                if (clickPos.y > 100 && clickPos.y < 100 + 300) {
                    this.character = new Warrior();
                    System.out.println(character.attack());

                }
            }
        }
        /*
        batch.begin();
        font.draw(batch, "Go Vegan!!!!!!!!!!!!!!!!!!!!!!!!", 200, 200);
        font.draw(batch, String.valueOf(character.attack()), 200, 150);
        batch.end();

         */
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
        shape.dispose();
        batch.dispose();
        font.dispose();
    }
}
