package com.UGTeamProject.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.UGTeamProject.actor.Character;
import com.UGTeamProject.game.AssetsManager;

public class ScreenInput {

	public static Character player;
	Vector2 vec = new Vector2();
	Vector2 vec2 = new Vector2();

	public ScreenInput(Character newPlayer) {
		player = newPlayer;
	}

	public static Touchpad initTouchpad(float x, float y) {
		Touchpad touchpad;
		TouchpadStyle touchpadStyle;
		Skin touchpadSkin;
		Drawable touchBackground;
		Drawable touchKnob;

		touchpadSkin = new Skin();
		touchpadSkin.add("touchBackground", AssetsManager.touchBackground);
		touchpadSkin.add("touchKnob", AssetsManager.touchKnob);
		touchpadStyle = new TouchpadStyle();
		touchBackground = touchpadSkin.getDrawable("touchBackground");
		touchKnob = touchpadSkin.getDrawable("touchKnob");
		touchpadStyle.background = touchBackground;
		touchpadStyle.knob = touchKnob;
		touchpad = new Touchpad(1, touchpadStyle);
		touchpad.setBounds(x - 150, y - 50, 70, 70);

		return touchpad;
	}
	
	public static Button initButton(float x, float y,Texture background) {
		Button button;
		ButtonStyle buttonStyle;
		Skin buttonSkin;

		buttonSkin = new Skin();
		buttonSkin.add("buttonBackground", background);
		buttonStyle = new ButtonStyle();
		buttonStyle.up = buttonSkin.getDrawable("buttonBackground");
		button = new Button(buttonStyle);
		button.setBounds(x - 150, y - 50, 40, 32);

		return button;
	}

	public void listen(Touchpad leftAnalog, Touchpad rightAnalog, Button pickupButton, Button weaponButton) {
		
		pickupButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            	player.pickUp();
            	return true;
            }
        });
		
		weaponButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            	player.changeWeapon();
            	return true;
            }
        });
		
		player.setX(player.getX() + leftAnalog.getKnobPercentX() * 5);
		player.setY(player.getY() + leftAnalog.getKnobPercentY() * 5);
		
		leftAnalog.setX((player.getX() - 150));
		leftAnalog.setY((player.getY() - 90));
		
		rightAnalog.setX(player.getX() + 150);
		rightAnalog.setY(player.getY() - 90);
		
		pickupButton.setX(player.getX() + 190);
		pickupButton.setY(player.getY());
		
		weaponButton.setX(player.getX() + 140);
		weaponButton.setY(player.getY());

		vec.set(rightAnalog.getKnobPercentX(), rightAnalog.getKnobPercentY());
		player.setRotation(vec.angle() + 270);
		
	}

	public void listen() {

		if (Gdx.input.isKeyPressed(Keys.A))
			player.setX(player.getX() - 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Keys.D))
			player.setX(player.getX() + 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Keys.W))
			player.setY(player.getY() + 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Keys.S))
			player.setY(player.getY() - 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyJustPressed(Keys.F))
			player.pickUp();
		if (Gdx.input.isKeyJustPressed(Keys.Q))
			player.changeWeapon();

		float mouseX = Gdx.input.getX();
		float mouseY = Gdx.input.getY();
		player.setRotation((float) Math.toDegrees(Math.atan2(-mouseY + Gdx.graphics.getHeight() / 2, mouseX - Gdx.graphics.getWidth() / 2)) - 90);

	}
}
