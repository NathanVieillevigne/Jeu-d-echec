public class Cavalier extends Piece{
	
	public Cavalier(char c, int r){
		super(c,r);
		this.nom = "Cavalier";
		if(this.couleur == "Blanc"){
			this.apparence = "\u265E";
		}
		else{
			this.apparence = "\u2658";
		}
	}
}