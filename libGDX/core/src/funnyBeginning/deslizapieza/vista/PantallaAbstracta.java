package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import funnyBeginning.deslizapieza.modelo.MyGdxGame;

public class PantallaAbstracta  implements Screen{
	protected MyGdxGame juego;
	protected boolean esPrimerIngreso;
	protected final static int TIME_TO_WAIT = 100;
	protected OrthographicCamera camera;
	protected SpriteBatch batcher;
	protected int gameState;
	
	
	public PantallaAbstracta(MyGdxGame juego) {
		this.juego = juego;
		gameState = this.juego.RUN_STATE;
		esPrimerIngreso=true;
		camera = new OrthographicCamera(juego.screenHeight,this.juego.screenWidth);
		camera.position.set(this.juego.screenHeight/2,this.juego.screenWidth/2,0);
		batcher = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
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
