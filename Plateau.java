import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

//import echec.Case;
//import echec.Cavalier;
//import echec.Dame;
//import echec.Fou;
//import echec.Piece;
//import echec.Pion;
//import echec.Roi;
//import echec.Tour;

public class Plateau {
	//cases contient donc chaque case du plateau sous forme de tableau de cases.
	private Case[][] cases; // [x=colonne][y=ligne] [0][0]=en bas à gauche
	private ArrayList<String> historique = new ArrayList<String>();
	public boolean couleurJoueurActif;  // blanc = true
	private boolean capture;  
	
	//Le constructeur de plateau.	
	static String [] plateauDebutNormal = {
    "tcfdrfct",
    "pppppppp",
    "        ",
    "        ",
    "        ",
    "        ",
    "PPPPPPPP",
    "TCFDRFCT"   };


	public Plateau() {
		PlateauString(plateauDebutNormal);
	}

	public Plateau(String[] t) {
		PlateauString(t);
	}

	public void PlateauString(String [] t) {
	couleurJoueurActif = true;  // = blanc
	capture = false;

	this.cases = new Case[8][8];

	for (int x=0; x<8; x++)
	for (int y=0; y<8; y++) {

		Piece p = new Piece(x,y);
		boolean vide = false;
		
		switch (t[y].charAt(x)) {
		case (' ') : vide = true;		break;
		case ('p') : p = new Pion(x,y); 		break;
		case ('P') : p = new Pion(x,y); 		break;
		case ('t') : p = new Tour(x,y); 		break;
		case ('T') : p = new Tour(x,y); 		break;
		case ('c') : p = new Cavalier(x,y); 	break;
		case ('C') : p = new Cavalier(x,y); 	break;
		case ('f') : p = new Fou(x,y); 			break;
		case ('F') : p = new Fou(x,y); 			break;
		case ('d') : p = new Dame(x,y); 		break;
		case ('D') : p = new Dame(x,y); 		break;
		case ('r') : p = new Roi(x,y); 			break;
		case ('R') : p = new Roi(x,y); 			break;       			
		}
		
		if (vide)
			this.cases[x][y] = new Case(x,y);
		else
			this.cases[x][y] = new Case(p);
	}
}

//	public Plateau(){
//		couleurJoueurActif = true;  // = blanc
//		capture = false;
//		
//		
//		//On initialise cases avec un tableau de 8 rangées de 8 cases.
//		this.cases = new Case[8][8];
//
//		cases[0][0] = new Case(new Tour(    'A',1));
//		cases[1][0] = new Case(new Cavalier('B',1));
//		cases[2][0] = new Case(new Fou(     'C',1));
//		cases[3][0] = new Case(new Dame(    'D',1));
//		cases[4][0] = new Case(new Roi(     'E',1));	
//		cases[5][0] = new Case(new Fou(     'F',1));
//		cases[6][0] = new Case(new Cavalier('G',1));
//		cases[7][0] = new Case(new Tour(    'H',1));
//
//		for(int x=0; x<8; x++)
//			cases[x][1] = new Case(new Pion((char)('A'+x),1));
//
//		for(int x=0; x<8; x++)
//		for(int y=2; y<6; y++)
//			cases[x][y] = new Case(x,y);
//
//		for(int x=0; x<8; x++)
//			cases[x][6] = new Case(new Pion((char)('A'+x),6));
//
//		cases[0][7] = new Case(new Tour(    'A',7));
//		cases[1][7] = new Case(new Cavalier('B',7));
//		cases[2][7] = new Case(new Fou(     'C',7));
//		cases[3][7] = new Case(new Dame(    'D',7));
//		cases[4][7] = new Case(new Roi(     'E',7));	
//		cases[5][7] = new Case(new Fou(     'F',7));
//		cases[6][7] = new Case(new Cavalier('G',7));
//		cases[7][7] = new Case(new Tour(    'H',7));
//
//}
	
	
//	//Cette méthode permet de vérifier qu'il y a un echec. C'est à dire que le roi peut être manger par une pièce de la couleur adverse.
//	public String echec(){
//		//Ces variables permettent de retenir l'emplacement des rois.
//		int rb = 0;
//		char cb = 'A';
//		int rn = 0;
//		char cn = 'A';
//		//Cette boucle parcourt le tableau afin de localiser les rois et ainsi de retenir leur position.
//		for(int i = 0; i<8;i++){
//			for(int y = 0; y<8;y++){
//				if(this.cases[i][y].contenu != null){
//					if(this.cases[i][y].contenu.nom == "Roi"){
//						if(this.cases[i][y].contenu.couleur == "Noir"){
//							rn = this.cases[i][y].getRangee();
//							cn = this.cases[i][y].getColonne();
//						}
//						else{
//							rb = this.cases[i][y].getRangee();
//							cb = this.cases[i][y].getColonne();
//						}
//					}
//				}
//			}
//		}
//		//Après avoir obtenu les coordonnées des deux rois, le tableau va être parcouru de nouveau et chacune des pièces du plateau vont être testés afin de savoir si elles ont la posibilité de se déplacer sur la case du roi de la couleur adverse.
//		//Si oui, Un échec a lieu. Si non, Rien ne se passe.
//		for(int i = 0; i<8;i++){
//			for(int y = 0; y<8;y++){
//				if(this.cases[i][y].contenu != null){
//					
//					//Si la pièce est noir, .deplacement va être testé pour les coordonnées du roi blanc. Si elle peut y aller alors il y a un echec blanc. 
//					if(this.cases[i][y].contenu.couleur == "Noir"){
//						if(this.cases[i][y].contenu.deplacement(cb,rb) == true){
//							return "Echec Blanc";
//						}
//					}
//					
//					//L'inverse si la pièce est blanche.
//					else if(this.cases[i][y].contenu.couleur == "Blanc"){
//						if(this.cases[i][y].contenu.deplacement(cn,rn) == true){
//							return "Echec Noir";
//						}
//					}
//				}
//			}
//		}
//		return "Pas Echec";
//	}
				
