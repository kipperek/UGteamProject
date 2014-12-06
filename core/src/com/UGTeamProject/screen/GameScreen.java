package com.UGTeamProject.screen;

import box2dLight.RayHandler;

import com.UGTeamProject.game.GameManager;
import com.UGTeamProject.prefab.adapters.Physics;
import com.UGTeamProject.prefab.adapters.Physics.MOBILITY_TYPE;
import com.UGTeamProject.prefab.adapters.Physics.PHYSICS_TYPE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen extends ScreenAdapter {

	OrthographicCamera camera;
    GameManager game;
    
    Matrix4 debugMatrix;
    RayHandler raysHandler;
    Box2DDebugRenderer physicsDebuger;
    World physics;
    
    Physics circle;
    Physics edge;
    Physics polygon;
    Physics rectangle;
    
    public GameScreen (GameManager game) {
    	this.game = game;	
    	camera = new OrthographicCamera(800, 600);
    	camera.setToOrtho(false, 400, 300);
    	
    	physics = new World(new Vector2(0, Physics.GRAVITY), false);
    	
    	physicsDebuger = new Box2DDebugRenderer();
    	
    	debugMatrix = camera.combined.cpy().scale(Physics.PIXELS_TO_METERS, Physics.PIXELS_TO_METERS, 0);
    	
    	raysHandler = new RayHandler(physics);
    	raysHandler.setCombinedMatrix(camera.combined.cpy().scale(Physics.PIXELS_TO_METERS, Physics.PIXELS_TO_METERS, 0));
    	
    	circle = new Physics(physics, Physics.PHYSICS_TYPE.NORMAL, Physics.MOBILITY_TYPE.PROP, new Float(2f), 2000f, 0.2f, 0.8f, 10f, new Vector2(200, 150));
    	Vector2 points[] = { new Vector2(20, 10), new Vector2(30, 20), new Vector2(40, 10) };
    	edge = new Physics(physics, Physics.PHYSICS_TYPE.NORMAL, Physics.MOBILITY_TYPE.WALL, new Float(0f), 2000f, 0.2f, 0.8f, new Vector2(-30,0), points, new Vector2(80,0), new Vector2(180, 100), new Vector2(5,0));
    	polygon = new Physics(physics, Physics.PHYSICS_TYPE.NORMAL, Physics.MOBILITY_TYPE.PROP, new Float(2f), 2000f, 0.2f, 0.8f, points, new Vector2(160, 150), new Vector2(5,0));
    	rectangle = new Physics(physics, Physics.PHYSICS_TYPE.NORMAL, Physics.MOBILITY_TYPE.WALL, new Float(0f), 10000f, 1f, 0f, 800, 10, new Vector2(0,0));
    }
	
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		game.batcher.begin();
		game.font.draw(game.batcher, "CIEMNOSC!", 333, 333);
		game.batcher.end();
		
		raysHandler.updateAndRender();
		physicsDebuger.render(physics, debugMatrix);
		physics.step(1/60f, 6, 2);
	}
}