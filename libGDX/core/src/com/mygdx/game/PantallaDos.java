package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/*MAINSCREEN*/
public class PantallaDos implements Screen{
	private boolean isFirstTime;
	private final int screenWidth;
	private final int screenHeight;
	private static final int TIME_TO_WAIT=100;
	private Game game;
	private OrthographicCamera camera;
	private SpriteBatch batcher;
	private Vector3 touchPoint;
	int state;
	private int updateElapsed;
	private int gameState;
	private Rectangle botonInicioJuego;
	
	public PantallaDos (Game game){
		this.game = game;
		updateElapsed=0;
		gameState = MyGdxGame.RUN_STATE;
		isFirstTime=true;
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(screenHeight,screenWidth);
		camera.position.set(screenHeight/2,screenWidth/2,0);
		batcher = new SpriteBatch();
		touchPoint = new Vector3();
	}
	
//	private void update(float delta){
////		updateMenu(delta);
////		if(Gdx.input.isKeyPressed(Keys.BACK) && !isFirstTime){
////			game.setScreen(new ExitScreen(game));
////		}
//	}

	private void update(float delta){
		updateMenu(delta);
		if(Gdx.input.isKeyPressed(Keys.BACK) && !isFirstTime){
			//game.setScreen(new ExitScreen(game));
		}
	}
	
	private void updateMenu(float delta){
		if(Gdx.input.justTouched()){
			touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0);
			camera.unproject(touchPoint);
			
			boolean rectanguloEnBotonInicio = Superposicion.puntoEnRectangulo(botonInicioJuego, touchPoint.x,touchPoint.y);
			if(rectanguloEnBotonInicio){
//				//Reproducir sonido
//				Assets.playSound(Assets.pushButtonSound);
//				shareButton = new Rectangle();
//				exitButton = new Rectangle();
//				shareButton = new Rectangle();
//				this.state=SELECTION_STATE;//ahora es igual a iniciar??
//				return;
			}
			
			
					
//					if(Superposicion.pointInRectangle(showCreditsButton, touchPoint.x,touchPoint.y)){//Rectangle Creditos
//						if (this.state != SELECTION_STATE) {
//							//Reproducir sonido
//							Assets.playSound(Assets.pushButtonSound);
//							game.setScreen(new CreditsScreen(game));
//							return;
//						}
//					}
//					
//					if(Superposicion.pointInRectangle(exitButton, touchPoint.x,touchPoint.y)){
//						if (this.state != SELECTION_STATE) {
//							//Reproducir sonido
//							Assets.playSound(Assets.pushButtonSound);
//							//estado = ESTADO_SALIR;
//							game.setScreen(new ExitScreen(game));
//							return;
//						}
//					}
//					
//					if(Superposicion.pointInRectangle(instructionsButton, touchPoint.x,touchPoint.y)){
//						if (this.state != SELECTION_STATE) {
//							//Reproducir sonido
//							Assets.playSound(Assets.pushButtonSound);
//							//estado = ESTADO_SALIR;
//							game.setScreen(new InstructionsScreen(game));
//							return;
//						}
//					}
//					
//					if(Superposicion.pointInRectangle(shareButton, touchPoint.x,touchPoint.y)){
//						Assets.playSound(Assets.pushButtonSound);
//						Gdx.net.openURI(SHARING_FACEBOOK_LINK);
//						return;
//					}
//					
//				
//
//				if(this.state==SELECTION_STATE){
//					Preferences prefs = Gdx.app.getPreferences("Game");
//					if(Superposicion.pointInRectangle(gameOneButton, touchPoint.x,touchPoint.y)){
//						Preferences garagePrefs = Gdx.app.getPreferences("Garage Preferences 1");
//						prefs.putInteger("Current Game", 0);
//						garagePrefs.putString("Current Car", "DEFAULT");
//						garagePrefs.flush();
//						prefs.flush();
//						Assets.playSound(Assets.pushButtonSound);
//						Assets.pump.stop();
//						game.setScreen(new GameScreen(game));
//						return;
//					}
//					if(Superposicion.pointInRectangle(gameTwoButton, touchPoint.x,touchPoint.y)){
//						Preferences garagePrefs = Gdx.app.getPreferences("Garage Preferences 2");
//						prefs.putInteger("Current Game", 1);
//						garagePrefs.putString("Current Car", "DEFAULT");
//						garagePrefs.flush();
//						prefs.flush();
//						Assets.playSound(Assets.pushButtonSound);
//						Assets.pump.stop();
//						game.setScreen(new GameScreen(game));
//						return;
//					}
//					if(Superposicion.pointInRectangle(gameThreeButton, touchPoint.x,touchPoint.y)){
//						Preferences garagePrefs = Gdx.app.getPreferences("Garage Preferences 3");
//						prefs.putInteger("Current Game", 2);
//						garagePrefs.putString("Current Car", "DEFAULT");
//						garagePrefs.flush();
//						prefs.flush();
//						Assets.playSound(Assets.pushButtonSound);
//						Assets.pump.stop();
//						game.setScreen(new GameScreen(game));
//						return;
//					}
//					
//				}
		}
	}

	
	private void draw(float delta){
		//limpar pantalla
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		batcher.setProjectionMatrix(camera.combined);
		batcher.enableBlending();
		batcher.begin();
		
		drawMenu(delta);//dibuja mi fondo
		
		//Dibuja botones y demas de esta pantalla
			//...Texture region,coordenada1,coordenada2,ALTO,ANCHO
		batcher.draw(Assets.atlas.findRegion(Assets.BOTON_JUGAR),screenHeight/2.4f, screenWidth/2.4f, screenHeight * .15f, screenWidth * .12f);
		batcher.draw(Assets.atlas.findRegion(Assets.BOTON_CREDITOS),screenHeight/2.4f , screenWidth/3.4f, screenHeight * .15f, screenWidth * .12f);
		batcher.draw(Assets.atlas.findRegion(Assets.BOTON_SALIR),screenHeight/2.4f, screenWidth/5.8f, screenHeight*.15f, screenWidth*.12f);
		
		
		batcher.end();
		batcher.disableBlending();
	}
	
	private void drawMenu(float delta){
		batcher.draw(Assets.mainMenu, 0, 0, screenHeight, screenWidth);
	}
	
	@Override
	public void render(float delta) {
		switch (gameState) {
		case MyGdxGame.RUN_STATE:
			update(delta);
			draw(delta);
			if(updateElapsed>TIME_TO_WAIT)
				isFirstTime=false;
			updateElapsed++;
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
		this.gameState = MyGdxGame.PAUSE_STATE;
		
	}

	@Override
	public void resume() {
		this.gameState = MyGdxGame.RUN_STATE;
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
