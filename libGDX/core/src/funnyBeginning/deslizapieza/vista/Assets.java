package funnyBeginning.deslizapieza.vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

	
	//Fondos de pantalla
	public static Texture mainMenu;
	private static final String BACKGROUND_PRINCIPAL = "imagenes/pantallasPrincipales/fondos/FondoMenuPrincipal.png";
	
	public static Texture creditosMenu;
	private static final String BACKGROUND_CREDITOS = "imagenes/pantallasPrincipales/fondos/FondoCreditos.png";
	
	public static Texture juegoFondo;
	private static final String BACKGROUND_JUEGO = "imagenes/pantallasPrincipales/fondos/FondoJuego.png";
	
	
	
	//Atlas
	public static final String ATLAS = "atlas.atlas";
	public static TextureAtlas atlas;
	
	//Regiones del atlas que se pueden pintar, solo basta con el nombre ya que anteriormente se cargo su ubicacion en el archivo atlas.atlas
	//MAINSCREAN
	public static final String BOTON_JUGAR = "PantallaPrincipalBotonJugar" ;
	public static final String BOTON_CREDITOS = "PantallaPrincipalBotonCreditos";
	public static final String BOTON_SALIR = "PantallaPrincipalBotonSalir";
	
	//GAMESCREEN
	public static final String PERSONAJE = "Estrella";
	public static final String SALIDA = "EstrellaSalida";
	
	//EXITSCREEN
	public static final String BOTON_ATRAS = "PantallaPrincipalBotonAtras";
	
	public static Texture loadTexture(String file){
		return new Texture (Gdx.files.internal(file));
	}
	
	public static TextureAtlas loadAtlas(String file){
		return new TextureAtlas (Gdx.files.internal(file));
	}
	
	/*
	 * carga las imagenes, sonidos, musica y cualquier otro elemento que
	 * requiera el videoJuego
	 */
	public static boolean loadAssets(){
		mainMenu = loadTexture(BACKGROUND_PRINCIPAL);
		creditosMenu = loadTexture(BACKGROUND_CREDITOS);
		juegoFondo = loadTexture(BACKGROUND_JUEGO);
		atlas =  loadAtlas(ATLAS);
		return true;
	}
	
	public static void dispose(){
		mainMenu.dispose();
		creditosMenu.dispose();
		juegoFondo.dispose();
		atlas.dispose();
		
	}
	
}