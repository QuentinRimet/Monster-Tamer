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

	public Monstre(String n,int i,int e,int h,int a,int d,Type t,int v,Dresseur dr){
		nom=n;
		niv=i;
		exp=e;
		hpniv=h;
		hp=hpniv*niv;
		attaqueniv=a;
		defenceniv=d;
		attaque=attaqueniv*niv;
		defence=defenceniv*niv;
		type=t;
		vitniv=v;
		vit=v*niv;
		dresseur=dr;
	}
	
	public void ajouterSort(Sort s,int a){
		if(a<4 && a>=0)
		if(s.getType().toString()=="Normal" || s.getType().toString()==type.toString()){
			sort[a]=s;
		}
	}
	
	public void utiliserSort(int a,Monstre m){
		if(a<4 && a>=0 && !m.Mort() && !this.Mort()){
			if(sort[a] instanceof Buff)
				((Buff)sort[a]).effet(this);
			if(sort[a] instanceof Attaque)
				((Attaque)sort[a]).effet(this,m);
			if(m.Mort())
				this.gainXP((int)(((Double)(m.getNiv()/(niv*2.0)))*1000.0));		
			}
		
	}
	public void soigner(int a){
		if(a>0){
			hp+=a;
			if(hp>niv*hpniv){
				hp=niv*hpniv;
			}
		}
	}
	public void prendreDegats(int a){
		if(a>0){
			hp-=a;
			if(hp<0)
				hp=0;
		}
	}

	public void gainXP(int a){
		if(a>0 && niv!=100){
			exp+=a;
			if(exp>=1000){
				int c=exp;
				for(int b=0;b<c/1000;b++){
				gainNiv();
				}

			}
		}
	}

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
	public boolean Mort(){
		if (hp==0)
			return true;
		return false;
	}

	
}
