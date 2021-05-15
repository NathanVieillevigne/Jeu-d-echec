import java.util.*;

public class Plateau {
	
	private Case[][] cases;
	
	public Plateau(){
		this.cases = new Case[8][8];
		for(int i = 0;i<8;i++){
			char a = 'A';
			for(int y = 0;y<8;y++){
				if(i == 0){
					cases[i][0] = new Case(new Tour('A',1),'A',1);
					cases[i][1] = new Case(new Cavalier('B',1),'B',1);
					cases[i][2] = new Case(new Fou('C',1),'C',1);
					cases[i][3] = new Case(new Dame('D',1),'D',1);
					cases[i][4] = new Case(new Roi('E',1),'E',1);
					cases[i][5] = new Case(new Fou('F',1),'F',1);
					cases[i][6] = new Case(new Cavalier('G',1),'G',1);
					cases[i][7] = new Case(new Tour('H',1),'H',1);
					y = 8;
				}
				else if(i == 1 || i == 6){
					this.cases[i][y] = new Case(new Pion(a,i+1),a,i+1);
					a++;
				}
				else if(i == 7){
					cases[i][0] = new Case(new Tour('A',8),'A',8);
					cases[i][1] = new Case(new Cavalier('B',8),'B',8);
					cases[i][2] = new Case(new Fou('C',8),'C',8);
					cases[i][3] = new Case(new Dame('D',8),'D',8);
					cases[i][4] = new Case(new Roi('E',8),'E',8);
					cases[i][5] = new Case(new Fou('F',8),'F',8);
					cases[i][6] = new Case(new Cavalier('G',8),'G',8);
					cases[i][7] = new Case(new Tour('H',8),'H',8);
					y = 8;
				}
				else{	
					this.cases[i][y] = new Case(a,i+1);
					a++;
				}
			}
		}
	}
	
	public void affichage(){
		String s;
		System.out.println(" "+"  A   B   C   D   E   F   G   H");
		for(int i = 0; i<8; i++){
			System.out.println(" "+"----------------------------------");
			s = "" + (-i+8);
			for(int y = 0; y<8;y++){
				if(this.cases[i][y].getContenu() == null){
					s = s + "|   ";
				}
				else{
					s = s + "| " + this.cases[i][y].getContenu().getApparence();
				}
			}
			s = s +" |";
			System.out.println(s);
		}
		System.out.println(" "+"----------------------------------");
	}		
					
				
	public static void main(String[] args) {
		Plateau plateaudejeu = new Plateau();
		System.out.println(plateaudejeu.cases[3][3].getColonne());
		plateaudejeu.affichage();
	}
}