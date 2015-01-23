package com.UGTeamProject.screen;

import com.UGTeamProject.actor.Character;
import com.UGTeamProject.actor.NPC;
import com.UGTeamProject.game.AssetsManager;
import com.UGTeamProject.game.GameManager;
import com.UGTeamProject.game.GameObjectManager;
import com.UGTeamProject.game.ItemManager;
import com.UGTeamProject.input.ScreenInput;
import com.UGTeamProject.item.Item;
import com.UGTeamProject.map.Map;
import com.UGTeamProject.prefab.GameObject;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {

	OrthographicCamera camera;
	GameManager game;
	Character player;
	NPC npc;
	Stage stage;
	Viewport newport;
	ScreenInput updateActor;
	Touchpad leftAnalog;
	Touchpad rightAnalog;
	Button pickupButton;
	Button weaponButton; 
	Map map;

	public GameScreen(GameManager game) {
		this.game = game;
		camera = new OrthographicCamera(800, 600);
		camera.setToOrtho(false, 400, 300);
		player = new Character(AssetsManager.playerKnifeTexture);
		npc = new NPC(AssetsManager.npcTexture);
		updateActor = new ScreenInput(player);
		newport = new FitViewport(400, 300, camera);
		stage = new Stage(newport, game.batcher);
		if (Gdx.app.getType() == ApplicationType.Android) {
			
			pickupButton = ScreenInput.initButton(player.getX(), player.getY(),AssetsManager.pickupButton);
			weaponButton = ScreenInput.initButton(player.getX() + 60, player.getY(),AssetsManager.pistolButton);
			leftAnalog = ScreenInput.initTouchpad(player.getX(), player.getY());
			rightAnalog = ScreenInput.initTouchpad(player.getX() + 300, player.getY());
			rightAnalog.setResetOnTouchUp(false);
			
			stage.addActor(leftAnalog);
			stage.addActor(rightAnalog);
			stage.addActor(pickupButton);
			stage.addActor(weaponButton);
		}
		map = new Map();
		GameObjectManager.load();
		ItemManager.load();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.09f, 0.28f, 0.2f, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		npc.computeRotation((int) player.getX(), (int) player.getY());
		npc.act(player);

		camera.position.set((int) player.getX() + (int) player.getWidth() / 2, (int) player.getY() + (int) player.getHeight() / 2 - 14, 0);
		camera.update();
		game.batcher.setProjectionMatrix(camera.combined);

		game.batcher.disableBlending();
		game.batcher.begin();
		map.draw(game.batcher);
		game.batcher.end();

		game.batcher.enableBlending();
		game.batcher.begin();
		game.font.setScale(0.6f, 0.6f);
		game.font.draw(game.batcher, "X: " + player.getX() + "Y: " + player.getY(), player.getX() - 150, player.getY() + 200);

		for (GameObject gameObject : GameObjectManager.gameObjects) {
			gameObject.draw(game.batcher);
		}

		for (Item item : ItemManager.items) {
			item.draw(game.batcher);
		}

		npc.draw(game.batcher);
		player.draw(game.batcher);

		if (Gdx.app.getType() == ApplicationType.Android)
			updateActor.listen(leftAnalog, rightAnalog, pickupButton,weaponButton);
		else if (Gdx.app.getType() == ApplicationType.Desktop)
			updateActor.listen();

		game.batcher.end();

		GameObjectManager.radio.music.get(0).play(GameObjectManager.radio.position, player.getX(), player.getY());
		AssetsManager.zombie.play(npc.getX(), npc.getY(), player.getX(), player.getY());
		stage.act(Gdx.graphics.getDeltaTime());

		stage.draw();
	}
}