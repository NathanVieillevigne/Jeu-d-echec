public class Pion extends Piece{
	
	public Pion(char c, int r){
		super(c,r);
		this.nom = "Pion";
		if(this.couleur == "Blanc"){
			this.apparence = "\u265F";
		}
		else{
			this.apparence = "\u2659";
		}
	}
	
	public String getApparence(){
		return this.apparence;
	}
	
	public void deplacement(Pion p){
		public action int;
		action = 0;
		
		if (action == 0){
			if (this.couleur == "Blanc" ){
				p.rangee = p.rangee + 2;
			}
			if (this.couleur == "Noir" ){
				p.rangee = p.rangee - 2;
			}
		}
		
		if (this.couleur == "Blanc" ){
				p.rangee = p.rangee + 1;
			}
			if (this.couleur == "Noir" ){
				p.rangee = p.rangee - 1;
			}
	}
	
	public static void main(String[] args) {
		Pion p = new Pion('A',1);
		System.out.println(p.getApparence());
		Pion d =new Pion('A',7);
		System.out.println(d.getApparence());
		
		
		
	}
	
	
	
	
}


