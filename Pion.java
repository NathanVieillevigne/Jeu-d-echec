
public class Pion extends Piece{
	
	public Pion(char c, int r){
		super(c,r);
		this.nom = "Pion";
		if(this.couleur == "Blanc"){
			this.apparence = "PB";
		}
		else{
			this.apparence = "PN";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
	
	public boolean deplacement(char c, int r){
		boolean a = false;
		if(this.couleur == "Noir"){
			if(this.premier_mvt == false){
				if(r != this.rangee && (r == this.rangee + 2 || r == this.rangee + 1)){
					this.colonne = c;
					this.rangee = r;
					a = true;
					this.premier_mvt = true;
				}
			}
			else if(r != this.rangee && r == this.rangee + 1){
				this.colonne = c;
				this.rangee = r;
				a = true;
			}
		}
		if(this.couleur == "Blanc"){
			if(this.premier_mvt == false){
				if(r != this.rangee && (r == this.rangee - 2 || r == this.rangee - 1)){
					this.colonne = c;
					this.rangee = r;
					a = true;
					this.premier_mvt = true;
				}
			}
			else if(r != this.rangee && r == this.rangee - 1){
				this.colonne = c;
				this.rangee = r;
				a = true;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		Pion p = new Pion('A',1);
		System.out.println(p.getApparence());
		Pion d =new Pion('A',7);
		System.out.println(d.getApparence());
	}
}