package com.Mini2D.Engine;


import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;




public class Input implements KeyListener,MouseListener,MouseMotionListener{

	static boolean leftMouseDown = false;
	static boolean rightMouseDown = false;
	private static boolean hitMouse = false;
	private static boolean releasedMouse = false;
	private static boolean[] keys = new boolean[300];
	private static Vector2 MouseLocation = new Vector2();
	static Input instance;
	
	private Input() {}
	public static Input GetInstance() {
		if(instance == null) {
			instance = new Input();
		}
		return instance; 
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		hitMouse = true;
		if(e.isMetaDown()) {
			rightMouseDown = true;
			UISystem.getSystem().mousePressed();
		}
		else {
			leftMouseDown = true;
			UISystem.getSystem().mousePressed();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		releasedMouse = true;
		if(e.isMetaDown()) {
			rightMouseDown = false;
			UISystem.getSystem().mouseReleased();
		}
		else {
			leftMouseDown = false;
			UISystem.getSystem().mouseReleased();
		}
	}
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		MouseLocation.x =e.getX();
		MouseLocation.y =e.getY();

	}

	public static boolean getButtonDown(int indexKey){
		if(keys[indexKey] == true) {
			return true;
		}
		return false;
	}

	public static boolean leftMouseDown() {
		return leftMouseDown;
	}
	public static boolean rightMouseDown() {
		return rightMouseDown;
	}
	public static Vector2 getMouseLocation() {
		return MouseLocation;
	}
	public static boolean hitMouse() {
		if(hitMouse) {
			hitMouse = false;
			return true;
		}
		return false;
	}
	public static boolean releasedMouse() {
		if(releasedMouse) {
			releasedMouse = false;
			return true;
		}
		return false;
	}
}
