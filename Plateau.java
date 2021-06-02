
public class Plateau {
	//cases contient donc chaque case du plateau sous forme de tableau de cases.
	private Case[][] cases;
	//Le constructeur de plateau.
	public Plateau(){
		//On initialise cases avec un tableau de 8 rangées de 8 cases.
		this.cases = new Case[8][8];
		//On parcourt le tableau par les rangées puis par les cases.
		for(int i = 0;i<8;i++){
			char a = 'A';
			for(int y = 0;y<8;y++){
				//si i = 0 alors on crée les pièces 'spéciales' noirs.
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
				//si i = 1/6 alors on crée une rangée de pion noirs/blancs.
				else if(i == 1 || i == 6){
					this.cases[i][y] = new Case(new Pion(a,i+1),a,i+1);
					a++;
				}
				//si i = 7 alors on crée les pièces 'spéciales' blanches.
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
				//Pour toutes les autres situations, nous créeons des cases vides.
				else{	
					this.cases[i][y] = new Case(a,i+1);
					a++;
				}
			}
		}
	}
	//Comme nous utilisons des charactères et qu'il est impossible de parcourir des tableaux à l'aide de charactère, cette fonction permet de translater le caractère en chiffre.
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
	//Cette méthode permet de vérifier qu'il y a un echec. C'est à dire que le roi peut être manger par une pièce de la couleur adverse.
	public String echec(){
		//Ces variables permettent de retenir l'emplacement des rois.
		int rb = 0;
		char cb = 'A';
		int rn = 0;
		char cn = 'A';
		//Cette boucle parcourt le tableau afin de localiser les rois et ainsi de retenir leur position.
		for(int i = 0; i<8;i++){
			for(int y = 0; y<8;y++){
				if(this.cases[i][y].contenu != null){
					if(this.cases[i][y].contenu.nom == "Roi"){
						if(this.cases[i][y].contenu.couleur == "Noir"){
							rn = this.cases[i][y].getRangee();
							cn = this.cases[i][y].getColonne();
						}
						else{
							rb = this.cases[i][y].getRangee();
							cb = this.cases[i][y].getColonne();
						}
					}
				}
			}
		}
		//Après avoir obtenu les coordonnées des deux rois, le tableau va être parcouru de nouveau et chacune des pièces du plateau vont être testés afin de savoir si elles ont la posibilité de se déplacer sur la case du roi de la couleur adverse.
		//Si oui, Un échec a lieu. Si non, Rien ne se passe.
		for(int i = 0; i<8;i++){
			for(int y = 0; y<8;y++){
				if(this.cases[i][y].contenu != null){
					
					//Si la pièce est noir, .deplacement va être testé pour les coordonnées du roi blanc. Si elle peut y aller alors il y a un echec blanc. 
					if(this.cases[i][y].contenu.couleur == "Noir"){
						if(this.cases[i][y].contenu.deplacement(cb,rb) == true){
							return "Echec Blanc";
						}
					}
					
					//L'inverse si la pièce est blanche.
					else if(this.cases[i][y].contenu.couleur == "Blanc"){
						if(this.cases[i][y].contenu.deplacement(cn,rn) == true){
							return "Echec Noir";
						}
					}
				}
			}
		}
		return "Pas Echec";
	}
				
	//Cette méthode permet de tester si une pièce peut être déplacé d'une case à une autre dans la configuration de plateau actuelle.
	public void deplacementPiece(char c1,int r1, char c2, int r2){
		
		//Utilise chartoInt pour transformer les charactères en chiffre(coordonnées)
		int x1 = this.chartoInt(c1);
		int x2 = this.chartoInt(c2);
		Case depart = this.cases[r1-1][x1];
		Case arrive = this.cases[r2-1][x2];
		
		//Teste si les deux cases sélectionnés sont les mêmes ou si la première case choisi est vide.
		if(depart != this.cases[r2-1][x2] && depart.contenu != null){
			
			//Teste si la case est vide:
			if(arrive.contenu != null){
				
				//Si elle ne l'est pas, alors il ya une vérification pour voir si les deux cases sont de la même couleur, si elles sont pas alors il y a un test de la méthode deplacement de la pièce.
				if(depart.contenu.memeCouleur(arrive.contenu) != true){
					if(depart.getContenu().deplacement(c2,r2) == true){
						arrive.contenu = depart.contenu;
						depart.contenu = null;
					}
				}
			}
			
			//so elle l'est alors le déplacement a lieu après vérification de la méthode deplacement de la pièce.
			else if(depart.getContenu().deplacement(c2,r2) == true){
				arrive.contenu = depart.contenu;
				depart.contenu = null;
			}
		}
		this.affichage();
	}
	
	//Permet d'afficher le plateau en 'scannant' le contenu de chacune des cases et d'afficher leur 'Apparence'
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

	public void jouerPartie(String [] tPartie){
		for(int n=0; n<tPartie.length; n++) {
			String lecture = tPartie[n];
			deplacementPiece(lecture.charAt(0), lecture.charAt(1)-'0',  lecture.charAt(2), lecture.charAt(3)-'0');
		}
	}
	
}