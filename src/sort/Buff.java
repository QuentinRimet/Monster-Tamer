package sort;

import monstre.Monstre;
import type.Type;

public  abstract class Buff extends Sort{

	public Buff(Type t, int p) {
		super(t, p);
		// TODO Auto-generated constructor stub
	}
	public abstract void effet(Monstre m);  
	public void test(){
		
	}
}
