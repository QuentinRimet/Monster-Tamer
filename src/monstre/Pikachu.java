package monstre;


import Personnage.Dresseur;
import sort.*;
import type.Type;

public class Pikachu extends Monstre {
	public Pikachu(int niv,Dresseur d){
	super("Pikachu", niv, 0,10 ,20, 20, Type.Air,30,d);
	this.ajouterSort(new LanceDeFoudre(), 0);
	this.ajouterSort(new Charge(), 1);
	this.ajouterSort(new Hate(), 2);
	}
	
	public Pikachu(String s,int niv,Dresseur d){
		super(s, niv, 0,10 ,20, 20, Type.Air,20,d);
		this.ajouterSort(new LanceDeFoudre(), 0);
		this.ajouterSort(new Charge(), 1);
		this.ajouterSort(new Hate(), 2);
		}
}
