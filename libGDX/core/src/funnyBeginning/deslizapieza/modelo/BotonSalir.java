package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import funnyBeginning.deslizapieza.vista.EXITSCREEN;

public class BotonSalir extends Boton{
	public BotonSalir(float x, float y, AtlasRegion regionDelBoton) {
		super(x, y,regionDelBoton);
	}
	@Override
	protected void funcionamiento(MyGdxGame juego) {
		//Screens.juego.setScreen(Screens.GAMESCREEN); // Se asigna la pantalla de juego
		System.out.println("Presionaste Boton salir");
		//juego.setScreen(new EXITSCREEN(juego));
		Gdx.app.exit();
	}
}
