import java.util.*;

public class Piece {
	
	private String nom;
	protected String apparence;
	private char colonne;
	private int rangee;
	protected String couleur;
	
	public Piece(){
		this.nom = new String();
		this.colonne = 'A';
		this.apparence = null;
		this.rangee = 0;
		this.couleur = new String();
	}
	
	public Piece(String n,char c,int r){
		this.nom = n;
		this.colonne = c;
		this.rangee = r;
		this.apparence = null;
		if(r > 0 && r <= 2){
			this.couleur = "Blanc";
		}
		if(r >= 7 && r < 9){
			this.couleur = "Noir";
		}
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getCouleur(){
		return this.couleur;
	}
	
	public char getColonne(){
		return this.colonne;
	}
	
	public int getRangee(){
		return this.rangee;
	}
	
	public void setNom(String n){
		this.nom = n;
	}
	
	public void setColonne(char c){
		this.colonne = c;
	}
	
	public void setRangee(int r){
		this.rangee = r;
	}
	
	public void deplacement(char c,int r){
		if((c >= 'A' && c <= 'H') && (r > 0 && r < 9)){
			this.colonne = c;
			this.rangee = r;
		}
	}
}
