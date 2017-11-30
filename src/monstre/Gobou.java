package monstre;

import Personnage.Dresseur;
import sort.Charge;
import sort.Hate;
import sort.picDeGlace;
import type.Type;

public class Gobou extends Monstre {

	public Gobou(int niv,Dresseur d) {
		super("Gobou", niv, 0,10 ,25, 25, Type.Eau,20,d);
		this.ajouterSort(new picDeGlace(), 0);
		this.ajouterSort(new Charge(), 1);
		this.ajouterSort(new Hate(), 2);
	}
	
}
