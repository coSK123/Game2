package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.src.Warrior;

public class PlayerSelectionScreen implements Screen {
    final Game game;
    OrthographicCamera camera;

    Stage stage;
    Skin crispy;
    Label outputLabel;
    public PlayerSelectionScreen(final Game game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1800,1000);

    }


    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        crispy = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        outputLabel = new Label("Warrior", crispy);
        TextButton warriorButton = new TextButton(new Warrior().toString(),crispy);
        warriorButton.getLabel().setAlignment(1, Align.left);
        warriorButton.setSize((float) Gdx.graphics.getWidth() /3 -50,Gdx.graphics.getHeight()-100);
        warriorButton.setPosition( 10, 10);
        warriorButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Created a Warrior");
                outputLabel.setText("Press a Button");
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("YOlo");
                outputLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(warriorButton);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();




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
