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
Método Create() : Es el método que se ejecuta cuando crea la actividad, el método donde debemos cargar las imágenes, sonidos y músicas en memoria para poder usarlas.

Método Dispose() : Método llamado al terminar la actividad, es el contrario al método Create y liberar el espacio de memoria que hemos usado en el método create, para ello podemos usar el método dispose() de cualquier clase Texture, Sound etc.

Método Render() ; Método cíclico que se ejecuta continuamente, este método será donde vamos a ir dibujando las imágenes y acciones.

Método Resize() : Se llama al cargar una pantalla, más adelante lo usaremos para más cosas.

Método Pause(): Cuando recibes una llamada, o tu teléfono te obliga a parar lo que estés haciendo se llama al método Pause().

Método Resume(): Se llama al volver al juego desde el método Pause().
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








