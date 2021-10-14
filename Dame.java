
public class Dame extends Piece{
	
	public Dame(int x, int y){
		super(x,y);
		this.nom = "Dame";
//		if(this.couleur == "Blanc"){
//			this.apparence = "DB";
//		}
//		else{
//			this.apparence = "DN";
//		}
	}
	
	public boolean testDeplacement(int x2, int y2){
		int x1 = this.colonne;
		int y1 = this.rangee;
		
		if (x1==x2 && y1==y2)	return false;
			
		boolean ok = false;
		if (x1==x2){			ok = true;}
		if (y1==y2){			ok = true;}
		if ((x2-x1)==(y2-y1)){	ok = true;}
		if ((x2-x1)==(y1-y2)){	ok = true;}

		return ok ;
	
	}
	
//	public String getApparence(){
//		return this.apparence;
//	}
}