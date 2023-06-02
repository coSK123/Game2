package com.src.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import com.src.Characters.Enemies.Enemy;
import com.src.Characters.Enemies.Skeleton;

public class FightScreen implements Screen {
    final Game game;
    OrthographicCamera camera;
    final Character player;

    Stage stage;
    Skin crispy;

    Label attackLabel;
    Enemy enemy;
    SpriteBatch batch;
    BitmapFont font;
    private boolean playermove = true;
    private boolean playerWon = false;

    TextButton attackButton;

    public FightScreen(final Game game, Character character) {
        this.game = game;
        this.player = character;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1800,1000);
        this.enemy = new Skeleton();

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
        attackButton = new TextButton("Attack",crispy);
        attackButton.getLabel().setAlignment(1, Align.left);
        attackButton.setSize((float) Gdx.graphics.getWidth() /3 -50,30);
        attackButton.setPosition( 35, 10);
        attackButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                attackLabel.setText("Attack");
                if(playermove){
                    player.attack(enemy);
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
        font.draw(batch, "Player health"+ player.getHealth(),50,50);
        font.draw(batch, "Enemie health"+ enemy.getHealth(),200,200);
        batch.end();
        if(!playermove){
            enemieMove();
        }
        if(player.getHealth() <= 0){
            game.setScreen(new Startscreen(new com.src.Game()));
        }
        if(enemy.getHealth() <= 0 && !playerWon){
            playerWon = true;
            enemy.droploot(player);
        }
        if(playerWon){
            batch.begin();
            font.draw(batch, "you won", 500, 500);
            font.draw(batch, "gold: "+ player.getGold(),400,400);
            font.draw(batch, "exp"+ player.getExperiencePoints(),400,440);
            batch.end();
            attackButton.remove();
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
        enemy.attack(player);
        playermove = !playermove;
    }
}
