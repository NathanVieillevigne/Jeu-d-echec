public class Roi extends Piece{
	
	public Roi(char c, int r){
		super(c,r);
		this.nom = "Roi";
		if(this.couleur == "Blanc"){
			this.apparence = "RB";
		}
		else{
			this.apparence = "RN";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
}