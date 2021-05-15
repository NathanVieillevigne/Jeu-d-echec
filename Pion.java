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
	
	public static void main(String[] args) {
		Pion p = new Pion('A',1);
		System.out.println(p.getApparence());
		Pion d =new Pion('A',7);
		System.out.println(d.getApparence());
	}
}