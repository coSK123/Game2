package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;



public class Startscreen implements Screen {

    final Game game;
    OrthographicCamera camera;

    Stage stage;
    Skin crispy;
    Label outputLabel;

    public Startscreen(Game game) {
        this.game = game;
    }

    public void show() {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1800,1000);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        crispy = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        outputLabel = new Label("StartButton", crispy);
        Button button2 = new TextButton("Press to start",crispy);
        int col_width = 30;
        int row_height = 20;
        button2.setSize(col_width *4, row_height);
        button2.setPosition((float) Gdx.graphics.getWidth() /2, (float) Gdx.graphics.getHeight()/2);
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Press a Button");
                outputLabel.setText("Press a Button");
                game.setScreen(new PlayerSelectionScreen(game));

            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("YOlo");
                outputLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(button2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
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
        stage.dispose();

    }
}
