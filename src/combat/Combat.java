package combat;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Combat extends JPanel{

 public Combat(afficheCombat affiche,interfaceCombat commande){
	 this.setLayout((new BorderLayout()));
		this.add(affiche, BorderLayout.NORTH);
		this.add(commande);
 }
}
