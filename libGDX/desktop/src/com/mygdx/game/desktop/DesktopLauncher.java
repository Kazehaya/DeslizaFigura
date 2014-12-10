package com.mygdx.game.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import funnyBeginning.deslizapieza.modelo.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.addIcon("imagenes/iconos/iconoApp32.png", FileType.Internal);
//		128x128 Mac
//		32x32 linux and windows
//		16X16 Windows
		
		new LwjglApplication(new MyGdxGame(), config);
	}
}
