package com.UGTeamProject.prefab;

import java.util.ArrayList;
import com.UGTeamProject.prefab.adapters.Physics;
import com.UGTeamProject.prefab.adapters.Sound;
import com.UGTeamProject.prefab.adapters.Texture;
import com.UGTeamProject.prefab.adapters.Music;

public class GameObject {
	
	public static ArrayList<Sound> sound = new ArrayList<Sound>();
	public static ArrayList<Texture> texture = new ArrayList<Texture>();
	public static ArrayList<Physics> physics = new ArrayList<Physics>();
	public static ArrayList<Music> music = new ArrayList<Music>();
	
	public void addTexture(Texture newTexture){
		texture.add(newTexture);
	}
	public void removeTexture(Texture newTexture){
		texture.remove(newTexture);
	}
	
	public void addSound(Sound newSound){
		sound.add(newSound);
	}
	public void removeSound(Sound newSound){
		sound.remove(newSound);
	}
	
	public void addPhysics(Physics newPhysics){
		physics.add(newPhysics);
	}
	
	public void removePhysics(Physics newPhysics){
		physics.remove(newPhysics);
	}
	
	public void addMusic(Music newMusic){
		music.add(newMusic);
	}
	
	public void removeMusic(Music newMusic){
		music.remove(newMusic);
	}

}
