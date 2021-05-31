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
		int x1 = this.colonne;
		int y1 = this.rangee;
		int x2 = c;
		int y2 = r;
			
		if(y2 == y1 + 1 && (x2 == x1 + 2 || x2 == x1 - 2))	{ return true;}
		if(y2 == y1 + 2 && (x2 == x1 - 1 || x2 == x1 + 1))	{ return true;}
		if(y2 == y1 - 1 && (x2 == x1 + 2 || x2 == x1 -2))	{ return true;}
		if(y2 == y1 - 2 && (x2 == x1 + 1 || x2 == x1 - 1))	{ return true;}
			
		x1 = x2;
		y1 = y2;
			
		return false;
	}
	
	public String getApparence(){
		return this.apparence;
	}
}