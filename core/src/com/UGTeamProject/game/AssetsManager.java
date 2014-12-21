package com.UGTeamProject.game;

import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Texture;

public class AssetsManager {

	public static Texture playerTexture;
	public static Texture grassTexture;
	public static Texture radioTexture;
	public static Texture npcTexture;
	public static com.badlogic.gdx.graphics.Texture touchBackground;
	public static com.badlogic.gdx.graphics.Texture touchKnob;
	public static Music radioMusic;
	
	public static void load() {
		
		playerTexture = new Texture("sprites/bohater.png");
		grassTexture = new Texture("sprites/grass.png");
		radioTexture = new Texture("sprites/radio.jpg");
		npcTexture = new Texture("sprites/npc.png");
		touchBackground = new Texture("sprites/touchBackground.png").getTexture();
	    touchKnob = new Texture("sprites/touchKnob.png").getTexture();
		radioMusic = new Music("music/radio.mp3"); 
	}
}