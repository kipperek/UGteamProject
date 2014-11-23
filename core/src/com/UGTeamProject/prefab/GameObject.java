package com.UGTeamProject.prefab;
import java.util.ArrayList;

import com.UGTeamProject.prefab.adapters.Physics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GameObject {
	
	public static ArrayList<Sound> sound = new ArrayList<Sound>();
	public static ArrayList<Texture> texture = new ArrayList<Texture>();
	public static ArrayList<Physics> physics = new ArrayList<Physics>();

	public GameObject(ArrayList<String> textureNames,ArrayList<String> soundNames){
		
		Texture item;
		String newtexture;
		String newsound;
		
		for(int i = 0; i<textureNames.size(); i++)
		{
			newtexture = textureNames.get(i);
			item = new Texture(Gdx.files.internal(newtexture));
			texture.add(item);
		}
		
		for(int i = 0; i<soundNames.size(); i++)
		{
			newsound = soundNames.get(i);
			sound.add(Gdx.audio.newSound(Gdx.files.internal(newsound)));
		}
	}

}
