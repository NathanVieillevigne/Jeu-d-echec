public class Tour extends Piece{
	
	public Tour(String n, char c, int r){
		super(n,c,r);
		if(this.couleur == "Blanc"){
			this.apparence = "\u265C";
		}
		else{
			this.apparence = "\u2656";
		}
	}
}