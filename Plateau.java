
public class Plateau {
	//cases contient donc chaque case du plateau sous forme de tableau de cases.
	private Case[][] cases;
	//Le constructeur de plateau.
	public Plateau(){
		//On initialise cases avec un tableau de 8 rang�es de 8 cases.
		this.cases = new Case[8][8];
		//On parcourt le tableau par les rang�es puis par les cases.
		for(int i = 0;i<8;i++){
			char a = 'A';
			for(int y = 0;y<8;y++){
				//si i = 0 alors on cr�e les pi�ces 'sp�ciales' noirs.
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
				//si i = 1/6 alors on cr�e une rang�e de pion noirs/blancs.
				else if(i == 1 || i == 6){
					this.cases[i][y] = new Case(new Pion(a,i+1),a,i+1);
					a++;
				}
				//si i = 7 alors on cr�e les pi�ces 'sp�ciales' blanches.
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
				//Pour toutes les autres situations, nous cr�eons des cases vides.
				else{	
					this.cases[i][y] = new Case(a,i+1);
					a++;
				}
			}
		}
	}
	//Comme nous utilisons des charact�res et qu'il est impossible de parcourir des tableaux � l'aide de charact�re, cette fonction permet de translater le caract�re en chiffre.
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
	//Cette m�thode permet de v�rifier qu'il y a un echec. C'est � dire que le roi peut �tre manger par une pi�ce de la couleur adverse.
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
		//Apr�s avoir obtenu les coordonn�es des deux rois, le tableau va �tre parcouru de nouveau et chacune des pi�ces du plateau vont �tre test�s afin de savoir si elles ont la posibilit� de se d�placer sur la case du roi de la couleur adverse.
		//Si oui, Un �chec a lieu. Si non, Rien ne se passe.
		for(int i = 0; i<8;i++){
			for(int y = 0; y<8;y++){
				if(this.cases[i][y].contenu != null){
					
					//Si la pi�ce est noir, .deplacement va �tre test� pour les coordonn�es du roi blanc. Si elle peut y aller alors il y a un echec blanc. 
					if(this.cases[i][y].contenu.couleur == "Noir"){
						if(this.cases[i][y].contenu.deplacement(cb,rb) == true){
							return "Echec Blanc";
						}
					}
					
					//L'inverse si la pi�ce est blanche.
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
				
	//Cette m�thode permet de tester si une pi�ce peut �tre d�plac� d'une case � une autre dans la configuration de plateau actuelle.
	public void deplacementPiece(char c1,int r1, char c2, int r2){
		
		//Utilise chartoInt pour transformer les charact�res en chiffre(coordonn�es)
		int x1 = this.chartoInt(c1);
		int x2 = this.chartoInt(c2);
		Case depart = this.cases[r1-1][x1];
		Case arrive = this.cases[r2-1][x2];
		
		//Teste si les deux cases s�lectionn�s sont les m�mes ou si la premi�re case choisi est vide.
		if(depart != this.cases[r2-1][x2] && depart.contenu != null){
			
			//Teste si la case est vide:
			if(arrive.contenu != null){
				
				//Si elle ne l'est pas, alors il ya une v�rification pour voir si les deux cases sont de la m�me couleur, si elles sont pas alors il y a un test de la m�thode deplacement de la pi�ce.
				if(depart.contenu.memeCouleur(arrive.contenu) != true){
					if(depart.getContenu().deplacement(c2,r2) == true){
						arrive.contenu = depart.contenu;
						depart.contenu = null;
					}
				}
			}
			
			//so elle l'est alors le d�placement a lieu apr�s v�rification de la m�thode deplacement de la pi�ce.
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