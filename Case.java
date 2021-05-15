import java.util.*;

public class Case {

	private Piece contenu;
	private char colonne;
	private int rangee;
	
	public Case(){
		this.contenu = new Piece();
		this.colonne = 'A';
		this.rangee = 0;
	}
	
	public Case(Piece p,char c, int r){
		this.contenu = p;
		this.colonne = c;
		this.rangee = r;
	}
	
	public Case(char c, int r){
		this.contenu = new Piece();
		this.colonne = c;
		this.rangee = r;
	}
	
	public Piece getContenu(){
		return this.contenu;
	}
	
	public char getColonne(){
		return this.colonne;
	}
	
	public int getRangee(){
		return this.rangee;
	}
	
	public void setContenu(Piece p){
		this.contenu = p;
	}
	
	public void setColonne(char c){
		this.colonne = c;
	}
	
	public void setRangee(int r){
		this.rangee = r;
	}
	
	public static void main(String[] args) {
		Case a = new Case('B',5);
		System.out.println(a.getColonne());
		a.setColonne('C');
		System.out.println(a.getColonne());
		Case b = new Case(new Piece("Fou",'A',2),'A',2);
		System.out.println(b.getContenu().getCouleur());
		b.getContenu().setRangee(1);
		System.out.println(b.getContenu().getCouleur());
		System.out.println(b.getContenu().getRangee());
	}
}	