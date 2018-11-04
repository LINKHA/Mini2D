package com.Mini2D.Engine;


public class Application{	
	//private static final long seriaLVersiononUID = 1L;
	///game engine
	private Engine engine;
	public static AppStates _appStates = AppStates.INVLID;
	public Screen screen;
	///application is run
	private boolean isRun;
	public Input input = new Input(this);
	///singleton instance
	private static Application instance;
	/**
	* @brief : All application awake,private 
	* 			Construction Prevent being called
	*/
	FrameSystem timeSystem;
	FrameSystem scriptSystem;
	
	public double deltaTime = 0.0f;
	public int FPS = 0;
//	private boolean bMouseDown = false;
	
	private Application() throws Exception {
		_appStates = AppStates.INIT;
		screen = new Screen(this);
		engine = new Engine();
		isRun = false;
		
		scriptSystem = ScriptSystem.getSystem();
		timeSystem = TimeSystem.getSystem();
	}
	/**
	* @throws Exception 
	 * @brief : Get instance ,If instance not create,create it.
	*/
	public static Application GetInstance() throws Exception{
		if(instance==null) {
			instance = new Application();
		}
		return instance;
	}
	/**
	* @brief : Application run
	*/
	public void Run() {
		if(!Init()) {
			ErrorExit();
		}
		if(!RunLoop()) {
			ErrorExit();
		}
		if(!Finish()) {
			ErrorExit();
		}
		Exit();
	}
	/**
	* @brief : Application init
	*/
	public boolean Init() {
		timeSystem.addSystemInit();
		scriptSystem.addSystemInit();
		isRun = true;
		return engine.Init();
	}
	/*每帧调用此方法*/
	public void tickComponent() {
		scriptSystem.addSystemRunLoop();
	}
	/*游戏结束调用此方法*/
	public void destruction() {
		scriptSystem.addSystemDestruction();
		_appStates = AppStates.SHUTDOWN;
	}
	/**
	* @brief : Application run loop
	*/
	public boolean RunLoop() {
		double oldTime = System.currentTimeMillis();
		double newTime = System.currentTimeMillis();
		_appStates = AppStates.RUNING;
		while(isRun&&_appStates == AppStates.RUNING) {
			oldTime = newTime;
			newTime = System.currentTimeMillis();
			deltaTime = newTime - oldTime;
			FPS = (int)(1000.0 / deltaTime);
//			if(bMouseDown == true) {
//				mouseDown();
//			}
//			tickComponent();
			screen.repaint();
			try {
				Thread.sleep((long)1000.0/Setting.FPS);
			} catch(Exception e) {
				System.out.println("Failed to sleep");
			}
			if(engine == null) {
				return false;
			}
			isRun = engine.RunFrame();
		}
		return true;
	}
	/**
	* @brief : Application finish and Exit
	*/
	public boolean Finish() {
		
		return engine.Exit();
	}
	/**
	* @brief : Application error exit
	*/
	public void ErrorExit() {
		//Log("Application exit error!");
		System.exit(-1);
	}
	/**
	* @brief : Application exit
	*/
	public void Exit() {
		//Log("Application successful exit!");
		System.exit(0);
	}
}