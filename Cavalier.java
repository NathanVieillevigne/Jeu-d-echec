public class Cavalier extends Piece{
	
	public Cavalier(String n, char c, int r){
		super(n,c,r);
		if(this.couleur == "Blanc"){
			this.apparence = "\u265E";
		}
		else{
			this.apparence = "\u2658";
		}
	}
}