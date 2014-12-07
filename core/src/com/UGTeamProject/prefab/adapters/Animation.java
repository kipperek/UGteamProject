package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
	
	private com.badlogic.gdx.graphics.g2d.Animation animation;

	public Animation(float frameDuration, Array <TextureRegion> animationFrames) {
		animation = new com.badlogic.gdx.graphics.g2d.Animation(frameDuration, animationFrames);
	}
	
	public TextureRegion getKeyFrame(float stateTime, boolean looping) {
		return animation.getKeyFrame(stateTime,looping);
	}
	
	public int getKeyFrameIndex(float stateTime) {
		return animation.getKeyFrameIndex(stateTime);
	}
	
	public PlayMode getPlayMode() {
		return animation.getPlayMode();
	}
	
	public void setPlayMode(PlayMode playMode) {
		animation.setPlayMode(playMode);
	}
	
	public float getAnimationDuration() {
		return animation.getAnimationDuration();
	}
	
	public float getFrameDuration() {
		return animation.getFrameDuration();
	}
	
	public void setFrameDuration(float frameDuration) {
		animation.setFrameDuration(frameDuration);
	}
}