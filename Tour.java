public class Tour extends Piece{
	
	public Tour(char c, int r){
		super(c,r);
		this.nom = "Tour";
		if(this.couleur == "Blanc"){
			this.apparence = "\u265C";
		}
		else{
			this.apparence = "\u2656";
		}
	}
}