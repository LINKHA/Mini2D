package com.Mini2D.Engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DebugScript {

	
	public DebugScript(){

	}
	int x=10000,y=500;
	int i=0;

	static DebugScript instance;
	static DebugScript example;
	
	public static DebugScript GetInstance() {
		if(instance == null)
			instance = new DebugScript();
		return instance;
	}
	public static DebugScript GetExample() {
		if(example == null)
			example = new DebugScript();
		return example;
	}
	

	
	public void Start() {
		
		
	} 
	public void Update() {
		if(x>=1000)
		{
			x=500;
		}
		if(x<=0)
		{
			x=0;
		}
		if(y>=1000)
		{
			y=500;
		}
		if(y<=0)
		{
			y=0;
		}

		//Change picture position to 100 100
		Screen.GetInstance().Position(x, y);
		//Set picture scale to 2
		Screen.GetInstance().Scale(2);
	}
	void SetPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	void ButtonDown(KeyEvent e) {
		if(e.getKeyChar()=='w')
			y--;
		else if(e.getKeyChar()=='s')
			y++;
		else if(e.getKeyChar()=='d')
			x++;
		else if(e.getKeyChar()=='a')
			x--;
		else if(e.getKeyCode()==KeyEvent.VK_UP)
			y--;
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			y++;
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			x--;
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			x++;
	}
	void Button1Down(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			System.out.println("×ó¼ü");
		else if(e.getButton()==MouseEvent.BUTTON3)
			System.out.println("ÓÒ¼ü");
			
	}
}
