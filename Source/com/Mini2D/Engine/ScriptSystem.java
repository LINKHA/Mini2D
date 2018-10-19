package com.Mini2D.Engine;

import java.awt.List;
import java.util.ArrayList;

public class ScriptSystem extends FrameSystem {
	
	
	private static ScriptSystem instance;
	
	private  String ScriptPackName;
	private  List<Class<?>> classes = new ArrayList<Class<?>>();
	private  List<ScriptSuper> scripts = new ArrayList<ScriptSuper>();
	private ScriptSystem() throws Exception {
		this.ScriptPackName = Setting.ScriptPackName;
		scan(ScriptPackName,classes);
		for(Class<?> c : classes ) {
			ScriptSuper aScriptSuper =(ScriptSuper) c.newInstance();
			addScript(aScriptSuper);
		}
	}
	
	
	public void scan(String packageName ,List<Class<?>> list) throws Exception{
	    if(packageName==null) {
	    	Log.Print("File to loading scripts");
	    	return;
	    }
		String path=getSrcPath()+packageToDir(packageName);
	    File dir=new File(path);
	    File[] files=dir.listFiles();
	    Class<?> cla=null;
	    for(File f:files){
	        if(f.isDirectory()){
	            String childName=packageName+"."+f.getName();
	            scan(childName, list);
	 
	        }else{
	            cla=Class.forName(packageName+"."+f.getName().split("\\.")[0]);
	            list.add(cla);
	        }
	    }
	}
	/**
	��ȡ��ǰ·��
	*/
	public  String getSrcPath() throws IOException{
	   File file=new File("");
	   String path=file.getCanonicalPath()+File.separator+"Game";
	   return path;
	}
	/**
	 *packageת��Ϊ·����ʽ
	 */
	public  String packageToDir(String packageName){
	    String[] array=packageName.split("\\.");
	    StringBuffer sb=new StringBuffer();
	    for(String str:array){
	        sb.append(File.separator).append(str);
	    }
	    return sb.toString();
	}
	public  List<ScriptSuper>getScripts() {
		return scripts;
	}


	public static ScriptSystem getSystem() throws Exception {
		if(instance==null) {
			instance = new ScriptSystem();
		}
		return instance;
	}

	public void addScript(ScriptSuper s) {
		scripts.add(s);
	}

	
	
	
	
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		for(ScriptSuper s : scripts) {
			if(s.enable)
				s.Init();
		}
	}

	@Override
	public void addSystemRunLoop() {
		// TODO Auto-generated method stub
		for(ScriptSuper s : scripts) {
			if(s.enable)
				s.RunLoop();
		}
	}

	@Override
	public void addSystemDestruction() {
		// TODO Auto-generated method stub
		for(ScriptSuper s : scripts) {
			if(s.enable)
				s.Destruction();
		}
	}
}