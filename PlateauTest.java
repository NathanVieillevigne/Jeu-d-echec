import java.util.*;

public class PlateauTest {
	
	public static void main(String[] args) {
		Plateau plateaudejeu = new Plateau();
		plateaudejeu.affichage();
		plateaudejeu.deplacementPiece('B',7,'B',6);
		plateaudejeu.deplacementPiece('B',6,'B',5);
		plateaudejeu.deplacementPiece('B',5,'B',6);
		plateaudejeu.deplacementPiece('B',2,'B',3);
		plateaudejeu.deplacementPiece('B',3,'B',4);
		plateaudejeu.deplacementPiece('B',4,'B',5);
		plateaudejeu.deplacementPiece('C',7,'C',5);
		plateaudejeu.deplacementPiece('C',5,'C',3);
		plateaudejeu.deplacementPiece('B',8,'C',6);
		plateaudejeu.deplacementPiece('C',6,'E',5);
		plateaudejeu.deplacementPiece('E',5,'D',3);
		plateaudejeu.deplacementPiece('D',3,'C',5);
		plateaudejeu.deplacementPiece('C',8,'A',6);
		plateaudejeu.deplacementPiece('A',6,'C',4);
		plateaudejeu.deplacementPiece('C',4,'E',6);
		plateaudejeu.deplacementPiece('A',8,'A',1);
		plateaudejeu.deplacementPiece('H',8,'A',8);
		plateaudejeu.deplacementPiece('A',8,'B',5);
		plateaudejeu.deplacementPiece('D',8,'H',8);
		plateaudejeu.deplacementPiece('H',8,'H',5);
		plateaudejeu.deplacementPiece('H',5,'E',2);
		plateaudejeu.deplacementPiece('E',2,'F',4);
		plateaudejeu.deplacementPiece('E',8,'D',8);
		plateaudejeu.deplacementPiece('D',8,'C',7);
		plateaudejeu.deplacementPiece('C',7,'C',6);
		plateaudejeu.deplacementPiece('C',6,'A',6);
		
	}
}
			
			