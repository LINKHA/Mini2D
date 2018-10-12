package com.Mini2D.Engine;

public enum Layout {

Default;
	
	private int value;
	private static class Counter{
	     private static int nextValue = 0;
	}
	Layout(){
		 this(Counter.nextValue);
	}
	Layout(int value) {
		this.value = value;
		Counter.nextValue = value + 1;
	}
	public int getValue(){
	    return value;
	}
}
