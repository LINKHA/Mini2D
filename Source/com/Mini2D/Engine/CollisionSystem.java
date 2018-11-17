package com.Mini2D.Engine;

import java.util.ArrayList;
import java.util.List;

class ColliderMessage{
	public int keyValue;
	public Collision collider;
	public boolean bHit;
	ColliderMessage(int keyValue,Collision collider){
		this.keyValue = keyValue;
		this.collider = collider;
		this.bHit = false;
	}
}

public class CollisionSystem extends FrameSystem{
	private static CollisionSystem instance;
	private List<ColliderMessage> colliders = new ArrayList<ColliderMessage>();
	private CollisionSystem() {}
	
	public List<ColliderMessage[]> checkCollisions(){
		List<ColliderMessage[]> collistions = new ArrayList<ColliderMessage[]>();
		//�ж���ײ���Ƿ��ڱ���������ײ
		boolean s = false;
		for(int i=0;i<colliders.size();i++) {
			colliders.get(i).collider.clear();
		}
		for(int i=0;i<colliders.size();i++) {
			s = false;
			for(int n=0;n<colliders.size();n++) {
				ColliderMessage[] current = new ColliderMessage[2];
				current[0] = colliders.get(i);
				current[1] = colliders.get(n);
				if(i!=n) {
					if((current[0].collider.getHitBox().intersects(current[1].collider.getHitBox()))) {
						if(colliders.get(i).bHit==false) {
							colliders.get(i).collider.begainHit();
						}
						if(colliders.get(n).bHit==false) {
							colliders.get(n).collider.begainHit();
						}
						colliders.get(i).bHit=true;
						colliders.get(n).bHit=true;
						s=true;
						collistions.add(current);
					}
				}
			}
			if(colliders.get(i).bHit==true && s==false) {
				colliders.get(i).bHit = false;
				colliders.get(i).collider.releaseHit();
			}
		}
		return collistions;
	}
	
	public void performCollistions() {
		if(colliders.size()==0)
			return;
		else if(colliders.size()==1) {
			colliders.get(0).collider.clear();
		}
		for(ColliderMessage[] current:checkCollisions()) {
			current[0].collider.onHit(current[1].collider);
			current[1].collider.onHit(current[0].collider);
		}
	}
	
	public void addCollider(Collision collider) {
		//���� ����Ƿ����ظ�
		for(ColliderMessage checkValue : colliders) {
			if(checkValue.keyValue == collider.keyValue) {
				//Log.Print("Fail to add Collider");
				return;
			}
		}
		colliders.add(new ColliderMessage(collider.keyValue,collider));
	}
	
	public void deleteCollider(int keyValue) {
		//����  ���ҵ�keyValue
		for(ColliderMessage checkValue : colliders) {
			if(checkValue.keyValue == keyValue) {
				colliders.remove(checkValue);
				return;
			}
		}
	}	
	
	public static CollisionSystem getSystem() {
		// TODO Auto-generated method stub
		if(instance==null) {
			instance = new CollisionSystem();
		}
		return instance;
	}
	public void addSystemRunLoop() {
		performCollistions();
	}
}