	//Cette méthode permet de tester si une pièce peut être déplacé d'une case à une autre dans la configuration de plateau actuelle.
	public boolean testMouvementPiece(int x1,int y1,  int x2, int y2, boolean comment){
		
		if(this.testRoque(x1,y1,x2,y2) == true){
			this.affichage();
			this.couleurJoueurActif = ! this.couleurJoueurActif;
			System.out.println("C'est au tour du joueur "+this.couleurJoueurActif);
			return false;
		}
		
		if (comment) System.out.print(" test : "+affichageA1(x1,y1)+" -> "+affichageA1(x2,y2)+" >>  ");
		// Hors du plateau
		if( ! testDansPlateau(x1,y1)){
			if (comment) System.out.println("Première coordonnée hors du plateau");
			return false;
		}
		if( ! testDansPlateau(x2,y2)){
			if (comment) System.out.println("Seconde coordonnée hors du plateau");
			return false;
		}

		Case depart = this.cases[x1][y1];
		Case arrive = this.cases[x2][y2];

		// Case de départ vide
		if(depart.contenu == null){
			if (comment) System.out.println("Aucune pièce à cette position");
			return false;
		}
		// Case d'arrivée non-vide
		if(arrive.contenu != null){
			if(depart.contenu.memeCouleur(arrive.contenu)){
			if (comment) System.out.println("Case arrivée occupée");
			return false;
			}
		}

		Piece P= depart.contenu;
		if( depart.contenu.getNom() == "Pion") {
			if(this.testPriseEnPassant(x1,y1,x2,y2) == true){
				this.affichage();
				this.couleurJoueurActif = ! this.couleurJoueurActif;
				System.out.println("C'est au tour du joueur "+this.couleurJoueurActif);
				return false;
			}
			Pion Pi = (Pion) depart.contenu;
			if( ! Pi.testDeplacement(x2, y2)) {
				if(arrive.contenu != null){
					if( ! Pi.testDeplacementPourManger(x2, y2) && arrive.contenu.getCouleur() != ! this.couleurJoueurActif) {
						if (comment) System.out.println("Déplacement irrégulier+");
						return false;
					}
				}
				else{
					if (comment) System.out.println("Déplacement irrégulier+");
					return false;
				}
			}
			if(arrive.contenu != null){
				if( ! Pi.testDeplacementPourManger(x2, y2) && arrive.contenu.getCouleur() != ! this.couleurJoueurActif) {
					if (comment) System.out.println("Déplacement irrégulier +");
						return false;
					}
			}
		}
		else{
			if( ! P.testDeplacement(x2, y2)) {
				if (comment) System.out.println("Déplacement irrégulier +");
				return false;
			}
		}
		if( depart.contenu.getNom() != "Cavalier")
		if( ! testCheminLibre(x1,y1, x2,y2)) {
			if (comment) System.out.println("Chemin encombré");
			return false;
		}
		
		//	Test Echec de son roi à faire après le déplacement
		// if( ! testEchecRoi()) {
		
		if (comment) System.out.println("ok");
		return true;
}

