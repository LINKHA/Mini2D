package com.Mini2D.Engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class DebugScript {

	
	public DebugScript(){

	}
	int x=10000,y=500;
	int i=0;

	static DebugScript instance;
	
	public static DebugScript GetInstance() {
		if(instance == null)
			instance = new DebugScript();
		return instance;
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
		if(Input.GetInstance().getButtonDown())
			System.out.println("as");

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
			System.out.println("w");
		else if(e.getKeyChar()=='s')
			System.out.println("s");
		else if(e.getKeyChar()=='d')
			System.out.println("d");
		else if(e.getKeyChar()=='a')
			System.out.println("a");
		else if(e.getKeyCode()==KeyEvent.VK_UP)
			System.out.println("ио");
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			System.out.println("об");
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			System.out.println("вС");
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			System.out.println("ср");
	}
}
