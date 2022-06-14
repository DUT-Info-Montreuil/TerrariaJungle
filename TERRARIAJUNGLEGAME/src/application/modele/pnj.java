package application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class pnj extends Personnage {
	private Terrain terrain;
	private Arme arme;

	public pnj(Terrain terrain,String nom,String e, int ptV, int x, int y) {
		super(terrain, nom, nom, ptV, x, y);



	}
	public void deplacementPnj(Personnage perso) {
		agir();
//		Random random = new Random();
//		int nb;
//		nb = random.nextInt(100);
//
//			if(nb==1){
//				deplacementDroit();
//
//				}
//			else if(nb==0) {
//				deplacementGauche();
////			System.out.println("dzdzqdqdqd");
//			}
//

		if(this.getX()==perso.getX()-60) {
			if(perso.getX()>this.getX()) {
				if(this.getcollisionr()) {
					sautPersonage();
					deplacementDroit();
				}
				else if(this.getcollisionh()){

				}
				deplacementDroit();
			}
		}
		if(this.getX()==perso.getX()+60) {
			if(perso.getX()<this.getX()) {
				if(this.getcollisionl()) {
					sautPersonage();
					deplacementDroit();
				}
				deplacementGauche();
			}

		}
		else if(this.getX()==perso.getX()-60) {
			if(perso.getY()<this.getY()) {

				sautPersonage();



			}

		}	else if(this.getX()==perso.getX()+60) {
			if(perso.getY()>this.getY()) {

				sautPersonage();



			}

		}






	}

}


