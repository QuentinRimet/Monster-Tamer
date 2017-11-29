package type;

public class Type {
	public static final Type Normal=new Type("Normal","","");
	public static final Type Eau=new Type("Eau","Air","Feu");
	public static final Type Feu=new Type("Feu","Eau","Terre");
	public static final Type Air=new Type("Air","Terre","Eau");
	public static final Type Terre=new Type("Terre","Feu","Air");
	private String nom;
	private String faiblesse;
	private String force;
	
	public Type(String n,String s,String t){
		nom=n;
		faiblesse=s;
		force=t;
		}

	public String getFaiblesse() {
		return faiblesse;
	}

	public String getForce() {
		return force;
	}
	
	public String toString(){
		return nom;
	}
}
