package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public abstract class Boton {
	
	protected Rectangle bordes; // El rectangulo que establece la posición, altura y anchura del botón
	protected float xMinima; // Estos atributos sirven para poner las coordenadas para pulsar el botón.
	protected float yMinima;
	protected float xMaxima;
	protected float yMaxima;
	//region del atlas
	AtlasRegion regionDelBoton;
	
	public Boton(float x, float y,  AtlasRegion regionDelBoton) {
		this.regionDelBoton = regionDelBoton;
		int anchura = this.regionDelBoton.getRegionWidth()/2;
		int altura = this.regionDelBoton.getRegionHeight();
		this.bordes = new Rectangle(x, y, anchura, altura);
//		
//		int cont =1 ;
//		if(cont ==1){
//			System.out.println(bordes.x);
//			System.out.println(bordes.y);
//			System.out.println(Gdx.graphics.getWidth());
//			System.out.println(Gdx.graphics.getHeight());
//		}
//		cont++;
		// Permite asignar los bordes del botón para su correcto funcionamiento.
//		this.xMinima = bordes.x ;
//		this.xMaxima = bordes.x + bordes.width;
//		this.yMinima = bordes.y;
//		this.yMaxima = bordes.y + bordes.height;
		
//		xMinima = 0;
//		xMaxima = 152;
//		yMinima =  0 ;
//		yMaxima = 86;
//		
//		
		
		
        
       
		this.xMinima = bordes.x + 50;
		this.xMaxima = bordes.x + (bordes.width + 110);
		this.yMinima = Gdx.graphics.getHeight() - ((bordes.y )+ bordes.height - 75);
		this.yMaxima = Gdx.graphics.getHeight() - (bordes.y  - 55);
	}
	public void draw(SpriteBatch batcher) {
		batcher.draw(this.regionDelBoton,bordes.x, bordes.y, bordes.width, bordes.height);
//		ShapeRenderer sr = new ShapeRenderer();
//		sr.begin(ShapeType.Filled);
//        sr.setColor(Color.BLUE);
//        sr.rect(164, 227, this.xMaxima, this.yMaxima);
//        sr.end();
	}
	public void update(MyGdxGame juego) {
		if(sePulsaElBoton())
			funcionamiento(juego);
	}
	private boolean sePulsaElBoton() { // Esta función privada sirve para comprobar si se pulsa el botón.
		return Gdx.input.isTouched() && 
				((Gdx.input.getX() >= xMinima && Gdx.input.getX() <= xMaxima) && // Devuelve true si se pulsa dentro de los límites
				 (Gdx.input.getY() >= yMinima && Gdx.input.getY() <= yMaxima));
	}
	protected abstract void funcionamiento(MyGdxGame juego); // Método que implementarán las clases hijas y contendrá el comportamiento deseado
	// Getters and Setters ------------------------------------------------------------------------
	public Rectangle getBordes() {
		return bordes;
	}
	public void setBordes(Rectangle bordes) {
		this.bordes = bordes;
	}
}
