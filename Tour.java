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
	
	public boolean deplacement(char c, int r){
		boolean a = false;
		if((r != this.rangee && c == this.colonne) || (c != this.colonne && r == this.rangee))  {
			this.colonne = c;
			this.rangee = r;
			a = true;
		}
		return a;
	}
	
	public String getApparence(){
		return this.apparence;
	}
}