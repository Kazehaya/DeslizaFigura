package funnyBeginning.deslizapieza.modelo;


import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import funnyBeginning.deslizapieza.vista.GAMESCREEN;

public class BotonJugar extends Boton{
	public BotonJugar(float x, float y, AtlasRegion regionDelBoton) {
		super(x, y, regionDelBoton);
	}
	@Override
	protected void funcionamiento(MyGdxGame juego) {
		//Screens.juego.setScreen(Screens.GAMESCREEN); // Se asigna la pantalla de juego
		//System.out.println("Presionaste Boton jugar");
		juego.setScreen(new GAMESCREEN(juego));
	}
}
