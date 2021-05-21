import java.lang.Math.*;

public class Dame extends Piece{
	
	public Dame(char c, int r){
		super(c,r);
		this.nom = "Reine";
		if(this.couleur == "Blanc"){
			this.apparence = "DB";
		}
		else{
			this.apparence = "DN";
		}
	}
	
	public boolean deplacement(char c, int r){
		boolean a = false;
		int b = Math.abs(this.rangee - r);
		if(((r != this.rangee && c == this.colonne) || (c != this.colonne && r == this.rangee)) || ((r != this.rangee && c != this.colonne) && ((c == this.colonne + b && r == this.rangee + b) || (c == this.colonne + b && r == this.rangee - b) || (c == this.colonne - b && r == this.rangee + b) || (c == this.colonne - b && r == this.rangee - b)))){
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