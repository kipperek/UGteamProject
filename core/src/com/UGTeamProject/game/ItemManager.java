package com.UGTeamProject.game;

import java.util.ArrayList;

import com.UGTeamProject.item.Item;
import com.UGTeamProject.item.Knife;
import com.UGTeamProject.item.Pistol;
import com.UGTeamProject.item.Rifle;

public class ItemManager {

	public static Knife knife;
	public static Pistol pistol;
	public static Rifle rifle;
	
	public static ArrayList<Item> items;
	public static Knife knife1,knife2;
	public static Pistol pistol1, pistol2;
	public static Rifle rifle1, rifle2;

	public static void load() {

		knife = new Knife(null);
		pistol = new Pistol(null);
		rifle = new Rifle(null);
		
		items = new ArrayList<Item>();
		pistol1 = new Pistol(AssetsManager.pistolTexture);
		rifle1 = new Rifle(AssetsManager.rifleTexture);
		pistol2 = new Pistol(AssetsManager.pistolTexture);
		rifle2 = new Rifle(AssetsManager.rifleTexture);

		items.add(pistol1);
		items.add(rifle1);
		items.add(pistol2);
		items.add(rifle2);
	}
}