package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import funnyBeginning.deslizapieza.modelo.Boton;
import funnyBeginning.deslizapieza.modelo.BotonCreditos;
import funnyBeginning.deslizapieza.modelo.BotonJugar;
import funnyBeginning.deslizapieza.modelo.BotonSalir;
import funnyBeginning.deslizapieza.modelo.MyGdxGame;


/*MAINSCREEN*/
public class MAINSCREEN extends PantallaAbstracta{

	private Vector3 touchPoint;
	int state;
	private int updateElapsed;
	private Rectangle botonInicioJuego;
	private Boton jugar;
	private Boton creditos;
	private Boton salir;
	
	public MAINSCREEN (MyGdxGame game){
		super(game);
		updateElapsed=0;
	}
	private void update(float delta){
		if(Gdx.input.isKeyPressed(Keys.BACK) && !esPrimerIngreso){
			//game.setScreen(new ExitScreen(game));
		}
	}
	
	@Override
	public void show() {
		AtlasRegion atlasRegion= Assets.atlas.findRegion(Assets.BOTON_JUGAR);
		//coordenadas para centrar el boton
		int nuevaAnchura= atlasRegion.getRegionWidth()/2;
		float centroX = this.juego.screenHeight / 2 - nuevaAnchura / 2; // Centro en el eje x de la pantalla centrando el botón
		float centroY = this.juego.screenWidth / 2 - atlasRegion.getRegionHeight() / 2; // Centro en el eje y de la pantalla centrando el botón
		
		//Ubicacion del boton jugar arriba de todo y la region la cual coresponde de nuestro atlas(nos servira despues para dibujar )
		jugar = new BotonJugar(centroX, centroY + 50,Assets.atlas.findRegion(Assets.BOTON_JUGAR));
		creditos = new BotonCreditos(centroX, centroY - 50,Assets.atlas.findRegion(Assets.BOTON_CREDITOS));
		salir = new BotonSalir(centroX, centroY - 150,Assets.atlas.findRegion(Assets.BOTON_SALIR));
		
	}
	
	@Override
	public void render(float delta) {
		//limpiar pantalla
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		jugar.update(this.juego);
		creditos.update(this.juego);
		salir.update(this.juego);
		
		
		//preparando bracher
		camera.update();
		batcher.setProjectionMatrix(camera.combined);
		batcher.enableBlending();
		//comenzando a dibujar
		batcher.begin();
		drawMenu(delta);//dibuja mi fondo

		jugar.draw(batcher);
		creditos.draw(batcher);
		salir.draw(batcher);
		batcher.end();
		batcher.disableBlending();
	}
	
	private void drawMenu(float delta){
		batcher.draw(Assets.mainMenu, 0, 0, this.juego.screenHeight, this.juego.screenWidth);
	}



}
