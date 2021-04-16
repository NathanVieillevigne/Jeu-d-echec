import java.util.*;

public class Case {

	private Piece[] contenu;
	private String colonne;
	private int rangee;
	
	public Case(){
		this.contenu[0]= new Piece();
		this.colonne = new String();
		this.rangee = 0;
	}
	
	public Case(Piece p,String c, int r){
		this.contenu[0]= p;
		this.colonne = c;
		this.rangee = r;
	}
	
	public Case(String c, int r){
		this.contenu[0]= new Piece();
		this.colonne = c;
		this.rangee = r;
	}
	
	public Piece[] getContenu(){
		return contenu;
	}
	
	public String getColonne(){
		return colonne;
	}
	
	public int getRangee(){
		return rangee;
	}
	
	public void setContenu(Piece p){
		this.contenu[0] = p;
	}
	
	public void setColonne(String c){
		this.colonne = c;
	}
	
	public void setRangee(int r){
		this.rangee = r;
	}
}	