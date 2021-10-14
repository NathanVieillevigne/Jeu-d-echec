
public class Piece {
	
	protected String nom;
//	protected String apparence;
	protected int colonne;
	protected int rangee;
	protected boolean couleur;
	protected boolean premier_mvt = false;
	
	public Piece(){
		this.nom = "";
		this.colonne = 0;
		//this.apparence = null;
		this.rangee = 0;
		this.couleur = true;
	}
	
	public Piece(int x, int y){
		this.nom = null;
		this.colonne = x;
		this.rangee = y;
		//this.apparence = null;
		if(y==0 || y == 1)	this.couleur = true;
			else			this.couleur = false;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public boolean getCouleur(){
		return this.couleur;
	}
	
	public int getColonne(){
		return this.colonne;
	}
	
	public int getRangee(){
		return this.rangee;
	}
	
	public void setNom(String n){
		this.nom = n;
	}
	
	public void setColonne(int x){
		this.colonne = x;
	}
	
	public void setCouleur(boolean c){
		this.couleur = c;
	}
	
	public boolean getPremiermvt(){
		return this.premier_mvt;
	}
	
//	public void setApparence(String c) {
//		this.apparence = c;
//	}
	
	public boolean memeCouleur(Piece p){
		return (couleur == p.couleur);
	}
	
//	public String getApparence(){
//		return this.apparence;
//	}
	
	public void setRangee(int y){
		this.rangee = y;
	}
	
	public boolean testDeplacement(int x, int y){
		if(x < 0) return false;		if(7 < x) return false;
		if(y < 0) return false;		if(7 < y) return false;
	return true;
	}
}
