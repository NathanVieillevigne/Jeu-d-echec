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
	public int chartoInt(char c){
		int a;
		if(c == 'A'){
			a = 0;
		}
		else if(c == 'B'){
			a = 1;
		}	
		else if(c == 'C'){
			a = 2;
		} 
		else if (c == 'D'){
			a = 3;
		}
		else if (c == 'E'){
			a = 4;
		} 
		else if(c == 'F'){
			a = 5;
		}
		else if(c == 'G'){
			a = 6;
		}
		else if(c == 'H'){
			a = 7;
		}
		else{
			a = 0;
		}
		return a;
	}
	
	public void deplacementPiece(char c1,int r1, char c2, int r2){
		int c11 = this.chartoInt(c1);
		int c12 = this.chartoInt(c2);
		if(this.cases[r1-1][c11] != this.cases[r2-1][c12] && this.cases[r1-1][c11].contenu != null){
			if(this.cases[r2-1][c12].contenu != null){
				if(this.cases[r1-1][c11].contenu.memeCouleur(this.cases[r2-1][c12].contenu) != true){
					if(this.cases[r1-1][c11].getContenu().deplacement(c2,r2) == true){
						this.cases[r2-1][c12].contenu = this.cases[r1-1][c11].contenu;
						this.cases[r1-1][c11].contenu = null;
					}
				}
			}	
			
			else if(this.cases[r1-1][c11].getContenu().deplacement(c2,r2) == true){
				this.cases[r2-1][c12].contenu = this.cases[r1-1][c11].contenu;
				this.cases[r1-1][c11].contenu = null;
			}
		}
		this.affichage();
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
}