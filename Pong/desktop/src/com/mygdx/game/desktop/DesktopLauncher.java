package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Pong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = Pong.WORLD_HEIGHT;
		config.width = Pong.WORLD_WIDTH;
		config.title = "Pong";
		new LwjglApplication(new Pong(), config);
	}
}
