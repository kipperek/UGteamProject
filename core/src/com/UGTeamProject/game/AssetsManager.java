package com.UGTeamProject.game;

import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.math.Vector2;


public class AssetsManager {

	public static Texture playerTexture;
	public static Texture grassTexture;
	public static Texture radioTexture;
	public static com.badlogic.gdx.graphics.Texture touchBackground;
	public static com.badlogic.gdx.graphics.Texture touchKnob;
	public static Music radioMusic;
	
	public static void load() {
		
		playerTexture = new Texture("sprites/bohater.png");
		grassTexture = new Texture("sprites/grass.png");
		radioTexture = new Texture("sprites/radio.jpg");
		touchBackground = new com.badlogic.gdx.graphics.Texture("sprites/touchBackground.png");
	    touchKnob = new com.badlogic.gdx.graphics.Texture("sprites/touchKnob.png");
		radioMusic = new Music("music/radio.mp3"); 
	}
}
