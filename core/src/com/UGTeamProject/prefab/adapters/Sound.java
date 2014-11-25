package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Sound {
	
	private com.badlogic.gdx.audio.Sound sound;
	private Vector2 position;
	private int hearDistance = 300;
	
	public Sound (String resourceName, Vector2 soundPosition) {
		sound = Gdx.audio.newSound(Gdx.files.internal(resourceName));
		position = new Vector2();
		position.x = soundPosition.x;
		position.y = soundPosition.y;
	}
	
	public Sound (String resourceName) {
		sound = Gdx.audio.newSound(Gdx.files.internal(resourceName));
	}
	
	public void play() {
		sound.play();
	}
	
	public void play(Vector2 soundPosition, Vector2 charPosition) {
		
		//volume range 0 - 1
		float distance = 0;
		
		//counting max distance
		if ((soundPosition.x - charPosition.x) > distance)
			distance = soundPosition.x - charPosition.x;
		else if ((charPosition.x - soundPosition.x) > distance)
			distance = charPosition.x - soundPosition.x ;
		
		if ((soundPosition.y - charPosition.y) > distance)
			distance = soundPosition.y - charPosition.y;
		else if ((charPosition.y - soundPosition.y) > distance)
			distance = charPosition.y - soundPosition.y;
		
		//handling distance
		if (distance < hearDistance)
			sound.play(1f * (50/distance));
	}
	
	public void loop() {
		sound.loop();
	}
	
	public void stop() {
		sound.stop();
	}
	
	public void pause() {
		sound.pause();
	}
	
	public void resume() {
		sound.resume();
	}
	
	public void dispose() {
		sound.dispose();
	}
}