	public boolean testDansPlateau(int x, int y){
		if(x < 0) return false;
		if(7 < x) return false;
		if(y < 0) return false;
		if(7 < y) return false;
	return true;
	}

	public boolean testCheminLibre(int x1,int y1, int x2,int y2) {
		int dx=0;
		if (x1==x2)dx=0;	// nul (vertical)
		if (x1<x2) dx=+1;	// avance
		if (x2<x1) dx=-1;	// recule

		int dy=0;
		if (y1==y2)dy=0;	// nul (horizontal)
		if (y1<y2) dy=+1;	// monte
		if (y2<y1) dy=-1;	// descend
					
		int nx = Math.abs(x2-x1);			// nombre de fois en x
		int ny = Math.abs(y2-y1);			// nombre de fois en y
		int nmax = Math.max( nx ,  ny );	// nombre de fois en tout

		//System.out.println(""+dx+","+dy+","+nmax);
		// de juste après (n=1) à juste avant (n<nmax)
		for(int n=1; n<nmax; n++) {
			//System.out.println(""+(x1 + n*dx)+"x"+(y1 + n*dy)+"="+cases[x1 + n*dx][y1 + n*dy].contenu);
			if(cases[x1 + n*dx][y1 + n*dy].contenu != null)
				return false;
		}			
		
		return true;
	}

	public void deplacerPiece(int x1, int y1, int x2, int y2){
		Case depart = this.cases[x1][y1];
		Case arrive = this.cases[x2][y2];

		depart.contenu.setRangee(y2);
		depart.contenu.setColonne(x2);
		arrive.contenu = depart.contenu;
		depart.contenu = null;
		historique.add(""+(char)(x1+'A')+(y1+1)+(char)(x2+'A')+(y2+1));
	}
	
	public boolean jouerCoup(int x1, int y1, int x2, int y2) {
		if ( ! testMouvementPiece(x1, y1, x2, y2, false))
			return false;
		
		if(cases[x2][y2].contenu == null)	capture = false;
		else								capture = true;
		if(this.cases[x1][y1].contenu.getCouleur() != this.couleurJoueurActif) return false;
		deplacerPiece(x1, y1, x2, y2);
		
		//if (testRoiEchec(couleurJoueurActif)) {
			//historique.remove(historique.size());
			
			//supprimer la dernière action et tout rejouer
			//
			//System.out.println("Mon roi est en échec");
			//return false;
		//}
		
		if(y2 == 0 || y2 == 7)
		if(cases[x2][y2].contenu.getNom() == "Pion") {
			System.out.println("Promotion");
			pionPromotion(x2, y2);
			
		}
		this.couleurJoueurActif = ! this.couleurJoueurActif;
	return true;
	}	
	
