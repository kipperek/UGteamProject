package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Music {

	private com.badlogic.gdx.audio.Music music;
	private Vector2 position;

	public Music(String resourceName, Vector2 musicPosition) {
		music = Gdx.audio.newMusic(Gdx.files.internal(resourceName));
		position = new Vector2();
		position.x = musicPosition.x;
		position.y = musicPosition.y;
	}

	public Music(String resourceName) {
		music = Gdx.audio.newMusic(Gdx.files.internal(resourceName));
	}

	public void play() {
		music.play();
	}

	public void setVolume(float volume) {
		music.setVolume(volume);
	}

	public void play(Vector2 musicPosition, float charPositionX, float charPositionY, float hearDistance) {

		// volume range 0 - 1
		float distance = 0;

		// counting max distance
		if ((musicPosition.x - charPositionX) > distance)
			distance = musicPosition.x - charPositionX;
		else if ((charPositionX - musicPosition.x) > distance)
			distance = charPositionX - musicPosition.x;

		if ((musicPosition.y - charPositionY) > distance)
			distance = musicPosition.y - charPositionY;
		else if ((charPositionY - musicPosition.y) > distance)
			distance = charPositionY - musicPosition.y;

		music.play();

		// handling distance
		if (distance < hearDistance) {
			music.setVolume(1f * (100 / distance));
		} else
			music.setVolume(0f);
	}
	
	public void play(float musicPositionX, float musicPositionY, float charPositionX, float charPositionY, float hearDistance) {

		// volume range 0 - 1
		float distance = 0;

		// counting max distance
		if ((musicPositionX - charPositionX) > distance)
			distance = musicPositionX - charPositionX;
		else if ((charPositionX - musicPositionX) > distance)
			distance = charPositionX - musicPositionX;

		if ((musicPositionY - charPositionY) > distance)
			distance = musicPositionY - charPositionY;
		else if ((charPositionY - musicPositionY) > distance)
			distance = charPositionY - musicPositionY;

		music.play();

		// handling distance
		if (distance < hearDistance) {
			music.setVolume(1f * (100 / distance));
		} else
			music.setVolume(0f);
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