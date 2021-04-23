import java.util.*;

public class Plateau {
	
	private Case[][] cases;
	
	public Plateau(){
		this.cases = new Case[8][8];
		for(int i = 0;i<8;i++){
			char a = 'A';
			for(int y = 0;y<8;y++){
				this.cases[i][y] = new Case(a,i+1);
				a++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Plateau plateaudejeu = new Plateau();
		System.out.println(plateaudejeu.cases[0][1].getRangee());
	}
}