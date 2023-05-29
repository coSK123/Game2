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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.src.Characters.Character;
import com.src.Characters.Enemies.Skeleton;
import com.src.Characters.Warrior;

public class FightScreen implements Screen {
    final Game game;
    OrthographicCamera camera;
    final Character character;

    Stage stage;
    Skin crispy;

    Label attackLabel;
    Character enemie;
    SpriteBatch batch;
    BitmapFont font;
    private boolean playermove = true;

    public FightScreen(final Game game, Character character) {
        this.game = game;
        this.character = character;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1800,1000);
        this.enemie = new Skeleton();

    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        font = new BitmapFont();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        crispy = new Skin(Gdx.files.internal("clean-crispy-ui.json"));

        attackLabel = new Label("Attack", crispy);
        TextButton attackButton = new TextButton("Attack",crispy);
        attackButton.getLabel().setAlignment(1, Align.left);
        attackButton.setSize((float) Gdx.graphics.getWidth() /3 -50,30);
        attackButton.setPosition( 35, 10);
        attackButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                attackLabel.setText("Attack");
                if(playermove){
                    character.attack(enemie);
                    playermove = false;
                }
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("YOlo");
                attackLabel.setText("Yolo");
                return true;
            }
        });
        stage.addActor(attackButton);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        batch.begin();
        font.draw(batch, "Player health"+character.getHealth(),50,50);
        font.draw(batch, "Enemie health"+enemie.getHealth(),200,200);
        batch.end();
        if(!playermove){
            enemieMove();
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
    public void enemieMove(){
        enemie.attack(character);
        playermove = !playermove;
    }
}
