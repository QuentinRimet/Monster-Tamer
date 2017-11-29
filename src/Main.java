
import javax.swing.JFrame;

import Personnage.Dresseur;
import combat.Combat;
import combat.afficheCombat;
import combat.interfaceCombat;
import monstre.Gobou;
import monstre.Pikachu;
import monstre.Sabelette;
import monstre.Salameche;

public class Main extends JFrame{

	public static void main(String[] args) {
		Dresseur dr=new Dresseur("Sa chatte");
		Dresseur dr1=new Dresseur("On dine ?");
		for(int i=0;i<6;i++){
			int a=(int)(Math.random()*4);
			if(a==0)
				dr.ajouterMonstre(new Salameche(5,dr));
			if(a==1)
				dr.ajouterMonstre(new Gobou(5,dr));
			if(a==2)
				dr.ajouterMonstre(new Pikachu(5,dr));
			if(a==3)
				dr.ajouterMonstre(new Sabelette(5,dr));
		}
		for(int i=0;i<6;i++){
			int a=(int)(Math.random()*4);
			if(a==0)
				dr1.ajouterMonstre(new Salameche(5,dr1));
			if(a==1)
				dr1.ajouterMonstre(new Gobou(5,dr1));
			if(a==2)
				dr1.ajouterMonstre(new Pikachu(5,dr1));
			if(a==3)
				dr1.ajouterMonstre(new Sabelette(5,dr1));
		}
	

		JFrame f=new JFrame();
		
		
		afficheCombat pan=new afficheCombat(dr,dr1);
		interfaceCombat pan2=new interfaceCombat(pan);
		Combat combat=new Combat(pan,pan2);
		f.setContentPane(combat);
		f.setTitle("Monster Tamer");
		f.pack();
		f.setVisible(true);
		f.setResizable(false);
		System.out.println((int)(Math.random()*2));
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
}
