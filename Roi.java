public class Roi extends Piece{
	
	public Roi(String n, char c, int r){
		super(n,c,r);
		if(this.couleur == "Blanc"){
			this.apparence = "\u265A";
		}
		else{
			this.apparence = "\u2654";
		}
	}
}