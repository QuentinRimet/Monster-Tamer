package monstre;

import java.util.Arrays;

import Personnage.Dresseur;
import sort.*;
import type.Type;

public class Monstre {
	private String nom;
	private int niv;
	private int exp;
	private int hp;
	private int hpniv;
	private int attaque;
	private int defence;
	private Type type;
	private int attaqueniv;
	private int defenceniv;
	private int vit;
	private int vitniv;
	private Sort[] sort=new Sort[4];
	private Dresseur dresseur;

	//permet d'initialiser les attributs du monstre
	public Monstre(String n,int i,int e,int h,int a,int d,Type t,int v,Dresseur dr){
		//son nom
		nom=n;
		//son niveau
		niv=i;
		//son experience
		exp=e;
		//ses hp par niveau
		hpniv=h;
		//ses hp actuel
		hp=hpniv*niv;
		//ses attaque et defence par niveau
		attaqueniv=a;
		defenceniv=d;
		//ses attaque et defence actuel
		attaque=attaqueniv*niv;
		defence=defenceniv*niv;
		//son type
		type=t;
		//sa vitesse par niveau et actuel
		vitniv=v;
		vit=v*niv;
		//son dresseur
		dresseur=dr;
	}
	
	//permet d'ajouter un Sort si celui-ci est un sort de type normal ou du meme niveau que celui du monstre
	public void ajouterSort(Sort s,int a){
		if(a<4 && a>=0)
		if(s.getType().toString()=="Normal" || s.getType().toString()==type.toString()){
			sort[a]=s;
		}
	}
	
	//permet au monstre d'utiliser un sort
	public void utiliserSort(int a,Monstre m){
		if(a<4 && a>=0 && !m.Mort() && !this.Mort()){
			//si un buff alors on le jette sur soi
			if(sort[a] instanceof Buff)
				((Buff)sort[a]).effet(this);
			//sinon on le jette sur l'ennemie
			if(sort[a] instanceof Attaque)
				((Attaque)sort[a]).effet(this,m);
			//si la cible meurt alors on gagne de l'experience
			if(m.Mort())
				this.gainXP((int)(((Double)(m.getNiv()/(niv*2.0)))*1000.0));		
			}
		
	}
	//permet de soigner le monstre
	public void soigner(int a){
		if(a>0){
			hp+=a;
			if(hp>niv*hpniv){
				hp=niv*hpniv;
			}
		}
	}
	//permet au monstre de prendre des degats
	public void prendreDegats(int a){
		if(a>0){
			hp-=a;
			if(hp<0)
				hp=0;
		}
	}
	
	//permet au monstre de gagner de l'experience
	public void gainXP(int a){
		if(a>0 && niv!=100){
			exp+=a;
			//si assez d'exp alors le monstre gagne un niveau
			if(exp>=1000){
				int c=exp;
				for(int b=0;b<c/1000;b++){
				gainNiv();
				}

			}
		}
	}
	
	//permet au monstre de gagner un niveau
	public void gainNiv(){
		if(niv!=100){
			niv+=1;
			attaque+=attaqueniv;
			defence+=defenceniv;
			hp+=hpniv;
			exp-=1000;
			if(niv==100)
				exp=999;
		}
	}

	public String toString(){
		return "Monstre "+nom+" de type "+type+" : "
				+"\n Niveau : "+niv+"     Experience : "+exp
				+"\n Point de vie : "+hp+"     Vitesse : "+vit
				+"\n Attaque : "+attaque+"     Defence : "+defence;

	}
	public int getNiv() {
		return niv;
	}
	public int getExp() {
		return exp;
	}
	public int getHp() {
		return hp;
	}
	public int getAttaque() {
		return attaque;
	}
	public int getDefence() {
		return defence;
	}
	public Type getType() {
		return type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getHpniv() {
		return hpniv;
	}
	public void setHpniv(int hpniv) {
		this.hpniv = hpniv;
	}
	public int getAttaqueniv() {
		return attaqueniv;
	}
	public void setAttaqueniv(int attaqueniv) {
		this.attaqueniv = attaqueniv;
	}
	public int getDefenceniv() {
		return defenceniv;
	}
	public void setDefenceniv(int defenceniv) {
		this.defenceniv = defenceniv;
	}
	public int getVit() {
		return vit;
	}
	public void setVit(int vit) {
		this.vit = vit;
	}
	public int getVitniv() {
		return vitniv;
	}
	public void setVitniv(int vitniv) {
		this.vitniv = vitniv;
	}
	public void setNiv(int niv) {
		this.niv = niv;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Sort[] getSort() {
		return sort;
	}
	public void setSort(Sort[] sort) {
		this.sort = sort;
	}
	
	//permet de savoir si le monstre est mort
	public boolean Mort(){
		if (hp==0)
			return true;
		return false;
	}

	
}
