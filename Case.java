public class Case {

	protected Piece contenu;
	protected int colonne;
	protected int rangee;
	
	public Case(){
		this.contenu = new Piece();
		this.colonne = 0;
		this.rangee = 0;
	}
	
	public Case(Piece p){
		this.contenu = p;
		this.colonne = p.getColonne();
		this.rangee  = p.getRangee();
	}
	
	public Case(int x, int y){
		this.contenu = null;
		this.colonne = x;
		this.rangee = y;
	}
	
	public Piece getContenu(){
		return this.contenu;
	}
	
	public int getColonne(){
		return this.colonne;
	}
	
	public int getRangee(){
		return this.rangee;
	}
	
	public void setContenu(Piece p){
		this.contenu = p;
	}
	
	public void setColonne(char c){
		this.colonne = c;
	}
	
	public void setRangee(int r){
		this.rangee = r;
	}
}	