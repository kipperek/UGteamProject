package com.UGTeamProject.item;

import com.UGTeamProject.prefab.adapters.Texture;

public class Pistol extends Weapon {

	public Pistol(Texture texture) {
		super(texture);
		item.width = 32;
		item.height = 32;
		ammoSize = 36;
		magazineSize = 6;
		fireRate = 2;
		damage = 25;
		bulletSpeed = 100;
	}
}