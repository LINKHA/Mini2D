package pers.LINKH2.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LKTimer;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Game.Tools.Random;

class Pair{
	public Pair(GameObject up , GameObject down){
		Up = up;
		Down = down;
	}
	public GameObject Up;
	public GameObject Down;
}

public class Game extends ScriptSuper{
	
	static GameObject gameObject;
	static GameObject MainMenuGround;
	static GameObject MainMenuGround2;
	
	List<Pair> pipes = new ArrayList<Pair>();
	boolean isJump = false;
	int frameCount = 0;
	final static int FRAME_COUNT_DEFINE = 50;
	/// ����ʱ������� 0������ʱ�� ÿ4000���뷵��һ��true
	LKTimer aLkTimer=new LKTimer(4000, 0);
	/**
	* @brief : ������Ϊfalseʹ�ò�������Ϸ��ʼʱ���� 
	*/
	public Game(){
		super.enable = false;
		Scriptname = "Game";
	}
	/**
	* @brief :  ����player �Լ���������ͼ��
	*/
	public void Init() {
		gameObject =new GameObject( new Vector2(ScreenSize.WIDTH/2 - 500,ScreenSize.HEIGHT/2), 200, 200);
		gameObject.addSprite(new Sprite("Assets/bird2_001.png",gameObject));
		gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/bird2_00",".png", 1, 3),15,  gameObject));
		gameObject.addCollider(new Collider(gameObject));
		
		MainMenuGround = new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		MainMenuGround.addSprite(new Sprite("Assets/bg_day.png",MainMenuGround));

		MainMenuGround2 = new GameObject( new Vector2(ScreenSize.WIDTH * 1.5f,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		MainMenuGround2.addSprite(new Sprite("Assets/bg_day.png",MainMenuGround2));
		
	}
	
	public void RunLoop() {
///////////////////////////////////////////////////////////////////////////
//@brief :  ���ñ��������ƶ�������λ��

		MainMenuGround2.move(-1, 0);
		MainMenuGround.move(-1, 0);
		if(MainMenuGround.getPosition().x<=-(ScreenSize.WIDTH/2))
			MainMenuGround.setPosition(ScreenSize.WIDTH* 1.5f, ScreenSize.HEIGHT/2);
		
		if(MainMenuGround2.getPosition().x<=-(ScreenSize.WIDTH/2))
			MainMenuGround2.setPosition(ScreenSize.WIDTH* 1.5f,ScreenSize.HEIGHT/2);

//////////////////////////////////////////////////////////////////////////
		///�õ�ʱ�������booleanֵ
		boolean aTime = aLkTimer.timer();
		///ÿ4000���봴��һ�ιܵ�
		if(aTime)
			CreatePipe();
		///�ж�player�Ƿ���ײ�ܵ��Լ��߽�
		DetermineCollide();
		
		MovePipe();
		///ɾ���Ƶ���ߵĹܵ�
		DeletePipe();
		///����player��������  �Լ����ϼ��ٶ�
		BirdMove(isJump);
		///��������  player��
		if(Input.hitMouse()){
			frameCount = FRAME_COUNT_DEFINE;
			isJump = true;
		}
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}

	void CreatePipe(){
		int location = Random.Rang(0,200);
		GameObject up = new GameObject( new Vector2(ScreenSize.WIDTH +100,ScreenSize.HEIGHT -100 + location), 200, 500,Tag.Enemy,Layout.Sprite);
		up.addSprite(new Sprite("Assets/pipe_up.png",up));
		up.addCollider(new Collider(up));
		
		GameObject down = new GameObject( new Vector2(ScreenSize.WIDTH  +100 ,-100 + location), 200, 500,Tag.Enemy,Layout.Sprite);
		down.addSprite(new Sprite("Assets/pipe_down.png",down));
		down.addCollider(new Collider(down));
		Pair pipe =new Pair(up, down);
		
		pipes.add(pipe);
	}
	
	void DeletePipe() {
		for(Pair p : pipes) {
			if(p.Down.getPosition().x<-100){
				p.Down.Destroy();
				p.Up.Destroy();
				pipes.remove(p);
				break;
			}
		}
	}
	
	void MovePipe() {
		for(Pair p : pipes) {
			p.Down.move(-2, 0);
			p.Up.move(-2, 0);
		}
	
	}
	
	void BirdMove(boolean isJump) {
		if(isJump){
			Jump();
		}else {
			FreeFall();
		}
	}
	
	void DetermineCollide() {
		if(gameObject.getCollision().hit(Tag.Enemy)) {
			ClearScene();
		}
		if(gameObject.getPosition().y >=ScreenSize.HEIGHT  || gameObject.getPosition().y <=0) {
			ClearScene();
		}
	}
	
	void ClearScene() {
		gameObject.Destroy();
		MainMenuGround.Destroy();
		MainMenuGround2.Destroy();
		for(Pair p : pipes) {
			p.Down.Destroy();
			p.Up.Destroy();
		}
		pipes.clear();
		super.enable = false;
		ScriptOn("Menu");
	}
	
	void Jump() {
		if(frameCount<=0)
			isJump = false;
		frameCount--;
		gameObject.move(0, -frameCount/5);
	}
	
	void FreeFall() {
		frameCount++;
		gameObject.move(0, frameCount/5);
	}
	
}