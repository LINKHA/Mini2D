package com.Mini2D.Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{
	
	boolean keyDwon = false;
	
	private Input() {}
	
	static Input instance;
	
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
}
