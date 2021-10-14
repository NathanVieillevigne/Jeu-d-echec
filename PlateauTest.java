import java.util.*;

public class PlateauTest {
	
	public static void main(String[] args) {
		Plateau plateaudejeu = new Plateau();
		Scanner input = new Scanner(System.in);
		boolean joueur = plateaudejeu.couleurJoueurActif = true;
		
		char choix = 'A';
		while(choix != 'Y' && choix != 'N'){
			System.out.println("Souhaitez-vous charger une partie? (Y/N)");
			choix = input.next().charAt(0);
			if(choix == 'Y') plateaudejeu.charger();
		}
		
		//if(choix == 'N') {
			plateaudejeu.affichage();
			String action = "Z9Q7";
			choix = 'Y';
			while(choix != 'N'){
			//while( ! plateaudejeu.testRoiEchec(joueur)) {
				while( ! plateaudejeu.jouerCoup(action.charAt(0)-'A', action.charAt(1)-'1',
						action.charAt(2)-'A', action.charAt(3)-'1')){
				//while(plateaudejeu.cases[action.charAt(0)-'A'][action.charAt(1)-'1'].getcouleur() != joueur){
					System.out.println("\n Entr馥 un deplacement");
					action = input.next();
				}
				joueur = plateaudejeu.couleurJoueurActif;
				plateaudejeu.affichage();
				System.out.println("Souhaitez-vous continuer?(Y/N)");
				choix = input.next().charAt(0);
				System.out.println("C'est au tour du joueur "+joueur);
				System.out.println(plateaudejeu.getHistorique());
			}
		//}
			
		
		//plateaudejeu.jouerCoup(3,3,4,2);
		//plateaudejeu.affichage();
		//plateaudejeu.affichage();
		//plateaudejeu.deplacementPiece('C',7,'C',6);
		//plateaudejeu.deplacementPiece('B',7,'B',6);
		//plateaudejeu.deplacementPiece('C',8,'A',6);
		//plateaudejeu.deplacementPiece('D',8,'C',8);
		//plateaudejeu.deplacementPiece('B',1,'A',3);
		
		//while(EtMaths == null){
			

		//Future fichier texte
		final String[] partie = {
				"D2D4",
				"D7D5",
				"C2C4",
				"C7C6",
				"G8F6",
				"H2H3",
				"C1D2",
				"D5C4",
				"C4C3",
				"C3C2",
				"C2C1",
				"H3H4",
				"H4H5",
				"H5H6",
				"H6G7",
				"G7G8"};
		
		final String[] partie2 = {
				"D2D4",
				"D7D5",
				"C2C4",
				"C4C5",
				"B7B5",
				"C5B6",
				"D4E5",
				"B1C3",
				"C3E4",
				"E4D6"
		};
		
		//plateaudejeu.jouerPartie(partie2);
		System.out.println(plateaudejeu.getHistorique());
		plateaudejeu.sauver();
	}
}
