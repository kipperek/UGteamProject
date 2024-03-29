package com.UGTeamProject.prefab;

import java.util.ArrayList;

import com.UGTeamProject.prefab.adapters.Physics;
import com.UGTeamProject.prefab.adapters.Sound;
import com.UGTeamProject.prefab.adapters.Texture;
import com.UGTeamProject.prefab.adapters.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class GameObject {

	public ArrayList<Sound> sound = new ArrayList<Sound>();
	public ArrayList<Texture> texture = new ArrayList<Texture>();
	public ArrayList<Physics> physic = new ArrayList<Physics>();
	public ArrayList<Music> music = new ArrayList<Music>();
	public Vector2 position;

	public GameObject(ArrayList<Sound> sounds, ArrayList<Texture> textures, ArrayList<Physics> physics, ArrayList<Music> musics, float x, float y) {

		sound = sounds;
		physic = physics;
		texture = textures;
		music = musics;
		position = new Vector2(x, y);
	}

	public void addTexture(Texture newTexture) {
		texture.add(newTexture);
	}

	public void removeTexture(Texture newTexture) {
		texture.remove(newTexture);
	}

	public void addSound(Sound newSound) {
		sound.add(newSound);
	}

	public void removeSound(Sound newSound) {
		sound.remove(newSound);
	}

	public void addPhysic(Physics newPhysic) {
		physic.add(newPhysic);
	}

	public void removePhysic(Physics newPhysic) {
		physic.remove(newPhysic);
	}

	public void addMusic(Music newMusic) {
		music.add(newMusic);
	}

	public void removeMusic(Music newMusic) {
		music.remove(newMusic);
	}

	public void draw(Batch batch) {
		texture.get(0).draw(batch, position.x, position.y);
	}
}