package sort;

import monstre.Monstre;
import type.Type;

public class Charge extends Attaque {

	public Charge() {
		super(Type.Normal, 15);
	}

	@Override
	public void effet(Monstre m, Monstre e) {
		double a=(m.getNiv()+this.getPuissance())*(1+(m.getAttaque()/1000.0));
		a=a/(1+(e.getDefence()/1000.0));
		e.prendreDegats((int)a);

	}
	public String toString(){
		return "Charge";
	}
}
