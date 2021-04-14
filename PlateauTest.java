import java.util.*;

public class PlateauTest {
	
	public static void main(String[] args) {
		boolean a;
		Scanner input = new Scanner(System.in);
		a = false;
		while (a==false){
			System.out.println(" "+" A   B   C   D   E   F   G   H");
			for (int i=0;i<8;i++){
				System.out.println(" "+"---------------------------------");
				System.out.println((-i+8)+"|   |   |   |   |   |   |   |   |");
				System.out.println(" "+"|   |   |   |   |   |   |   |   |");
			}
			System.out.println(" "+"---------------------------------");
			a = input.nextBoolean();
		}
	}
}
			
			