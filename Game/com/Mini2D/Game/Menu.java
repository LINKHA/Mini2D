package com.Mini2D.Game;

import com.Mini2D.Engine.ScriptSuper;
import com.Mini2D.Engine.Random;
import com.Mini2D.Engine.ScreenSize;
import com.Mini2D.Engine.Input;
import com.Mini2D.Engine.LKTimer;
import com.Mini2D.Engine.Layout;
import com.Mini2D.Engine.Log;
import com.Mini2D.Engine.GameObject;

public class Menu extends ScriptSuper{
	LKTimer aLkTimer=new LKTimer(1000, 0);
	@Override
	public void Init() {
		// TODO Auto-generated method stub
        Log.Print(ScreenSize.WIDTH);                                                  
		int location = Random.Rang(0,200);
		System.out.println("生成一个随机数");
		System.out.println(location);
		Log.Print("message");
	}

	@Override
	public void RunLoop() {
		// TODO Auto-generated method stub
	
		boolean aTime = aLkTimer.timer();
		if(aTime) {
			System.out.println("时间计数器运行");
		}
	}

	@Override
	public void Destruction() {
		// TODO Auto-generated method stub
		
	}

}
