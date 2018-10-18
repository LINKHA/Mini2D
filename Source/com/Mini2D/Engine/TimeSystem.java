package com.Mini2D.Engine;

import java.util.Timer;
import java.util.TimerTask;

public class TimeSystem extends FrameSystem{
	private static TimeSystem instance;
	
	private  double currentTime;
	private Timer timer;
	private boolean isTimeGo = true;
	private TimeSystem() {
		timer = new Timer();
		currentTime = 0.0;
	}
	/**
	*��ʱ��:��¼��ʼ��Ϸ����ǰʱ�侭����ʱ��
	*��ȷ��100����
	*/
	public void stopWatch() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(isTimeGo) {
					currentTime+=100.0;
				}
			}
		}, 0,100);
	}
	public static TimeSystem getSystem() {
		if(instance==null) {
			instance = new TimeSystem();
		}
		return instance;
	}
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		stopWatch();
	}
	public double getCurrent() {
		return currentTime;
	}
}