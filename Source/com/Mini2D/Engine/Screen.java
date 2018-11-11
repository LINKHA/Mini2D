package com.Mini2D.Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class Screen extends JPanel {
	
	/**
	 * °æ±¾ V1.0
	 */
	private static final long serialVersionUID = 1L;

	private boolean fpsCounter = false;
	
	static List<GameObject> gameObjects = new ArrayList<GameObject>();
	
	
	
	public Screen() {}
	public void setFpsCounter(boolean b) {
		fpsCounter = b;
	}
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		for(int i=0;i<gameObjects.size();i++) {
			gameObjects.get(i).paint(g);
		}		
		if(fpsCounter) {
			g.setColor(Color.black);
			try {
				g.drawString(Application.GetInstance().FPS + "", 20, 20);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void addToScreen(GameObject gameObj) {

		if(gameObjects.size()==0) {
			gameObjects.add(gameObj);
			return;
		}

		
		int i=0;
		for(GameObject object : gameObjects) {
			
			if(object.layout.getValue()>=gameObj.layout.getValue()) {
				gameObjects.add(i, gameObj);
				return;
			}
			i++;
		}
		
		gameObjects.add(gameObj);
	}
	public static void deleteToScreen(int keyValue) {
		for(Component compontent : gameObjects) {
			if(keyValue==compontent.keyValue) {
				gameObjects.remove(compontent);
				return;
			}
		}
	}
}
	