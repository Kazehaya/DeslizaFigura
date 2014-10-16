package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	
	//Fondos de pantalla
	public static Texture mainMenu;
	private static final String BACKGROUND_PRINCIPAL = "imagenes/pantallasPrincipales/fondos/fondo1.png";
	
	//Atlas
	public static final String ATLAS = "atlas.atlas";
	public static TextureAtlas atlas;
	//Regiones del atlas que se pueden pintar, solo basta con el nombre ya que anteriormente se cargo su ubicacion en el archivo atlas.atlas
	public static final String BOTON_JUGAR = "PantallaPrincipalBotonJugar" ;
	public static final String BOTON_CREDITOS = "PantallaPrincipalBotonCreditos";
	public static final String BOTON_SALIR = "PantallaPrincipalBotonSalir";
	
 	
	
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
		atlas =  loadAtlas(ATLAS);
		return true;
	}
	
	public static void dispose(){
		mainMenu.dispose();
	}
	
}