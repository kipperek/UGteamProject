package com.UGTeamProject.game;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class GameManager extends ApplicationAdapter {

	final static int ZOOM = 1;
	final static float PIXELS_TO_METERS = 100f;
	
    int width, height;
	
    OrthographicCamera camera;
    SpriteBatch batch;
    Matrix4 debugMatrix;
    
    World physics;
    
    Box2DDebugRenderer physicsDebuger;
    
    RayHandler raysHandler;
    
    FPSLogger fpsLogger;
    
	@Override
	public void create () {
	    width =  1280 / ZOOM;
	    height = 768 / ZOOM;
	    
	    batch = new SpriteBatch();
	    
	    camera = new OrthographicCamera(width, height);
	    
	    physics = new World(new Vector2(0, -9.8f), false);
	    
	    physicsDebuger = new Box2DDebugRenderer();
	    
	    fpsLogger = new FPSLogger();
	    
	    BodyDef circleDef = new BodyDef();
	    circleDef.type = BodyType.DynamicBody;
	    circleDef.position.set(new Vector2(0, height/2 / PIXELS_TO_METERS));
	    
	    Body circle = physics.createBody(circleDef);
	    
	    CircleShape circleShape = new CircleShape();
	    circleShape.setRadius(1f );
	    
	    FixtureDef circleFixture = new FixtureDef();
	    circleFixture.shape = circleShape;
	    circleFixture.density = 2000f;
	    circleFixture.friction = 0.2f;
	    circleFixture.restitution = 0.8f;
	    
	    circle.createFixture(circleFixture);
	    
	    BodyDef groundDef = new BodyDef();
	    groundDef.position.set(0, -(height/2) / PIXELS_TO_METERS);
	    Body ground = physics.createBody(groundDef);
	    
	    PolygonShape groundShape = new PolygonShape();
	    
	    groundShape.setAsBox((camera.viewportWidth) * 2 / PIXELS_TO_METERS, 3.0f / PIXELS_TO_METERS);
	    ground.createFixture(groundShape, 0.0f);
	    
	    raysHandler = new RayHandler(physics);
	    
	    new PointLight(raysHandler, 3600, Color.WHITE, 7.68f, 0, 0).setSoft(false);
	}
	
	@Override
	public void dispose(){
	    physics.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		batch.end();
				
		//fpsLogger.log();
		
        debugMatrix = camera.combined.cpy().scale(PIXELS_TO_METERS, PIXELS_TO_METERS, 0);
        
        raysHandler.setCombinedMatrix(camera.combined.cpy().scale(PIXELS_TO_METERS, PIXELS_TO_METERS, 0));
		
        physicsDebuger.render(physics, debugMatrix);
		raysHandler.updateAndRender();
		
		physics.step(1/60f, 8, 4);
	}
}