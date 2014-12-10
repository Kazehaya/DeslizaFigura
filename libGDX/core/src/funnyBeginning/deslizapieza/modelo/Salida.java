package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class Salida extends Figura{

	public Salida(Vector2 posicionSalida, AtlasRegion salidaRegion) { 
		super(posicionSalida, salidaRegion);
	}

	@Override
	public void update() {
		posicion.y = posicion.y ; // Se mueven hacia arriba en la pantalla
		
		// Actualizamos los bordes en el eje y, ya que las rocas solo se mueven en esa dirección.
		bordes.y = posicion.y;
		
	}

}
