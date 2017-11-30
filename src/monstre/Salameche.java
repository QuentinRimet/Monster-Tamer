package monstre;

import Personnage.Dresseur;
import sort.*;
import type.*;

public class Salameche extends Monstre {
	
	public Salameche(int niv,Dresseur d) {
		super("Salamèche", niv, 0,10 ,30, 20, Type.Feu,20,d);
		this.ajouterSort(new BouleDeFeu(), 0);
		this.ajouterSort(new Charge(), 1);
		this.ajouterSort(new Hate(), 2);
		}
}
