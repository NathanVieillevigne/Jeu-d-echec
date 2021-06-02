
public class PlateauTest {
	
	public static void main(String[] args) {
		Plateau plateaudejeu = new Plateau();
		//plateaudejeu.affichage();
		//plateaudejeu.deplacementPiece('C',7,'C',6);
		//plateaudejeu.deplacementPiece('B',7,'B',6);
		//plateaudejeu.deplacementPiece('C',8,'A',6);
		//plateaudejeu.deplacementPiece('D',8,'C',8);
		//plateaudejeu.deplacementPiece('B',1,'A',3);

		//Future fichier texte
		final String[] partie = {
				"D2D4",
				"D7D5",
				"C2C4",
				"C7C6",
				"B1C3",
				"G8F6",
				"H2H3"};
		
		plateaudejeu.jouerPartie(partie);
	}
}