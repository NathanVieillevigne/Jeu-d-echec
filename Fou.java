import java.lang.Math.*;

public class Fou extends Piece{
	
	public Fou(char c, int r){
		super(c,r);
		this.nom = "Fou";
		if(this.couleur == "Blanc"){
			this.apparence = "FB";
		}
		else{
			this.apparence = "FN";
		}
	}
	
	public boolean deplacement(char c, int r){
		boolean a = false;
		int b = Math.abs(this.rangee - r);
		if((r != this.rangee && c != this.colonne) && ((c == this.colonne + b && r == this.rangee + b) || (c == this.colonne + b && r == this.rangee - b) || (c == this.colonne - b && r == this.rangee + b) || (c == this.colonne - b && r == this.rangee - b))){
			this.colonne = c;
			this.rangee = r;
			a = true;
		}
		return a;
	}
	
	public String getApparence(){
		return this.apparence;
	}
}