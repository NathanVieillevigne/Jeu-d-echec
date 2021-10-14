public class Pion extends Piece{
	
	public Pion(int x, int y){
		super(x,y);
		this.nom = "Pion";
//		if(this.couleur == "Blanc"){
//			this.apparence = "PB";
//		}
//		else{
//			this.apparence = "PN";
//		}
	}
	
//	public String getApparence(){
//		return this.apparence;
//	}
	
	public boolean testDeplacement(int x, int y){
		boolean a = false;
		if(this.colonne != x) return false;
		if(this.couleur == false){
			if(this.premier_mvt == false){
				if(y != this.rangee && (y == this.rangee - 2 || y == this.rangee - 1)){
					a = true;
					this.premier_mvt = true;
				}
			}
			else if(y != this.rangee && y == this.rangee - 1){
				a = true;
				this.premier_mvt = true;
			}
		}
		
		if(this.couleur == true){
			if(this.premier_mvt == false){
				if(y != this.rangee && (y == this.rangee + 2 || y == this.rangee + 1)){
					a = true;
					this.premier_mvt = true;
				}
			}
			else if(y != this.rangee && y == this.rangee + 1){
				a = true;
				this.premier_mvt = true;
			}
		}
		return a;
}

	public boolean testDeplacementPourManger(int x, int y){
		if(this.couleur == true){
			if(x==colonne+1 || x==colonne-1){
				if(y==rangee+1){ 
					this.premier_mvt = true;
					return true;
				}
			}
		}
		if(this.couleur == false){
			if(x==colonne+1 || x==colonne-1){
				if(y==rangee-1){
					this.premier_mvt = true;
					return true;
				}
			}
		}
		return false;
}

}