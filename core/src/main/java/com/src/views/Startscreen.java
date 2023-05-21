package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.src.Character;
import com.src.Warrior;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;


public class Startscreen implements Screen {

    final Game game;
    Character character;
    BitmapFont font = new BitmapFont();
    SpriteBatch batch;

    public Startscreen(Game game, String character) {
        this.game = game;
        switch(character){
            case "Warrior"-> this.character = new Warrior();
        }
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font.setColor(Color.GREEN);
    }




    public void render( float dt )
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "Go Vegan!!!!!!!!!!!!!!!!!!!!!!!!", 200, 200);
        batch.end();
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
