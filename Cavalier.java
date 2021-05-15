public class Cavalier extends Piece{
	
	public Cavalier(char c, int r){
		super(c,r);
		this.nom = "Cavalier";
		if(this.couleur == "Blanc"){
			this.apparence = "CB";
		}
		else{
			this.apparence = "CN";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
}