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
	
	public boolean deplacement(char c, int r){
		boolean a = false;
		if((r != this.rangee && c != this.colonne) && ((r == this.rangee + 1 && (c == this.colonne + 2 ||c == this.colonne - 2)) || (r == this. rangee + 2 && (c == this.colonne - 1 || c == this.colonne + 1)) || (r == this.rangee - 1 && (c == this.colonne + 2 || c == this.colonne -2)) || (r == this.rangee - 2 && (c == this.colonne + 1 || c == this.colonne - 1)))){
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