	public boolean testRoque(int x1,int y1, int x2, int y2){
		if(couleurJoueurActif == true){
			if(this.cases[4][0].contenu == null) return false;
			if(this.cases[4][0].contenu.getNom() == "Roi" && this.cases[4][0].contenu.getPremiermvt() == false){
				if(x2 == 7 && y2 == 0){
					if(this.cases[7][0].contenu == null) return false;
					if(this.cases[7][0].contenu.getNom() == "Tour" && this.cases[7][0].contenu.getPremiermvt() == false && this.testCheminLibre(4,0,7,0) == true){
						this.cases[4][0].contenu.setColonne(6);
						this.cases[7][0].contenu.setColonne(5);
						this.cases[6][0].contenu = this.cases[4][0].contenu;
						this.cases[4][0].contenu = null;
						this.cases[5][0].contenu = this.cases[7][0].contenu;
						this.cases[7][0].contenu = null;
						historique.add(""+(char)(x1+'A')+(y1+1)+(char)(x2+'A')+(y2+1));
						this.cases[6][0].contenu.premier_mvt = true;
						this.cases[5][0].contenu.premier_mvt = true;
						return true;
					}
				}
				if(x2 == 0 && y2 == 0){
					if(this.cases[7][0].contenu == null) return false;
					if(this.cases[0][0].contenu.getNom() == "Tour" && this.cases[0][0].contenu.getPremiermvt() == false && this.testCheminLibre(4,0,0,0) == true){
						this.cases[4][0].contenu.setColonne(2);
						this.cases[0][0].contenu.setColonne(3);
						this.cases[2][0].contenu = this.cases[4][0].contenu;
						this.cases[4][0].contenu = null;
						this.cases[3][0].contenu = this.cases[0][0].contenu;
						this.cases[0][0].contenu = null;
						historique.add(""+(char)(x1+'A')+(y1+1)+(char)(x2+'A')+(y2+1));
						this.cases[2][0].contenu.premier_mvt = true;
						this.cases[3][0].contenu.premier_mvt = true;
						return true;
					}
				}
			}
		}
		
		if(couleurJoueurActif == false){
			if(this.cases[4][7].contenu == null) return false;
			if(this.cases[4][7].contenu.getNom() == "Roi" && this.cases[4][7].contenu.getPremiermvt() == false){
				if(x2 == 7 && y2 == 7){
					if(this.cases[7][7].contenu == null) return false;
					if(this.cases[7][7].contenu.getNom() == "Tour" && this.cases[7][7].contenu.getPremiermvt() == false && this.testCheminLibre(4,7,7,7) == true){
						this.cases[4][7].contenu.setColonne(6);
						this.cases[7][7].contenu.setColonne(5);
						this.cases[6][7].contenu = this.cases[4][7].contenu;
						this.cases[4][7].contenu = null;
						this.cases[5][7].contenu = this.cases[7][7].contenu;
						this.cases[7][7].contenu = null;
						this.cases[6][7].contenu.premier_mvt = true;
						this.cases[5][7].contenu.premier_mvt = true;
						return true;
					}
				}
				if(x2 == 0 && y2 == 7){
					if(this.cases[7][7].contenu == null) return false;
					if(this.cases[0][7].contenu.getNom() == "Tour" && this.cases[0][7].contenu.getPremiermvt() == false && this.testCheminLibre(4,7,0,7) == true){
						this.cases[4][7].contenu.setColonne(2);
						this.cases[0][7].contenu.setColonne(3);
						this.cases[2][7].contenu = this.cases[4][7].contenu;
						this.cases[4][7].contenu = null;
						this.cases[3][7].contenu = this.cases[0][7].contenu;
						this.cases[0][7].contenu = null;
						historique.add(""+(char)(x1+'A')+(y1+1)+(char)(x2+'A')+(y2+1));
						this.cases[2][7].contenu.premier_mvt = true;
						this.cases[3][7].contenu.premier_mvt = true;
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean testPriseEnPassant(int x1,int y1,int x2,int y2){
		String histo;
		if(this.couleurJoueurActif == true){
			if(y1 == 4 && y2 == 5 && (x2 == x1+1 || x2 == x1-1)){
				histo = new String(""+(char)(x2+'A')+(y1+3)+(char)(x2+'A')+(y1+1));
				boolean truc = ((String)histo).equals((String)this.historique.get(historique.size()-1));
				if(this.cases[x2][4].contenu.getNom() == "Pion" && truc == true){
					this.cases[x1][y1].contenu.setRangee(y1+1);
					this.cases[x1][y1].contenu.setColonne(x2);
					this.cases[x2][y2].contenu = this.cases[x1][y1].contenu;
					this.cases[x1][y1].contenu = null;
					historique.add(""+(char)(x1+'A')+(y1+1)+(char)(x2+'A')+(y2+1));
					this.cases[x2][4].setContenu(null);
					return true;
				}
			}
		}
		if(this.couleurJoueurActif == false){
			if(y1 == 3 && y2 == 2 && (x2 == x1+1 || x2 == x1-1)){
				histo = new String(""+(char)(x2+'A')+(y1-1)+(char)(x2+'A')+(y1+1));
				boolean truc = ((String)histo).equals((String)this.historique.get(historique.size()-1));
				if(this.cases[x2][3].contenu.getNom() == "Pion" && truc == true){
					this.cases[x1][y1].contenu.setRangee(y1-1);
					this.cases[x1][y1].contenu.setColonne(x2);
					this.cases[x2][y2].contenu = this.cases[x1][y1].contenu;
					this.cases[x1][y1].contenu = null;
					historique.add(""+(char)(x1+'A')+(y1+1)+(char)(x2+'A')+(y2+1));
					this.cases[x2][3].setContenu(null);
					return true;
				}
			}
		}
		return false;
	}
	public boolean testRoiEchec(boolean couleurRoi) {
		int xr=0; 
		int yr=0;
		for(int x=0; x<8; x++)
		for(int y=0; y<8; y++)
			if(this.cases[x][y].contenu != null)
			if(this.cases[x][y].contenu.getCouleur() == couleurRoi)
			if(this.cases[x][y].contenu.getNom() == "Roi") {
				xr=x; 
				yr=y;
			}

		for(int x=0; x<8; x++)
		for(int y=0; y<8; y++)
			if(this.cases[x][y].contenu != null)
			if(this.cases[x][y].contenu.getCouleur() != couleurRoi)
			if(testMouvementPiece(x,y, xr,yr, false))
				return true;
			
		return false;
	}
	
		public void pionPromotion(int x2, int y2) {
		Scanner reponse = new Scanner(System.in);
		String promotion;

		boolean ok = false;
		while( ! ok ) {
			ok = true;
			System.out.println("Entrez la promotion de la pièce (DTFC) :");
			promotion = reponse.nextLine();
			System.out.println("(DTFC) >> "+promotion);

			switch (promotion.toLowerCase().charAt(0)) {
			case 'd' : cases[x2][y2].contenu = new Dame(x2,y2);			break;
			case 'c' : cases[x2][y2].contenu = new Cavalier(x2,y2);		break;
			case 'f' : cases[x2][y2].contenu = new Fou(x2,y2);			break;
			case 't' : cases[x2][y2].contenu = new Tour(x2,y2);			break;
			default : ok = false;
			}
		}

		cases[x2][y2].contenu.setCouleur( ! cases[x2][y2].contenu.getCouleur());
//		reponse.close(); // NE PAS FERMER : ERREUR !
		System.out.println("Promotion de la pièce (DTFC) fin");
	}
//	public void deplacementPiece(char c1,int r1, char c2, int r2){
//		
//		//Utilise chartoInt pour transformer les charactères en chiffre(coordonnées)
//		int x1 = this.chartoInt(c1);
//		int x2 = this.chartoInt(c2);
//		Case depart = this.cases[r1-1][x1];
//		Case arrive = this.cases[r2-1][x2];
//		
//		//Teste si les deux cases sélectionnés sont les mêmes ou si la première case choisi est vide.
//		if(depart != arrive && depart.contenu != null){
//			
//			//Teste si la case est vide:
//			if(arrive.contenu != null){
//				
//				//Si elle ne l'est pas, alors il ya une vérification pour voir si les deux cases sont de la même couleur, si elles sont pas alors il y a un test de la méthode deplacement de la pièce.
//				if(depart.contenu.memeCouleur(arrive.contenu) != true){
//					if(depart.getContenu().deplacement(c2,r2) == true){
//						arrive.contenu = depart.contenu;
//						depart.contenu = null;
//						historique.add(""+c1+r1+c2+r2+"");
//					}
//				}
//			}
//			
//			//si elle l'est alors le déplacement a lieu après vérification de la méthode deplacement de la pièce.
//			else if(depart.getContenu().deplacement(c2,r2) == true){
//				arrive.contenu = depart.contenu;
//				depart.contenu = null;
//				historique.add(""+c1+r1+c2+r2+"");
//			}
//			
//			if(arrive.contenu.getNom() == "Pion") 
//			if(r2 == 8 || r2 == 1){
//				Piece promotion = new Dame(c2,r2);
//				String couleur = arrive.contenu.getCouleur();
//				String C = couleur.substring(0, 1);
//				promotion.setApparence(promotion.getApparence().substring(0,1)+ C);
//				arrive.contenu = promotion;
//			}
//		}
//		this.affichage();
//	}
	
	public ArrayList<String> getHistorique(){
		return this.historique;
	}
	
	public void sauver () {
		try {
			String fichier = null;
			JFileChooser choisir = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int resultat = choisir.showOpenDialog(null);
			
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("Texte","txt");
			choisir.setFileFilter(filtre);
			
			if(resultat == JFileChooser.APPROVE_OPTION) {
				fichier = choisir.getSelectedFile().getPath();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichier));
			bw.write(this.versFichier());
			bw.close();
		}catch(IOException e){
			System.err.println(e);
		}
	}
	
	public void charger(){
		try {
			JFileChooser FC = new JFileChooser();
			FC.showOpenDialog(null);
			String[] mouvement;
			ArrayList<String> liste = new ArrayList<String>();

			BufferedReader br = Files.newBufferedReader(Paths.get(FC.getSelectedFile().getPath()));
			String ligne;

			ligne = br.readLine();
			while (ligne != null) {
				liste.add(ligne);
				ligne = br.readLine();
			}
			br.close();
			mouvement = new String[liste.size()];
			int i = 0;
			for(String ligne2 : liste){ 
				mouvement[i] = ligne2;
				i++;
			}
			this.jouerPartie(mouvement);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public String versFichier() {
        String str = "";
        for (String deplacement : historique) {
            str += deplacement;
            str += "\n";
        }
        return str;
    }
	
	//Permet d'afficher le plateau en 'scannant' le contenu de chacune des cases et d'afficher leur 'Apparence'
	public void affichage(){
		String s;
		System.out.println("\n "+"  A   B   C   D   E   F   G   H");
		for(int y=7; 0<=y; y--){
			System.out.println(" "+"----------------------------------");
			s = "" + (y+1);
			
			for(int x=0; x<8; x++){
				if(cases[x][y].getContenu() == null){
					s = s + "|   ";
				}
				else{
					s = s + "| " + affichagePiece(cases[x][y].getContenu());
				}
			}
			
			s = s +" |";
			System.out.println(s);
		}
		System.out.println(" "+"----------------------------------");
		System.out.println(" "+"  A   B   C   D   E   F   G   H");
	}

	public String affichageA1(int x, int y){
		return ""+((char)(x+'A'))+(y+1);
	}
	
	public String affichagePiece(Piece P){
		if (P.getCouleur() == true) 
			switch (P.getNom()) {
			case "Roi" : 	return "RB";
			case "Dame" : 	return "DB";
			case "Fou" : 	return "FB";
			case "Cavalier":return "CB";
			case "Tour" : 	return "TB";
			case "Pion" : 	return "PB";
			default :		return "  ";
		}
		else
			switch (P.getNom()) {
			case "Roi" : 	return "RN";
			case "Dame" : 	return "DN";
			case "Fou" : 	return "FN";
			case "Cavalier":return "CN";
			case "Tour" : 	return "TN";
			case "Pion" : 	return "PN";
			default :		return "  ";
		}
	}

	public void jouerPartie(String [] tPartie){
		affichage();
		for(int n=0; n<tPartie.length; n++) {
			String lecture = tPartie[n];
			System.out.print("\n coup : ");
			System.out.print(lecture.substring(0,2));
			
			if (capture)	System.out.print("x");
			else			System.out.print("-");
			System.out.println(lecture.substring(2,4));
			
			if ( !jouerCoup(lecture.charAt(0)-'A', lecture.charAt(1)-'1',
						    lecture.charAt(2)-'A', lecture.charAt(3)-'1'))
				break;
			affichage();
			}
	}
	
}