package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import funnyBeginning.deslizapieza.vista.GAMESCREEN;
import funnyBeginning.deslizapieza.vista.MAINSCREEN;


public class BotonAtras extends Boton {

	public BotonAtras(float x, float y, AtlasRegion regionDelBoton) {
		super(x, y, regionDelBoton);
		
	}

	@Override
	protected void funcionamiento(MyGdxGame juego) {
		//System.out.println("Presionaste Boton Atras");
		juego.setScreen(new MAINSCREEN(juego));

	}

}
