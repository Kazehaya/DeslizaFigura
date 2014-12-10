package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Figura {
	public static final float SPEED = 400;
	protected Vector2 posicion;
	protected float anchura,altura;
	protected Rectangle bordes; // Objeto que nos determinará la posición de la figura y permite detectar colisiones con otros rectangulos.
	protected Texture texture;
	public AtlasRegion figuraRegion;
	
	public Figura(Vector2 posicionInicial,AtlasRegion figuraRegion) { 
		this.figuraRegion = figuraRegion;
		this.posicion = posicionInicial;
		//modificar!!!
		this.bordes = new Rectangle(posicion.x, posicion.y, this.figuraRegion.getRegionWidth(), this.figuraRegion.getRegionHeight());
		
		//creo q no son necesarios
		this.anchura = this.figuraRegion.getRegionWidth();
		this.altura = this.figuraRegion.getRegionHeight();
		
	}
	public void draw(SpriteBatch batch) { 
		batch.draw(this.figuraRegion,bordes.x, bordes.y, bordes.width, bordes.height);
	}
	
	public abstract void update(); 
	
	
	
	
	// Getters -----------------------------------

	public Vector2 getPosicion() {
		return posicion;
	}

	public float getAnchura() {
		return anchura;
	}

	public float getAltura() {
		return altura;
	}

	public Rectangle getBordes() {
		return bordes;
	}
	public boolean llegoASalida(Figura salida) {
		return bordes.overlaps(salida.getBordes());
	}

	
	
}
