public class Cavalier extends Piece{
	
	public Cavalier(int x, int y){
		super(x,y);
		this.nom = "Cavalier";
//		if(this.couleur == "Blanc"){
//			this.apparence = "CB";
//		}
//		else{
//			this.apparence = "CN";
//		}
	}
	
	public boolean testDeplacement(int x2, int y2){
		int x1 = this.colonne;
		int y1 = this.rangee; 
			
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);
		//System.out.println("Cavalier "+dx+","+dy);

		if (dx==2 && dy==1) return true;
		if (dx==1 && dy==2) return true;
						   return false;
	}
	
//	public String getApparence(){
//		return this.apparence;
//	}
}