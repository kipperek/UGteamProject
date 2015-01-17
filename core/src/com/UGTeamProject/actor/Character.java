package com.UGTeamProject.actor;

import java.util.ArrayList;

import com.UGTeamProject.game.ItemManager;
import com.UGTeamProject.item.Item;
import com.UGTeamProject.item.Weapon;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Character extends Actor {

	protected ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	protected Weapon currentWeapon;
	protected int currentWeaponIndex;

	public Character(Texture texture) {
		super(texture);
		spawn();
		actor.width = 64;
		actor.height = 64;
		weapons.add(ItemManager.knife);
		currentWeapon = weapons.get(0);
		currentWeaponIndex = 0;
	}

	public void spawn() {
		actor.x = MathUtils.random(0, 1000);
		actor.y = MathUtils.random(0, 1000);
	}

	public void die() {
		if (life <= 0)
			spawn();
	}

	public void pickUp() {
		for (Item item : ItemManager.items) {
			if (com.badlogic.gdx.math.Intersector.overlaps(actor, item.item)) {
				item.setPickedUp(true);
				if (item instanceof Weapon)
					weapons.add((Weapon) item);
			}
		}
	}

	public void changeWeapon() {
		currentWeaponIndex++;
		if (currentWeaponIndex == weapons.size()) {
			currentWeapon = weapons.get(0);
			currentWeaponIndex = 0;
		} else
			currentWeapon = weapons.get(currentWeaponIndex);
	}
}