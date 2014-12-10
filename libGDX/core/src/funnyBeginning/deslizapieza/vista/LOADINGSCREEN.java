package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import funnyBeginning.deslizapieza.modelo.MyGdxGame;

/*LOADINGSCREEN*/
public class LOADINGSCREEN extends PantallaAbstracta{
	private static final int PANTALLA_DOS = 2;
	private int juegoState;
	int state;
	private Rectangle juegoOneButton;
	private SpriteBatch batcher;
	private Texture loadTexture;
	private float time;
	private boolean isLoad;
	private static final float SLEEP_TIME=2f;
	private static final String LOAD_FILE="imagenes/pantallasPrincipales/fondos/FondoCargando.png";//pantalla q carga datos
	
	
	public LOADINGSCREEN (MyGdxGame juego){// juego juego
		super(juego);
		
		juegoState = MyGdxGame.RUN_STATE;
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
		batcher.draw(this.loadTexture,0,0, juego.screenHeight, juego.screenWidth);
		
		batcher.end();
		batcher.disableBlending();
	}
	private void update(float delta){//Listo
		time+=delta;
		if(!isLoad){
			isLoad=Assets.loadAssets();
		}
		if(time>=SLEEP_TIME && isLoad){
			juego.setScreen(new MAINSCREEN(juego));
		}
	}
	@Override
	public void render(float delta) { //Listo
		switch (juegoState) {
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
