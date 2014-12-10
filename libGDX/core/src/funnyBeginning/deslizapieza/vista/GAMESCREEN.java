package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import funnyBeginning.deslizapieza.modelo.Figura;
import funnyBeginning.deslizapieza.modelo.MyGdxGame;
import funnyBeginning.deslizapieza.modelo.Personaje;
import funnyBeginning.deslizapieza.modelo.Salida;


public class GAMESCREEN extends PantallaAbstracta{
	
	private Figura personaje,salida;
	private int limite;
	private boolean salidaActiva,llegoMeta;//necesario?
	

	public GAMESCREEN(MyGdxGame juego) {
		super(juego);
	}
	
	@Override
	public void show() {
		// Creamos al personaje
		AtlasRegion personajeRegion= Assets.atlas.findRegion(Assets.PERSONAJE);
		//coordenadas para el personaje
		float posicionPersonajeX = 0;
		float posicionPersonajeY = this.juego.screenWidth - personajeRegion.getRegionWidth(); 
//		System.out.println(this.juego.screenHeight);
//		System.out.println(personajeRegion.getRegionHeight());
//		System.out.println();
//		System.out.println(posicionPersonajeY);
		//Ubicacion del personaje
		Vector2 posicionInicialPersonaje = new Vector2(posicionPersonajeX,posicionPersonajeY);
		personaje = new Personaje(posicionInicialPersonaje, personajeRegion);
		
		//Creamos la salida
		AtlasRegion salidaRegion= Assets.atlas.findRegion(Assets.SALIDA);
		//coordenadas para el personaje
		float posicionSalidaX = this.juego.screenHeight / 2 + salidaRegion.getRegionHeight() / 2;
		float posicionSalidaY = this.juego.screenWidth / 2 - salidaRegion.getRegionWidth() / 2;  
		//Ubicacion de la salida
		Vector2 posicionSalida = new Vector2(posicionSalidaX,posicionSalidaY);
		salida = new Salida(posicionSalida, salidaRegion);
		salidaActiva = true;
		//--------------------------------------------------------------------------------------------------------------------------------
		
		llegoMeta = false;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1); 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
		
		if(llegoMeta){ 
			renderllegoMeta();
		}else{
			renderJuegoNormal();
		}
		
	}
	
	private void renderJuegoNormal() {
		personaje.update(); 
		salida.update(); 
		
		comprobarSiFiguraLlegoMeta(); 
		
		
		//preparando bracher
		camera.update();
		batcher.setProjectionMatrix(camera.combined);
		batcher.enableBlending();
		
		//comenzando a dibujar
		batcher.begin();
		dibujarFondo(); 
		// Dibujamos al personaje
		personaje.draw(batcher);
		// Dibujamos la salida
		if(salidaActiva){ 
			salida.draw(batcher);
		}
		batcher.end(); 
	}

	private void dibujarFondo() {
		batcher.draw(Assets.juegoFondo, 0, 0, this.juego.screenHeight,this.juego.screenWidth);
	}

	private void comprobarSiFiguraLlegoMeta() {
		if(salidaActiva) { 
			if(personaje.llegoASalida(salida)) // Si choca
				ganar();
		}
		
	}

	private void ganar() {
		llegoMeta = true; // Se pierde la partida.
	
	}

	private void renderllegoMeta() {
		System.out.println("Ganaste :D");
	}

	@Override
	public void hide() { }
	
	@Override
	public void dispose() { }
	
}
