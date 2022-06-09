package application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class pnj extends Personnage {
private Terrain terrain;
private Arme arme;
private Personnage perso;
	public pnj(Personnage persos,Terrain terrain,String nom,String e, int ptV, int x, int y) {
super(terrain, nom, nom, ptV, x, y);
	perso=persos;
	
		
	}
	public void deplacementPnj() {
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
		
		
		 }
	public void suivreperso() {
		while(this.getX()!=	perso.getX()-15) {
			if(perso.getX()>this.getX()) {
				
			}
			
		}
	
	}
	}
	


