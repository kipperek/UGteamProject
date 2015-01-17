package com.UGTeamProject.item;

import com.UGTeamProject.prefab.adapters.Texture;

public class Rifle extends Weapon{

	public Rifle(Texture texture) {
		super(texture);
		item.width = 64;
		item.height = 32;
		ammoSize = 120;
		magazineSize = 30;
		fireRate = 4;
		damage = 50;
		bulletSpeed = 125;
	}
}