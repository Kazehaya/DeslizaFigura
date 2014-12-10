package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import funnyBeginning.deslizapieza.modelo.Boton;
import funnyBeginning.deslizapieza.modelo.BotonAtras;
import funnyBeginning.deslizapieza.modelo.MyGdxGame;


public class CREDITOSSCREEN extends PantallaAbstracta{
	
	private Boton atras;

	public CREDITOSSCREEN(MyGdxGame juego) {
		super(juego);
	}
	@Override
	public void show() {
		AtlasRegion atlasRegion= Assets.atlas.findRegion(Assets.BOTON_ATRAS);
		
		int nuevaAnchura= atlasRegion.getRegionWidth()/2;
		float centroX = this.juego.screenHeight/2 - nuevaAnchura/2;
		float centroY = this.juego.screenWidth/2 - atlasRegion.getRegionHeight()/2;
		
		atras = new BotonAtras(centroX,centroY,atlasRegion);
	}
	
	@Override
	public void render(float delta) {
		//limpiar pantalla
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		atras.update(this.juego);
		
		
		
		camera.update();
		//preparando bracher
		batcher.setProjectionMatrix(camera.combined);
		batcher.enableBlending();
		//comenzando a dibujar
		batcher.begin();
		drawMenu(delta);//dibuja mi fondo
		
		
		//Lanueva anchura se pone porque si no el boton queda muuuy alargado
//		int nuevaAnchura= Assets.atlas.findRegion(Assets.BOTON_ATRAS).getRegionWidth()/2;
//		batcher.draw(Assets.atlas.findRegion(Assets.BOTON_ATRAS),
//				this.juego.screenHeight/2 - nuevaAnchura/2,//X
//				0, //Y
//				nuevaAnchura,
//				Assets.atlas.findRegion(Assets.BOTON_ATRAS).getRegionHeight());
		atras.draw(batcher);
		
		
		
		
		
		batcher.end();
		batcher.disableBlending();
	}
	
	private void drawMenu(float delta){
		batcher.draw(Assets.creditosMenu, 0, 0, this.juego.screenHeight, this.juego.screenWidth);
	}
}
