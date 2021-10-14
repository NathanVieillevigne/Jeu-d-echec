public class Tour extends Piece{
	
	public Tour(int x, int y){
		super(x,y);
		this.nom = "Tour";
		this.premier_mvt = false;
//		if(this.couleur == "Blanc"){
//			this.apparence = "TB";
//		}
//		else{
//			this.apparence = "TN";
//		}
	}
	
	public boolean testDeplacement(int x2, int y2){
		int x1 = this.colonne;
		int y1 = this.rangee;
		
		if (x1==x2 && y1==y2)			return false;
		
		boolean ok = false;
		if (x1==x2){
			this.premier_mvt = true;
			ok = true;
		}
		if (y1==y2){	
			this.premier_mvt = true;
			ok = true;
			}
		
		return ok;
	}
	
//	public String getApparence(){
//		return this.apparence;
//	}
}