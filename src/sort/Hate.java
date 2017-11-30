package sort;

import monstre.Monstre;
import type.Type;

public class Hate extends Buff{

	public Hate() {
		super(Type.Normal, 20);
	}

	@Override
	public void effet(Monstre m) {
		m.setVit(m.getVit()+this.getPuissance());
		}
	public String toString(){
		return "Hate";
	}
}
