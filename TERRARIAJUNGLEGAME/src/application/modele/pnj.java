package application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class pnj extends Personnage {


	public pnj(Terrain terrain,String nom,String e, int att, int x, int y) {
		super(terrain, nom, nom, att, x, y);



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

		if(this.getX()>=perso.getX()-60 || this.getX()<=perso.getX()-70) {

			if(perso.getX()>=this.getX()+60) {
				if(this.getcollisionr()) {
					sautPersonage();
					deplacementDroit();
				}
				deplacementDroit();

			}
		}
		if(this.getX()>=perso.getX()+60 || this.getX()>=perso.getX()+70) {
			if(perso.getX()<this.getX()) {
				if(this.getcollisionl()) {
					sautPersonage();
					deplacementGauche();
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
	@Override
	public int getNbCoeurs() {

		return 10;
	}
	@Override
	protected void perdvie() {
		// TODO Auto-generated method stub

	}

}
	


