package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi extends Personnage {

private IntegerProperty vieProperty;
private Environnement env;
	public Ennemi(Terrain terrain,String nom,String e, int ptV, int x, int y) {
		super(terrain, nom, nom, ptV, x, y);
		this.vieProperty = new SimpleIntegerProperty(3);
		env= new Environnement();
	}
//	public void attaque() {
//		
//	
//	for (int i = 0; i < listeEnnemi.size(); i++) {
//		ennemi=listeEnnemi.get(i);
//		if(getJoueur().getX() < this.ennemi.getX() ) {
//			ennemi.setGauche(true);
//			ennemi.setDroite(false);
//			ennemi.setDirection(2);
//			if (!Collision.collisionGauche(ennemi,getTabMap())) 
//				this.ennemi.allerAGauche();
//		}
//		
//		else if(getJoueur().getX() > this.ennemi.getX()) {
//			ennemi.setDroite(true);
//			ennemi.setGauche(false);
//			ennemi.setDirection(1);
//			if(!Collision.collisionDroite(ennemi,getTabMap()))
//				this.ennemi.allerADroite();
//			
//		}
//		else {
//			ennemi.setDroite(false);
//			ennemi.setGauche(false);
//		}
//
//}
//	}
	public void ennemiagit(Personnage perso) {
						agir();
						if(getX()>=perso.getX()-10 || getX()<=perso.getX()-30) {
							
							if(perso.getX()>=getX()+60) {
								if(getcollisionr()) {
									sautPersonage();	
									deplacementDroit();
								}
							deplacementDroit();
							
								}
							}
						 if(getX()>=perso.getX()+10&& getX()<=perso.getX()+30) {
							if(perso.getX()<=getX()) {
								if(getcollisionl()) {
									sautPersonage();
									deplacementGauche();
								}
								deplacementGauche();
							}
							
						}	
							else if(getX()==perso.getX()-30) {
							if(perso.getY()<getY()) {
							
								sautPersonage();
								
								
								
							}
							
						}	else if(getX()==perso.getX()+30) {
							if(perso.getY()>getY()) {
								
								sautPersonage();
							
							
							
							}
						
							}
							
						 	}
	public void attaque(Personnage p) {
		if(getPv()==0){
			env.getennemilist().remove(0);
		}
		if(getX()==p.getX()) {
			p.perdvie();
			env.getPersolist().remove(p);
			
	}
	}
	@Override
	public int getNbCoeurs() {
		return 3;
	}
							
	public int getPv() {
		return vieProperty.getValue();
	}
	@Override
	protected void perdvie() {
		// TODO Auto-generated method stub
		
	}
							


}
