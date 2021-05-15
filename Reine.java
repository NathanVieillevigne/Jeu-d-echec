public class Reine extends Piece{
	
	public Reine(String n, char c, int r){
		super(n,c,r);
		if(this.couleur == "Blanc"){
			this.apparence = "\u265B";
		}
		else{
			this.apparence = "\u2655";
		}
	}
}