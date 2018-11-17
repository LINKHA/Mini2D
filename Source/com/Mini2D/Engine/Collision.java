package com.Mini2D.Engine;

import java.util.List;

public abstract class Collision extends Component{
	public abstract RectHitBox getHitBox();
	/*
	 * ������ײ���ô˷���
	 * ˲ʱ��Ӧ
	 */
	public abstract void begainHit();
	/*
	 * ������ײ���ô˷���
	 * ��ʱ��Ӧ
	 */
	public abstract void onHit(Collision collision);
	/*
	 * �ͷ�������ײʱ���ô˷���
	 * ˲ʱ��Ӧ
	 */
	public abstract void releaseHit();
	/*
	 * GameObject����move()ʱ���ô˷���
	 * ��ʱ��Ӧ
	 */
	public abstract void move();
	/*
	 * �ؼ��Ƿ�����ײ
	 */
	public abstract Boolean isHit();
	/*
	 * �ؼ���ײ����
	 */
	public abstract List<Collision> getHit();
	/*
	 * �ж��Ƿ���ײTagΪtag����ײ��
	 */
	public abstract Boolean hit(Tag tag);
	/*
	 * �����ײ��
	 */
	public abstract void clear();
	public void Destory() {
		// TODO Auto-generated method stub
		
	}
	
}
