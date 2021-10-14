public class Roi extends Piece{
	
	public Roi(int x, int y){
		super(x,y);
		this.nom = "Roi";
		this.premier_mvt = false;
//		if(this.couleur == "Blanc"){
//			this.apparence = "RB";
//		}
//		else{
//			this.apparence = "RN";
//		}
	}
	
	public boolean testDeplacement(int x2, int y2){
		int x1 = this.colonne;
		int y1 = this.rangee;
		
		if( Math.max(Math.abs(x2-x1), Math.abs(y2-y1)) == 1){
			this.premier_mvt = true;
			return true;
		}

			return false;
    }
	
//	public String getApparence(){
//		return this.apparence;
//	}
}