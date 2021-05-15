public class Tour extends Piece{
	
	public Tour(char c, int r){
		super(c,r);
		this.nom = "Tour";
		if(this.couleur == "Blanc"){
			this.apparence = "TB";
		}
		else{
			this.apparence = "TN";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
}