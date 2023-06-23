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
import com.src.Characters.Character;
import com.src.Characters.Hunter;
import com.src.Characters.Thief;
import com.src.Characters.Warrior;

public class RouteSelectionScreen implements Screen {
    final Game game;
    OrthographicCamera camera;

    Stage stage;
    Skin crispy;

    Label RestLabel;

    Label FightLabel;

    final Character player;

    public RouteSelectionScreen(Game game, Character player) {
        this.game = game;
        this.player = player;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1800,1000);

    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        crispy = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        RestLabel = new Label("Rest", crispy);
        TextButton warriorButton = new TextButton("Rest and Regenerate", crispy);
        warriorButton.getLabel().setAlignment(1, Align.left);
        warriorButton.setSize((float) Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getHeight() - 10);
        warriorButton.setPosition(35, 10);
        warriorButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Created a Warrior");
                RestLabel.setText("Press a Button");
                game.setScreen(new Campfire());
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("YOlo");
                RestLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(warriorButton);

        FightLabel = new Label("Fight", crispy);
        TextButton fightButton = new TextButton("Fight some more", crispy);
        fightButton.getLabel().setAlignment(1, Align.left);
        fightButton.setSize((float) Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getHeight() - 10);
        fightButton.setPosition(((float) Gdx.graphics.getWidth() / 2 - 50) + 70, 10);
        fightButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Created a Warrior");
                FightLabel.setText("Press a Button");
                game.setScreen(new FightScreen(game, player));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("YOlo");
                FightLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(fightButton);

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
