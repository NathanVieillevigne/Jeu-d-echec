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
		int x1 = this.colonne;
		int y1 = this.rangee;
		int x2 = c;
		int y2 = r;
		
		if (x1==x2 && y1==y2){
			return false;
		}
		
		boolean ok = false;
		if ((x2-x1)==(y2-y1)){	ok = true;}
		if ((x2-x1)==(y1-y2)){	ok = true;}
		
		if ( ! ok )
			return false;
				
		x1 = x2;
		y1 = y2;
		return true ;
	}
	
	public String getApparence(){
		return this.apparence;
	}
}