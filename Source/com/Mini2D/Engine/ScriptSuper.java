package com.Mini2D.Engine;

import java.util.List;



public abstract class ScriptSuper {
	public String Scriptname;
	public boolean enable = true;
	public abstract void Init() ;
	public abstract void RunLoop();
	public abstract void Destruction() ;

	public void print(Object object) {
		//Log.Print(object);
	}
	/*
	 * ����name�ҵ�ָ���ű�
	 */
	public ScriptSuper getScriptForName(String name){
		try {
			for(ScriptSuper script : ScriptSystem.getSystem().getScripts()) {
				if(name.equals(script.Scriptname)) {
					return script;
				}
			}
		}catch (Exception e) {
			//Log.Print("File to get Script");
		}
		
		return null;
	}
	/*
	 * �ҵ����нű�
	 */
	public List<ScriptSuper> getScripts(){
		try {
			return ScriptSystem.getSystem().getScripts() ;
		} catch (Exception e) {
			//Log.Print("File to get Scripts");
		}
		return null;
	}
	public void ScriptOn(String name) {
		try {
			ScriptSuper script = getScriptForName(name);
			if(!script.enable) {
				getScriptForName(name).enable = true;
				getScriptForName(name).Init();
			}
		}catch (Exception e) {
			//Log.Print("File to On script");
		}
	}
}
