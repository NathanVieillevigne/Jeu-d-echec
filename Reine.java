public class Reine extends Piece{
	
	public Reine(char c, int r){
		super(c,r);
		this.nom = "Reine";
		if(this.couleur == "Blanc"){
			this.apparence = "\u265B";
		}
		else{
			this.apparence = "\u2655";
		}
	}
}