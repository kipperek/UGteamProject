package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Sound {

	private com.badlogic.gdx.audio.Sound sound;
	private Vector2 position;
	private int hearDistance = 500;

	public Sound(String resourceName, Vector2 soundPosition) {
		sound = Gdx.audio.newSound(Gdx.files.internal(resourceName));
		position = new Vector2();
		position.x = soundPosition.x;
		position.y = soundPosition.y;
	}

	public Sound(String resourceName) {
		sound = Gdx.audio.newSound(Gdx.files.internal(resourceName));
	}

	public void play() {
		sound.play();
	}

	public void play(Vector2 soundPosition, float charPositionX, float charPositionY) {

		// volume range 0 - 1
		float distance = 0;

		// counting max distance
		if ((soundPosition.x - charPositionX) > distance)
			distance = soundPosition.x - charPositionX;
		else if ((charPositionX - soundPosition.x) > distance)
			distance = charPositionX - soundPosition.x;

		if ((soundPosition.y - charPositionY) > distance)
			distance = soundPosition.y - charPositionY;
		else if ((charPositionY - soundPosition.y) > distance)
			distance = charPositionY - soundPosition.y;

		// handling distance
		if (distance < hearDistance)
			sound.play(1f * (50 / distance));
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