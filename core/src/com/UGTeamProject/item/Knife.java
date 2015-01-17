package com.UGTeamProject.item;

import com.UGTeamProject.game.AssetsManager;
import com.UGTeamProject.prefab.adapters.Texture;

public class Knife extends Weapon {

	public Knife(Texture texture) {
		super(texture);
		playerTexture = AssetsManager.playerKnifeTexture;
		damage = 25;
	}
}