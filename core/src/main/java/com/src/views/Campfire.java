package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.src.Animations.AnimatedDrawable;
import com.src.Characters.Character;

public class Campfire implements Screen {
    final Game game;
    OrthographicCamera camera;

    Stage stage;
    Skin crispy;
    BaseDrawable warrior;

    SpriteBatch batch;
    BitmapFont font;

    final Character player;

    public Campfire(Game game, Character player) {
        this.player = player;
        this.game = game;
        warrior = new AnimatedDrawable();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200,840);

    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        font = new BitmapFont();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        crispy = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        TextButton heal = new TextButton("Heal", crispy);
        heal.setSize(100,20);
        heal.setPosition(300,800);
        heal.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    player.setCurrrentHealth(player.getCurrrentHealth()+20);
                }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){

                return true;
            }
        });
        stage.addActor(heal);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        batch.begin();
        font.draw(batch, "Player health"+ player.getCurrrentHealth(),50,50);
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
