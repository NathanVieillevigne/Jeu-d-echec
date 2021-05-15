public class Fou extends Piece{
	
	public Fou(char c, int r){
		super(c,r);
		this.nom = "Fou";
		if(this.couleur == "Blanc"){
			this.apparence = "FB";
		}
		else{
			this.apparence = "FN";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
}