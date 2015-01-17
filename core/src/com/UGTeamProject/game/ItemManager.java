package com.UGTeamProject.game;

import java.util.ArrayList;

import com.UGTeamProject.item.Item;
import com.UGTeamProject.item.Knife;
import com.UGTeamProject.item.Pistol;
import com.UGTeamProject.item.Rifle;

public class ItemManager {

	public static Knife knife;
	public static Rifle rifle;
	public static Pistol pistol;
	public static ArrayList<Item> items;

	public static void load() {

		items = new ArrayList<Item>();
		knife = new Knife(null);
		pistol = new Pistol(AssetsManager.pistolTexture);
		rifle = new Rifle(AssetsManager.rifleTexture);

		items.add(pistol);
		items.add(rifle);
	}
}