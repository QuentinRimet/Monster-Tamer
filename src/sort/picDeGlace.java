package sort;

import monstre.Monstre;
import type.Type;

public class picDeGlace extends Attaque{

	public picDeGlace( ) {
		super(Type.Eau, 15);
	}

	@Override
	public void effet(Monstre m, Monstre e) {
		double a=(m.getNiv()+this.getPuissance())*(1+(m.getAttaque()/1000.0));
		a=a/(1+(e.getDefence()/1000.0));
		if(e.getType().getFaiblesse()==this.getType().toString())
			a=(int)(a*1.5);
		if(e.getType().getForce()==this.getType().toString())
			a=(int)(a*0.5);
		e.prendreDegats((int)a);
		
	}
	public String toString(){
		return "Pic de glace";
	}
}
