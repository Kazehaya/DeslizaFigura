package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import funnyBeginning.deslizapieza.modelo.MyGdxGame;

public class EXITSCREEN extends PantallaAbstracta{

	public EXITSCREEN(MyGdxGame juego) {
		super(juego);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void show() {
		
		
	}
	
	@Override
	public void render(float delta) {
		//limpiar pantalla
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		
		
		camera.update();
		//preparando bracher
		batcher.setProjectionMatrix(camera.combined);
		batcher.enableBlending();
		//comenzando a dibujar
		batcher.begin();
		drawMenu(delta);//dibuja mi fondo

		batcher.end();
		batcher.disableBlending();
	}
	
	private void drawMenu(float delta){
		//batcher.draw(Assets.exitMenu, 0, 0, this.juego.screenHeight, this.juego.screenWidth);
	}

}
