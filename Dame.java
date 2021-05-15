public class Dame extends Piece{
	
	public Dame(char c, int r){
		super(c,r);
		this.nom = "Reine";
		if(this.couleur == "Blanc"){
			this.apparence = "DB";
		}
		else{
			this.apparence = "DN";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
}