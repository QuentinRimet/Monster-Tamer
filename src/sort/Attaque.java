package sort;

import monstre.Monstre;
import type.Type;

public abstract class Attaque extends Sort{

	public Attaque(Type t, int p) {
		super(t, p);
		// TODO Auto-generated constructor stub
	}
	public abstract void effet(Monstre m,Monstre e);  
}
