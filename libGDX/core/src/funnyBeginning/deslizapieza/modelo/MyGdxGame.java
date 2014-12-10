package funnyBeginning.deslizapieza.modelo;
/*
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;//En cargado de dibujar en 
					  //pantalla las diferentes imagenes
	Texture img; // Este objeto carga una imagen ya sea
				// png o jpg
	
	
	/*
	En el core podemos utilizar 6 metodos distintos
M�todo Create() : Es el m�todo que se ejecuta cuando crea la actividad, el m�todo donde debemos cargar las im�genes, sonidos y m�sicas en memoria para poder usarlas.

M�todo Dispose() : M�todo llamado al terminar la actividad, es el contrario al m�todo Create y liberar el espacio de memoria que hemos usado en el m�todo create, para ello podemos usar el m�todo dispose() de cualquier clase Texture, Sound etc.

M�todo Render() ; M�todo c�clico que se ejecuta continuamente, este m�todo ser� donde vamos a ir dibujando las im�genes y acciones.

M�todo Resize() : Se llama al cargar una pantalla, m�s adelante lo usaremos para m�s cosas.

M�todo Pause(): Cuando recibes una llamada, o tu tel�fono te obliga a parar lo que est�s haciendo se llama al m�todo Pause().

M�todo Resume(): Se llama al volver al juego desde el m�todo Pause().
	//
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
*/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import funnyBeginning.deslizapieza.vista.Assets;
import funnyBeginning.deslizapieza.vista.LOADINGSCREEN;

public class MyGdxGame extends Game{
	public static final int RUN_STATE = 1;
	public static final int PAUSE_STATE = 0;
	public float screenWidth;
	public float screenHeight;
	@Override
	public void create(){
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		setScreen(new LOADINGSCREEN(this));
		Gdx.input.setCatchBackKey(true);
	}
	
	@Override
	public void render(){
		super.render();
	}
	
	@Override
	public void dispose(){
		super.dispose();
		getScreen().dispose();
		Assets.dispose();
	}
}








