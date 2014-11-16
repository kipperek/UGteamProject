package com.UGTeamProject.prefab;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GameObject {
	
	public static ArrayList<Sound> sound = new ArrayList<Sound>();
	public static ArrayList<Texture> texture = new ArrayList<Texture>();
	
	public static Texture item;

	GameObject(String textureName,String soundName){
		
		item = new Texture(Gdx.files.internal(textureName));
		
	    texture.add(item);
	    sound.add(Gdx.audio.newSound(Gdx.files.internal(soundName)));
	}

}
