package com.UGTeamProject.actor;

import java.util.ArrayList;
import java.util.List;

import com.UGTeamProject.game.ItemManager;
import com.UGTeamProject.item.Item;
import com.UGTeamProject.item.Pistol;
import com.UGTeamProject.item.Rifle;
import com.UGTeamProject.item.Weapon;
import com.UGTeamProject.prefab.Bullet;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Character extends Actor {

	protected Weapon weapons[] = new Weapon[3];
	protected Weapon currentWeapon;
	protected int currentWeaponIndex;
	protected int pistolAmmo;
	protected int rifleAmmo;
	protected boolean wut;
	protected boolean shooterStop = false;
	protected List<Bullet> bullets = new ArrayList<Bullet>();

	public Character(Texture texture) {
		super(texture);
		spawn();
		actor.width = 64;
		actor.height = 64;
		weapons[0] = ItemManager.knife;
		currentWeapon = weapons[0];
		currentWeaponIndex = 0;
		pistolAmmo = 0;
		rifleAmmo = 0;
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
				item.spawn();
				if (item instanceof Pistol && weapons[1] == null)
					weapons[1] = ItemManager.pistol;
				else if (item instanceof Rifle && weapons[2] == null)
					weapons[2] = ItemManager.rifle;
				
				if (item instanceof Pistol) {
					pistolAmmo += ItemManager.pistol.magazineSize;
					if (pistolAmmo > ItemManager.pistol.ammoSize)
						pistolAmmo = ItemManager.pistol.ammoSize;
				} else if (item instanceof Rifle) {
					rifleAmmo += ItemManager.rifle.magazineSize;
					if (rifleAmmo > ItemManager.rifle.ammoSize)
						rifleAmmo = ItemManager.rifle.ammoSize;
				}
			}
		}
	}

	public void changeWeapon() {
		if (wut == false) {
			weapons[0] = ItemManager.knife;
			wut = true;
		}

		do {
			currentWeaponIndex++;
			if (currentWeaponIndex == 3) {
				currentWeaponIndex = 0;
			}
		} while (weapons[currentWeaponIndex] == null);
		currentWeapon = weapons[currentWeaponIndex];
		texture = currentWeapon.playerTexture;
	}
	
	public void shoot(){
		if(shooterStop == false){
			bullets.add(new Bullet(new Vector2(actor.x,actor.y),rotation));	
			shooterStop = true;
		}
	}
	
	public void notShooting(){
		shooterStop = false;
	}
	
	public void drawBullets(Batch batcher){
		List<Bullet> toDelete = new ArrayList<Bullet>();
		for(Bullet bullet : bullets){
			bullet.draw(batcher);
			if(bullet.isOutOfBounds())
				toDelete.add(bullet);
		}
		
		for(Bullet bullet : toDelete){
			bullets.remove(bullet);
		}
		
	}
}