public class Fou extends Piece{
	
	public Fou(char c, int r){
		super(c,r);
		this.nom = "Fou";
		if(this.couleur == "Blanc"){
			this.apparence = "\u265D";
		}
		else{
			this.apparence = "\u2657";
		}
	}
}