package sort;

import monstre.Monstre;
import type.Type;

public abstract class Attaque extends Sort{

	public Attaque(Type t, int p) {
		super(t, p);
	}
	//permet au monstre m d'ataquer le monstre e 
	//les attaques prennent en compte les faiblesses et forces des types de l'attaque et du monstre e
	public abstract void effet(Monstre m,Monstre e);  
}
