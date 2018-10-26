package com.Mini2D.Engine;


import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener,MouseListener,MouseMotionListener{
	
	boolean keyDwon = false;
	boolean MouseDwon=false;
	private static boolean[] keys = new boolean[300];
	
	
	
	private Input() {}
	
	static Input instance;
	static Input example;

	
	static Input GetExample() {
		if(example == null) {
			example = new Input();
		}
		return example; 
	}
	
	static Input GetInstance() {
		if(instance == null) {
			instance = new Input();
		}
		return instance; 
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		DebugScript.GetInstance().ButtonDown(e);
		keyDwon = true;
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keyDwon=false;
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
	
	
	public boolean getButtonDown(){
		if(keyDwon == true) {
			return true;
		}
		return false;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		MouseDwon=true;
		
	
		
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
		// TODO Auto-generated method stub
		DebugScript.GetExample().Button1Down(e);
		MouseDwon=true;
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		MouseDwon=false;
	}
	public void mouseDragged(MouseEvent e) {
		MouseDwon=true;
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//MouseLocation.x =e.getX();
		//MouseLocation.y =e.getY();
		MouseDwon=true;
	}
	
	
}
