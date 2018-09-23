package com.Mini2D.Engine;


public class Application {
	///game engine
	private Engine engine;
	///application is run
	private boolean isRun;
	///singleton instance
	private static Application instance;
	/**
	* @brief : All application awake,private 
	* 			Construction Prevent being called
	*/
	private Application(){
		engine = new Engine();
		isRun = false;
	}
	/**
	* @brief : Get instance ,If instance not create,create it.
	*/
	public static Application GetInstance() {
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
		isRun = true;
		return engine.Init();
	}
	/**
	* @brief : Application run loop
	*/
	public boolean RunLoop() {
		while(isRun) {
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
