
public class Fou extends Piece{
	
	public Fou(int x, int y){
		super(x,y);
		this.nom = "Fou";
//		if(this.couleur == "Blanc"){
//			this.apparence = "FB";
//		}
//		else{
//			this.apparence = "FN";
//		}
	}
	
	public boolean testDeplacement(int x2, int y2){
		int x1 = this.colonne;
		int y1 = this.rangee;
		
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);

		if (dx==dy) return true;
 				    return false;
	}
	
//	public String getApparence(){
//		return this.apparence;
//	}
}