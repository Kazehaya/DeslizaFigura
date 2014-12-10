package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import funnyBeginning.deslizapieza.vista.CREDITOSSCREEN;

public class BotonCreditos extends Boton{
	public BotonCreditos(float x, float y, AtlasRegion regionDelBoton) {
		super(x, y,regionDelBoton);
	}
	@Override
	protected void funcionamiento(MyGdxGame juego) {
		//Screens.juego.setScreen(Screens.GAMESCREEN); // Se asigna la pantalla de juego
		System.out.println("Presionaste Boton creditos");
		//juego.setScreen(new CREDITOSSCREEN(juego));
	}

}
