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
	
	public boolean deplacement(char c, int r){
		boolean a = false;
		if((r == this.rangee - 1 || r == this.rangee + 1 || r == this.rangee) && ( c == this.colonne - 1 || c == this.colonne + 1 || c == this.colonne)){
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