package Personnage;

import monstre.Monstre;

public class Dresseur extends Personnage {
	private Monstre[] monstre=new Monstre[6];
	private int ite;
	private int actif;
	
	public Dresseur(String n) {
		super(n);
		ite=0;
		actif=0;
	}
	
	//permet au dresseur d'ajouter un monstre à sa collection
	public void ajouterMonstre(Monstre m){
		if(ite<6){
			monstre[ite]=m;
			ite++;
		}
	}
	///si le dresseur n'a plus de monstre en vie alors il a perdu
	public boolean perdu(){
		for(int i=0;i<ite;i++){
			if(!monstre[i].Mort())
				return false;
		}
		return true;
	}
	
	//envoi le prochain monstre du dresseur si ils ne sont pas tous morts
	public int envoiProch(){
		for(int i=0;i<ite;i++){
			if(!monstre[i].Mort())
				return i;
		}
	return -1;
	}
	
	public Monstre[] getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre[] monstre) {
		this.monstre = monstre;
	}

	public int getIte() {
		return ite;
	}

	public void setIte(int ite) {
		this.ite = ite;
	}

	public int getActif() {
		return actif;
	}

	public void setActif(int actif) {
		this.actif = actif;
	}
	
	
}
