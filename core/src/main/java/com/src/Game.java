package com.src;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.src.views.PlayerSelectionScreen;
import com.src.views.Testview;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Game extends com.badlogic.gdx.Game  {
    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont(); // use libGDX's default Arial font
        this.setScreen(new Testview(this));
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
        batch.dispose();
        font.dispose();
    }
}
