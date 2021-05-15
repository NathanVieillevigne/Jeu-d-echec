public class Pion extends Piece{
	
	public Pion(String n, char c, int r){
		super(n,c,r);
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
		Pion p = new Pion("Pion",'A',1);
		System.out.println(p.getApparence());
		Pion d =new Pion("Pion",'A',7);
		System.out.println(d.getApparence());
	}
}