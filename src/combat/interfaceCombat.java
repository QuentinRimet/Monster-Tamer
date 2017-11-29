package combat;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import monstre.Pikachu;

public class interfaceCombat extends JPanel{
	private afficheCombat combat;
	private JPanel texte=new JPanel();
	private JPanel choix=new JPanel();
	private boolean fintour=false;

	public interfaceCombat(afficheCombat c){
		combat=c;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500,100));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		this.add(choix);
		this.add(texte);
		setChoix("menu");
		setTexte("Que voulez-vous faire ?");
	}

	public void setChoix(String s){
		if (s=="menu"){
			this.remove(choix);
			choix=new JPanel(new GridLayout(2,2));
			ActionListener ac=new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!combat.getM1().Mort()){
						if(((JButton)e.getSource()).getText()=="Attaque"){
							setChoix("attaque");
							remove(texte);
						}
					}
					if(((JButton)e.getSource()).getText()=="Pokemon"){
						setChoix("Pokemon");
						remove(texte);
					}


				}

			};
			JButton at=new JButton("Attaque");
			at.addActionListener(ac);
			JButton cp=new JButton("Pokemon");
			cp.addActionListener(ac);
			JButton ob=new JButton("Item");
			ob.addActionListener(ac);
			JButton fu=new JButton("fuir");
			fu.addActionListener(ac);
		
			choix.add(at);
			choix.add(cp);
			choix.add(ob);
			choix.add(fu);
			choix.setPreferredSize(new Dimension(200,100));
			this.add(choix,BorderLayout.EAST);
		}
		//************************************************************
		if(s=="Pokemon"){
			this.remove(choix);
			choix=new JPanel(new GridLayout(2,2));
			ActionListener ac=new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
				
					for(int i=0;i<6;i++){
						if(combat.getDr().getMonstre()[i]!=null && !combat.getDr().getMonstre()[i].equals(combat.getM1())  && !combat.getDr().getMonstre()[i].Mort() && ((JButton)e.getSource()).getName().equals(String.valueOf(i))){
							combat.changerMonstre(i);
							setChoix("menu");
							remove(choix);
							setTexte(combat.getDr().getMonstre()[i].getNom()+" GO!!!");
							Timer timer=new Timer();
							int time=1500;
							if(!fintour){

								timer.schedule(new TimerTask(){
									public void run() {
										attaqueEnnemi();
									}
								}, time);
								time+=1500;
							}
							fintour=false;
							timer.schedule(new TimerTask(){
								public void run(){
									verifTour();
								}
							}, time);

						}
					}

					validate();
					repaint();
					combat.repaint();

				}


			};
			//place les bouton des Monstres
			for(int i=0;i<6;i++)
				if(combat.getDr().getMonstre()[i]!=null){
					JButton at=new JButton(combat.getDr().getMonstre()[i].getNom());
					at.setName(String.valueOf(i));
					if(combat.getDr().getMonstre()[i].Mort())
						at.setForeground(Color.red);
					at.addActionListener(ac);
					choix.add(at);
				}else{
					JButton fu=new JButton("");
					choix.add(fu);
				}

			this.add(choix,BorderLayout.CENTER);
			validate();
			repaint();
		}
		//**********************************************************************************
		if(s=="attaque"){
			this.remove(choix);
			choix=new JPanel(new GridLayout(2,2));
			ActionListener ac=new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {

					setChoix("menu");
					add(texte,BorderLayout.CENTER);
					remove(choix);
					Timer timer=new Timer();
					int time=0;

					boolean rapide;
					double vit=(Math.random());
					if(combat.getM2().getVit()<combat.getM1().getVit())
						rapide=false;
					else if(combat.getM2().getVit()>combat.getM1().getVit())
						rapide=true;
					else if(vit<0.5)
						rapide=false;
					else
						rapide=true;


					//attaque du monstre ennemie si plus rapide
					if(rapide && !combat.getM2().Mort()){
						attaqueEnnemi();
						
						time+=1500;
					}

					//attaque du monstre allie


					if(rapide && !combat.getM1().Mort()){
						timer.schedule(new TimerTask(){
							public void run(){
								for(int i=0;i<4;i++)
									if(combat.getM1().getSort()[i]!=null && ((JButton)e.getSource()).getText()==combat.getM1().getSort()[i].toString()){
										setTexte(combat.getM1().getNom()+" alli� utilise "+combat.getM1().getSort()[i].toString());
										combat.getM1().utiliserSort(i,combat.getM2());
									}
								validate();
								repaint();
								combat.repaint();

							}
						}, time);
						time+=1500;

					}

					if(!rapide && !combat.getM1().Mort()){
						for(int i=0;i<4;i++)
							if(combat.getM1().getSort()[i]!=null && ((JButton)e.getSource()).getText()==combat.getM1().getSort()[i].toString()){
								setTexte(combat.getM1().getNom()+" alli� utilise "+combat.getM1().getSort()[i].toString());
								combat.getM1().utiliserSort(i,combat.getM2());
							}
						validate();
						repaint();
						combat.repaint();
						time+=1500;

					}


					//attaque du monstre ennemie si moins rapide
					if(!rapide && !combat.getM2().Mort()){
						timer.schedule(new TimerTask(){
							public void run(){
							attaqueEnnemi();


							}
						}, time);
						time+=1500;

					}


					timer.schedule(new TimerTask(){
						public void run(){
							verifTour();
						}
					}, time);

				}

			};
			//place les bouton des sorts
			for(int i=0;i<4;i++)
				if(combat.getM1().getSort()[i]!=null){
					JButton at=new JButton(combat.getM1().getSort()[i].toString());
					at.addActionListener(ac);
					choix.add(at);
				}else{
					JButton fu=new JButton("");
					choix.add(fu);
				}

			this.add(choix,BorderLayout.CENTER);
		}
		validate();
		repaint();
	}


	public void setTexte(String s){
		this.remove(texte);
		texte=new JPanel();
		JLabel text=new JLabel(s);
		this.setPreferredSize(new Dimension(300,100));
		texte.setLayout(new GridBagLayout());

		texte.add(text);
		this.add(texte,BorderLayout.CENTER);
	}

	public void verifTour(){
		Timer timer=new Timer();
		int timee=0;
		if(combat.getM1().Mort()){
			timer.schedule(new TimerTask(){
				public void run(){
					setTexte(combat.getM1().getNom()+" alli� est hors combat");
					validate();
					repaint();
					combat.repaint();

				}
			}, timee);
			timee+=1500;
		}


		if(combat.getM2().Mort()){
			timer.schedule(new TimerTask(){
				public void run(){
					setTexte(combat.getM2().getNom()+" ennemie est hors combat");
					validate();
					repaint();
					combat.repaint();

				}
			}, timee);
			timee+=1500;
			if(combat.getDr1().envoiProch()!=-1){
				timer.schedule(new TimerTask(){
					public void run(){
						combat.changerMonstreEnnemie();
						setTexte(combat.getM2().getNom()+" ennemie est envoyer au combat");

						validate();
						repaint();
						combat.repaint();

					}
				}, timee);
				timee+=1500;
			}
		}

		if(combat.getM1().Mort()){
			timer.schedule(new TimerTask(){
				public void run(){
					setTexte(combat.getM1().getNom()+" alli� est hors combat");

					validate();
					repaint();
					combat.repaint();

				}
			}, timee);
			timee+=1500;

		}

		if(combat.getDr1().perdu()){
			timer.schedule(new TimerTask(){
				public void run(){
					setTexte("Vous avez vaincu "+combat.getDr1().getNom());
					validate();
					repaint();
					combat.repaint();

				}
			}, timee);
			timee+=1500;
		}
		else 
			if(combat.getDr().perdu()){
				timer.schedule(new TimerTask(){
					public void run(){
						setTexte("Vous avez �t� vaincu par "+combat.getDr1().getNom());
						validate();
						repaint();
						combat.repaint();

					}
				}, timee);
				timee+=1500;
			}
		if(!combat.getDr1().perdu() && !combat.getDr().perdu())
			timer.schedule(new TimerTask(){
				public void run(){
					add(choix,BorderLayout.EAST);
					setTexte("Que voulez-vous faire ?");
					if(combat.getM1().Mort()){
						setChoix("Pokemon");
						fintour=true;
					}
					validate();
					repaint();
					combat.repaint();
				}
			}, timee);


	}

	public void attaqueEnnemi(){
		double b=0;
		for(int i=0;i<4;i++){
			if(combat.getM1().getSort()[i]!=null) b+=1;
		}
		b=(int)(Math.random()*b);
		setTexte(combat.getM2().getNom()+" ennemie utilise "+combat.getM2().getSort()[(int)b].toString());
		combat.getM2().utiliserSort((int)b,combat.getM1());
		validate();
		repaint();
		combat.repaint();
	}
}
