package monstre;

import Personnage.Dresseur;
import sort.*;
import type.Type;

public class Sabelette extends Monstre {
	public Sabelette(int niv,Dresseur d) {
		super("Sabelette", niv, 0,10 ,20, 30, Type.Terre,20,d);
		this.ajouterSort(new CoupDeBoule(), 0);
		this.ajouterSort(new Charge(), 1);
		this.ajouterSort(new Hate(), 2);
	}
}
