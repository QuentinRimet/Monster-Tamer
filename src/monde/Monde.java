package monde;

import javax.swing.JPanel;

import Personnage.Personnage;

public class Monde extends JPanel{
	private Personnage hero;
	
	public Monde(Personnage h){
		hero=h;
		this.requestFocusInWindow();
	}
}
