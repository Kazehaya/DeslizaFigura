package funnyBeginning.deslizapieza.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Personaje extends Figura{
	
	private static final float SPEED = 10; 
	private static final float LIMITE_IZQUIERDA = 0; 
	private static final float LIMITE_DERECHA = Gdx.graphics.getHeight(); 
	private static final float LIMITE_INFERIOR = 0;
	private static final float LIMITE_SUPERIOR = Gdx.graphics.getWidth();

	public Personaje(Vector2 posicionInicialPersonaje,AtlasRegion personajeRegion) {
		super(posicionInicialPersonaje, personajeRegion);
	}

	@Override
	public void update() {
		if(Gdx.app.getType() == ApplicationType.Desktop) // Si estamos jugando en nuestro ordenador
			entradaDesktop();
		else if(Gdx.app.getType() == ApplicationType.Android) // Si se esta ejecutando en android
			entradaAndroid();
		
		// Actualizamos los bordes (la anchura y altura ya se definen en el constructor de Entidad
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}

	private void entradaAndroid() {
		//System.out.print("Estas en Android");
		 // Al mover el movil hacia la derecha el valor es positivo. Si esta mas inclinado se mueve mas rapido
        if (Gdx.input.getAccelerometerY() > 0.75) {
        	float nuevaPosicion = posicion.x + Math.abs(Gdx.input.getAccelerometerY()) * SPEED; // La nueva posicion del pingüino.
        	if(noChoqueConLimiteDerecho(nuevaPosicion)) // Si la nueva posición es menor que el límite derecho.
        		posicion.x = nuevaPosicion;
        	else
        		posicion.x = LIMITE_DERECHA - anchura;
        }
        // Al mover el movil hacia la izquierda el valor es negativo. Si está más inclinado se mueve más rápido.           
        if (Gdx.input.getAccelerometerY() < -0.75) {
        	float nuevaPosicion = posicion.x - Math.abs(Gdx.input.getAccelerometerY()) * SPEED; // La nueva posición del pingüino.
        	if(noChoqueConLimiteIzquierdo(nuevaPosicion)) // Si la nueva posición es menor que el límite izquierdo.
        		posicion.x = nuevaPosicion; 
        	else
        		posicion.x = LIMITE_IZQUIERDA;
        } 
        //Arriba abajo
        if (Gdx.input.getAccelerometerX() < 0.75) {
        	float nuevaPosicion = posicion.y + Math.abs(Gdx.input.getAccelerometerX()) * SPEED; // La nueva posición del pingüino.
        	if(noChoqueConLimiteSuperior(nuevaPosicion)) // Si la nueva posición es menor que el límite derecho.
        		posicion.y = nuevaPosicion;
        	else
        		posicion.y = LIMITE_SUPERIOR - altura;
        }
        // Al mover el movil hacia la izquierda el valor es negativo. Si está más inclinado se mueve más rápido.           
        if (Gdx.input.getAccelerometerX() > -0.75) {
        	float nuevaPosicion = posicion.y - Math.abs(Gdx.input.getAccelerometerX()) * SPEED; // La nueva posición del pingüino.
        	if(noChoqueConLimiteInferior(nuevaPosicion)) // Si la nueva posición es menor que el límite izquierdo.
        		posicion.y = nuevaPosicion; 
        	else
        		posicion.y = LIMITE_INFERIOR;
        }
		
	}
	
	private void entradaDesktop() {
		//System.out.print("Estas en escritorio");
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) { // Si presionamos la tecla derecha
			float nuevaPosicion = posicion.x + SPEED; // a la posicion en x le sumo la velocidad que hemos determinado por SPEED.
			if(noChoqueConLimiteDerecho(nuevaPosicion)) // Si no choca con el limite derecho.
				posicion.x = nuevaPosicion;
			else
				posicion.x = LIMITE_DERECHA - anchura;
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) { // Si presionamos la tecla izquierda.
			float nuevaPosicion = posicion.x - SPEED; // lo mismo pero restandole, ya que vamos a la izquierda
			if(noChoqueConLimiteIzquierdo(nuevaPosicion)) // Si no choca con el limite izquierdo.
				posicion.x = nuevaPosicion;
			else
				posicion.x = LIMITE_IZQUIERDA;
		}
		
	}

	private boolean noChoqueConLimiteDerecho(float nuevaPosicion) {
		return nuevaPosicion + anchura < LIMITE_DERECHA;
	}
	
	private boolean noChoqueConLimiteIzquierdo(float nuevaPosicion) {
		return nuevaPosicion > LIMITE_IZQUIERDA;
	}
	
	private boolean noChoqueConLimiteInferior(float nuevaPosicion) {
		return nuevaPosicion > LIMITE_INFERIOR;
	}

	private boolean noChoqueConLimiteSuperior(float nuevaPosicion) {
		return nuevaPosicion + altura < LIMITE_SUPERIOR;
	}

	public void setPosicion(float x, float y) { // Asigna nueva posición al pingüino.
		posicion.x = x;
		posicion.y = y;
	}
	
	
}
