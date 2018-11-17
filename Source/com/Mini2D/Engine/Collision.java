package com.Mini2D.Engine;

import java.util.List;

public abstract class Collision extends Component{
	public abstract RectHitBox getHitBox();
	/*
	 * 发生碰撞调用此方法
	 * 瞬时响应
	 */
	public abstract void begainHit();
	/*
	 * 发生碰撞调用此方法
	 * 即时响应
	 */
	public abstract void onHit(Collision collision);
	/*
	 * 释放所有碰撞时调用此方法
	 * 瞬时响应
	 */
	public abstract void releaseHit();
	/*
	 * GameObject调用move()时调用此方法
	 * 即时响应
	 */
	public abstract void move();
	/*
	 * 控件是否发生碰撞
	 */
	public abstract Boolean isHit();
	/*
	 * 控件碰撞对象
	 */
	public abstract List<Collision> getHit();
	/*
	 * 判断是否碰撞Tag为tag的碰撞体
	 */
	public abstract Boolean hit(Tag tag);
	/*
	 * 清空碰撞体
	 */
	public abstract void clear();
	public void Destory() {
		// TODO Auto-generated method stub
		
	}
	
}
