package sort;


import type.*;

public class Sort {
	

	private Type type;
	private int puissance;
	
	public Sort(Type t,int p){
		type=t;
		puissance=p;
	}
	
	public String toString(){
		return "sort";
	}
	
	public Type getType() {
		return type;
	}

	public int getPuissance() {
		return puissance;
	}
}
