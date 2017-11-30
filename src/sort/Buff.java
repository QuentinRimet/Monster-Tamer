package sort;

import monstre.Monstre;
import type.Type;

public  abstract class Buff extends Sort{

	public Buff(Type t, int p) {
		super(t, p);
	}
	//permet de changer les stats du monstre selectionné
	public abstract void effet(Monstre m);  
	
}
