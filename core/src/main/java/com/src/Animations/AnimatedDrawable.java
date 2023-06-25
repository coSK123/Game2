package com.src.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.utils.Array;


public class AnimatedDrawable extends BaseDrawable {

        private Animation animation;

        private float stateTime = 0;
        private TextureAtlas charset;

    // Frame that must be rendered at each time
        private TextureRegion currentFrame;

        public AnimatedDrawable(){
            charset = new TextureAtlas(Gdx.files.internal("Idle.atlas"));
            Array<TextureAtlas.AtlasRegion> frames = charset.findRegions("Idle");
            this.animation = new Animation(.1f,frames, Animation.PlayMode.LOOP);
            TextureRegion key = frames.first();

            this.setLeftWidth(key.getRegionWidth());
            this.setRightWidth(key.getRegionWidth());
            this.setTopHeight(key.getRegionHeight());
            this.setBottomHeight(key.getRegionHeight());
            this.setMinWidth(key.getRegionWidth());
            this.setMinHeight(key.getRegionHeight());

        }

        @Override
        public void draw(Batch batch, float x, float y, float width, float height){

            stateTime += Gdx.graphics.getDeltaTime();
            currentFrame = (TextureRegion) animation.getKeyFrame(stateTime, true);

            batch.draw(currentFrame, x,y, 640, 320);
        }
    }

