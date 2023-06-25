package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.src.Animations.AnimatedDrawable;
import com.src.Characters.Hunter;
import com.src.Characters.Thief;
import com.src.Characters.Warrior;

public class PlayerSelectionScreen implements Screen {
    final Game game;
    OrthographicCamera camera;

    Stage stage;
    Skin crispy;
    BaseDrawable warrior;

    Label warriorLabel;
    Label hunterLabel;

    Label thiefLabel;
    Batch batch;


    public PlayerSelectionScreen(final Game game) {
        this.game = game;
        warrior = new AnimatedDrawable();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1800,1000);

    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        crispy = new Skin(Gdx.files.internal("clean-crispy-ui.json"));

        warriorLabel = new Label("Warrior", crispy);
        ImageButton warriorButton = new ImageButton(warrior);
        warriorButton.setBackground(warrior);
        warriorButton.setSize((float) Gdx.graphics.getWidth() /3 -50,Gdx.graphics.getHeight()-10);
        warriorButton.setPosition( 35, 10);

        warriorButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Created a Warrior");
                warriorLabel.setText("Press a Button");
                game.setScreen(new FightScreen(game, new Warrior()));
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("YOlo");
                warriorLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(warriorButton);

        hunterLabel = new Label("Hunter", crispy);
        TextButton hunterButton = new TextButton(new Hunter().toString(),crispy);
        hunterButton.getLabel().setAlignment(1, Align.left);
        hunterButton.setSize((float) Gdx.graphics.getWidth() /3 -50,Gdx.graphics.getHeight()-10);
        hunterButton.setPosition( ((float) Gdx.graphics.getWidth() /3 -50)+70, 10);
        hunterButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Created a Warrior");
                hunterLabel.setText("Press a Button");
                game.setScreen(new FightScreen(game, new Hunter()));
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("YOlo");
                hunterLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(hunterButton);

        thiefLabel = new Label("Hunter", crispy);
        TextButton thiefButton = new TextButton(new Thief().toString(),crispy);
        thiefButton.getLabel().setAlignment(1, Align.left);
        thiefButton.setSize((float) Gdx.graphics.getWidth() /3 -50,Gdx.graphics.getHeight()-10);
        thiefButton.setPosition( ((float) Gdx.graphics.getWidth() /3 -50)*2+105, 10);
        thiefButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Created a Warrior");
                thiefLabel.setText("Press a Button");
                game.setScreen(new FightScreen(game, new Thief()));
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("YOlo");
                thiefLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(thiefButton);
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
