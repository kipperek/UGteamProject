package com.UGTeamProject.game;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class GameManager extends ApplicationAdapter {

	final static int ZOOM = 5;
	
    OrthographicCamera camera;
    int width, height;
    
    World physics;
    
    Box2DDebugRenderer physicsDebuger;
    
    RayHandler raysHandler;
    
	@Override
	public void create () {
	    width = 1280 / ZOOM;
	    height = 760 / ZOOM;
	    
	    camera = new OrthographicCamera(width, height);
	    camera.position.set(new Vector3(0, 0, 0));
	    
	    physics = new World(new Vector2(0, -9.8f), false);
	    
	    physicsDebuger = new Box2DDebugRenderer();
	    
	    BodyDef circleDef = new BodyDef();
	    circleDef.type = BodyType.DynamicBody;
	    circleDef.position.set(new Vector2(0, height/2));
	    
	    Body circle = physics.createBody(circleDef);
	    
	    CircleShape circleShape = new CircleShape();
	    circleShape.setRadius(10f);
	    
	    FixtureDef circleFixture = new FixtureDef();
	    circleFixture.shape = circleShape;
	    circleFixture.density = 1000f;
	    circleFixture.friction = 0.2f;
	    circleFixture.restitution = 0.8f;
	    
	    circle.createFixture(circleFixture);
	    
	    BodyDef groundDef = new BodyDef();
	    groundDef.position.set(0, -(height/2));
	    Body ground = physics.createBody(groundDef);
	    
	    PolygonShape groundShape = new PolygonShape();
	    
	    groundShape.setAsBox((camera.viewportWidth) * 2, 3.0f);
	    ground.createFixture(groundShape, 0.0f);
	    
	    raysHandler = new RayHandler(physics);
	    raysHandler.setCombinedMatrix(camera.combined);
	    
	    new PointLight(raysHandler, 3600, Color.WHITE, 200, 0, 0);
	    new PointLight(raysHandler, 3600, Color.RED, 200, 100, 0);
	    new PointLight(raysHandler, 3600, Color.BLUE, 200, -100, 0);
	}
	
	@Override
	public void dispose(){
	    physics.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		physicsDebuger.render(physics, camera.combined);
		raysHandler.updateAndRender();
		
		physics.step(1/30f, 6, 2);
		
	}
}