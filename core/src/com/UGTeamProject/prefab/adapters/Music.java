package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Music {

	private com.badlogic.gdx.audio.Music music;
	private Vector2 position;
	private int hearDistance = 300;
	
	public Music (String resourceName, Vector2 musicPosition) {
		music = Gdx.audio.newMusic(Gdx.files.internal(resourceName));
		position = new Vector2();
		position.x = musicPosition.x;
		position.y = musicPosition.y;
	}
	
	public Music (String resourceName) {
		music = Gdx.audio.newMusic(Gdx.files.internal(resourceName));
	}
	
	public void play() {
		music.play();
	}
	
	public void setVolume(float volume) {
		music.setVolume(volume);
	}
	
    public void play(Vector2 musicPosition, Vector2 charPosition) {
		
		//volume range 0 - 1
		float distance = 0;
		
		//counting max distance
		if ((musicPosition.x - charPosition.x) > distance)
			distance = musicPosition.x - charPosition.x;
		else if ((charPosition.x - musicPosition.x) > distance)
			distance = charPosition.x - musicPosition.x ;
		
		if ((musicPosition.y - charPosition.y) > distance)
			distance = musicPosition.y - charPosition.y;
		else if ((charPosition.y - musicPosition.y) > distance)
			distance = charPosition.y - musicPosition.y;
		
		//handling distance
		if (distance < hearDistance){
			music.setVolume(1f * (50/distance));
			music.play();
		}
	}
    
    public void setLooping() {
		music.setLooping(true);
	}
	
	public void stop() {
		music.stop();
	}
	
	public void pause() {
		music.pause();
	}
	
	public void dispose() {
		music.dispose();
	}
}