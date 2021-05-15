public class Roi extends Piece{
	
	public Roi(char c, int r){
		super(c,r);
		this.nom = "Roi";
		if(this.couleur == "Blanc"){
			this.apparence = "\u265A";
		}
		else{
			this.apparence = "\u2654";
		}
	}
}