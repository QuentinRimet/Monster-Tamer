package combat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Personnage.Dresseur;
import monstre.*;

public class afficheCombat extends JPanel{
	private Dresseur dr;
	private Dresseur dr1;
	private Monstre m1;
	private Monstre m2;

	//on initialise le combat
	public afficheCombat(Dresseur d,Dresseur d1){
		dr=d;
		dr1=d1;
		m1=d.getMonstre()[d.getActif()];
		m2=d1.getMonstre()[d1.getActif()];
		this.setPreferredSize(new Dimension(480,300));
	}
	
	public void changerMonstreEnnemie(){
		m2=dr1.getMonstre()[dr1.envoiProch()];
	}
	
	public void changerMonstre(int i){
		m1=dr.getMonstre()[i];
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//mise en place des monstres avec l'arene

		try {
			BufferedImage image;


			image = ImageIO.read(new File("sprite/Combat1.png"));
			g.drawImage(image,-02,-102,505,405, null);
			
			//monstre allié
			if(!m1.Mort()){
				if(m1 instanceof Gobou){
					image = ImageIO.read(new File("sprite/Gobou.png"));
					g.drawImage(image,20,116,200,200, null);
				}else
					if(m1 instanceof Salameche){
						image = ImageIO.read(new File("sprite/Sala.png"));
						g.drawImage(image,20,127,200,200, null);
					}else
						if(m1 instanceof Pikachu){
							image = ImageIO.read(new File("sprite/pikachu.png"));
							g.drawImage(image,10,116,200,200, null);
						}
						else
							if(m1 instanceof Sabelette){
								image = ImageIO.read(new File("sprite/Sabelette.png"));
								g.drawImage(image,10,140,200,200, null);
							}
			}
			//******************
			//monstre ennemie
			if(!m2.Mort()){
				if(m2 instanceof Gobou){
					image = ImageIO.read(new File("sprite/Gobou1.png"));
					g.drawImage(image,295,10,175,175, null);
				}else
					if(m2 instanceof Salameche){
						image = ImageIO.read(new File("sprite/Sala1.png"));
						g.drawImage(image,270,00,200,200, null);
					}else
						if(m2 instanceof Pikachu){
							image = ImageIO.read(new File("sprite/pikachu1.png"));
							g.drawImage(image,275,00,200,200, null);
						}
						else
							if(m2 instanceof Sabelette){
								image = ImageIO.read(new File("sprite/Sabelette1.png"));
								g.drawImage(image,280,0,200,200, null);
							}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//barre hp des monstres

		g.fillRoundRect(280, 230, 200, 10, 10,10);
		g.fillRoundRect(60, 60, 200, 10, 10,10);

		for(int i=0;i<((((double)m1.getHp())/(m1.getHpniv()*m1.getNiv())))*100;i=i+1){
			g.setColor(new Color(0,150+i,100));
			if(i==0 ){
				g.fillRect(280, 233, 1, 4);
				g.fillRect(281, 232, 1, 6);

			}else
				if(i==1 ){
					g.fillRect(282, 231, 1, 8);
					g.fillRect(283, 230, 1, 10);

				}
				else
					if(i==98){

						g.fillRect(476, 230, 1, 10);
						g.fillRect(477, 231, 1, 10);
					}
					else
						if(i==99){

							g.fillRect(478, 232, 1, 8);
							g.fillRect(479, 233, 1, 6);
						}
						else 
							g.fillRect(280+(i*2), 230, 2, 10);

		}
		for(int i=0;i<((((double)m2.getHp())/(m2.getHpniv()*m2.getNiv())))*100;i=i+1){
			g.setColor(new Color(0,150+i,100));
			if(i==0 ){
				g.fillRect(60, 63, 1, 4);
				g.fillRect(61, 62, 1, 6);

			}else
				if(i==1 ){
					g.fillRect(62, 61, 1, 8);
					g.fillRect(63, 60, 1, 10);

				}
				else
					if(i==98){

						g.fillRect(256, 60, 1, 10);
						g.fillRect(257, 61, 1, 10);
					}
					else
						if(i==99){

							g.fillRect(258, 62, 1, 8);
							g.fillRect(259, 63, 1, 6);
						}
						else 
							g.fillRect(60+(i*2), 60, 2, 10);

		}
		g.setColor(Color.black);
		g.drawRoundRect(280, 230, 200, 10, 10,10);
		g.drawRoundRect(60, 60, 200, 10, 10,10);

		//barre xp

		g.fillRoundRect(290, 245, 180, 5, 3,3);

		for(int i=0;i<(((double)m1.getExp())/1000)*80;i=i+1){
			g.setColor(new Color(0,150+i/2,200));
			if(i==0 ){

				g.fillRect(291, 245, 1, 5);
			}


			else
				if(i==79){
					g.fillRect((int)(290+(i*2.25)), 245, 2, 5);
					g.fillRect((int)(291+(i*2.25)), 245, 2, 5);

				}
				else 
					g.fillRect((int)(290+(i*2.25)), 245, 2, 5);

		}
		g.setColor(Color.black);
		g.drawRoundRect(290, 245, 180, 5, 3,3);

		//info du monstre

		g.setFont(new Font("default", Font.BOLD, 15));
		g.drawString(m2.getNom(),60 , 59);
		g.drawString("lv. "+m2.getNiv(),210 , 59);
		g.drawString(m1.getNom(),280 , 229);
		g.drawString("lv. "+m1.getNiv(),430 , 229);
		g.setFont(new Font("default", 1, 12));
		g.setColor(Color.white);
		g.drawString(m1.getHp()+"/"+m1.getHpniv()*m1.getNiv(),285,240);
	}

	public Dresseur getDr() {
		return dr;
	}

	public Dresseur getDr1() {
		return dr1;
	}

	public Monstre getM1() {
		return m1;
	}

	public Monstre getM2() {
		return m2;
	}

	public void setDr(Dresseur dr) {
		this.dr = dr;
	}

	public void setDr1(Dresseur dr1) {
		this.dr1 = dr1;
	}

	public void setM1(Monstre m1) {
		this.m1 = m1;
	}

	public void setM2(Monstre m2) {
		this.m2 = m2;
	}

}
