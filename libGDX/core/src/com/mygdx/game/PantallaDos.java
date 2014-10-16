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
	
	private void update(float delta){
//		updateMenu(delta);
//		if(Gdx.input.isKeyPressed(Keys.BACK) && !isFirstTime){
//			game.setScreen(new ExitScreen(game));
//		}
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
