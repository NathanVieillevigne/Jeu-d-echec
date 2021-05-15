public class Fou extends Piece{
	
	public Fou(String n, char c, int r){
		super(n,c,r);
		if(this.couleur == "Blanc"){
			this.apparence = "\u265D";
		}
		else{
			this.apparence = "\u2657";
		}
	}
}