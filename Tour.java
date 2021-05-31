public class Tour extends Piece{
	
	public Tour(char c, int r){
		super(c,r);
		this.nom = "Tour";
		if(this.couleur == "Blanc"){
			this.apparence = "TB";
		}
		else{
			this.apparence = "TN";
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
		if (x1==x2){				ok = true;}
		if (y1==y2){				ok = true;}
		
		if ( ! ok ){
			return false;
		}
				
		x1 = x2;
		y1 = y2;
		return true ;
	}
	
	public String getApparence(){
		return this.apparence;
	}
}