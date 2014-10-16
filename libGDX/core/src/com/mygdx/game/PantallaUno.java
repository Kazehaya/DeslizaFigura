package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
/*LOADING SCREEN*/
public class PantallaUno implements Screen{
	
	private boolean esPrimerIngreso;
	private static final int PANTALLA_DOS = 2;
	private static final int TIME_TO_WAIT=100;
	
	private  Game game;
	private OrthographicCamera camera;
	private int screenWidth;
	private int screenHeight;
	
	private int gameState;
	int state;

	private Rectangle gameOneButton;
	
	
	
	
	private SpriteBatch batcher;
	private Texture loadTexture;
	private float time;
	private boolean isLoad;
	private static final float SLEEP_TIME=2f;
	private static final String LOAD_FILE="imagenes/pantallasPrincipales/fondos/fondo2.png";//pantalla q carga datos
	
	
	
	public PantallaUno (MyGdxGame game){// Game game
		this.game = game;
		gameState = MyGdxGame.RUN_STATE;
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(screenHeight,screenWidth);
		camera.position.set(screenHeight/2,screenWidth/2,0);
		batcher = new SpriteBatch();
		loadTexture=new Texture(Gdx.files.internal(LOAD_FILE));
		time=0;
		isLoad=false;
	}
	private void draw(float delta){ //LISTO (?)
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batcher.setProjectionMatrix(camera.combined);
		
		batcher.enableBlending();
		
		batcher.begin();
		//Fondo
		batcher.draw(this.loadTexture,0,0, screenHeight, screenWidth);
		
		batcher.end();
		batcher.disableBlending();
	}
	private void update(float delta){//Listo
		time+=delta;
		if(!isLoad){
			isLoad=Assets.loadAssets();
		}
		if(time>=SLEEP_TIME && isLoad){
			game.setScreen(new PantallaDos(game));
		}
	}
	@Override
	public void render(float delta) { //Listo
		switch (gameState) {
		case MyGdxGame.RUN_STATE:
			this.update(delta);
			this.draw(delta);
			break;
		case MyGdxGame.PAUSE_STATE:
			break;
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
