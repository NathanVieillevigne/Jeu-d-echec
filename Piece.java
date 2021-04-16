import java.util.*;

public class Piece {
	
	private String nom;
	private String colonne;
	private int rangee;
	
	public Piece(){
		this.nom = new String();
		this.colonne = new String();
		this.rangee = 0;
	}
	
	public Piece(String n,String c,int r){
		this.nom = n;
		this.colonne = c;
		this.rangee = r;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getColonne(){
		return colonne;
	}
	
	public int getRangee(){
		return rangee;
	}
	
	public void setNom(String n){
		this.nom = n;
	}
	
	public void setColonne(String c){
		this.colonne = c;
	}
	
	public void setRangee(int r){
		this.rangee = r;
	}
	
	public void deplacement(String c,int r){
		if(c == "A" || c == "B" || c == "C" || c == "D" || c == "E" || c == "F" || c == "G" || c == "H" && r == 1 || r == 2 || r == 3 || r == 4 || r == 5 || r == 6 || r == 7 || r == 8){
			this.colonne = c;
			this.rangee = r;
		}
	}
}
