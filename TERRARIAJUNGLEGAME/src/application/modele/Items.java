package application.modele;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import application.modele.Terrain;


public class Personnage {


	private String id;
	private String nom;
	private int ptAttaque;
	private int ptVie;
	private IntegerProperty pv = new SimpleIntegerProperty(150);
	private int ptDef;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private IntegerProperty directionpersonnage;
	private Terrain terrain;
	private boolean gravity;
	private boolean saut;
	private boolean creuse;
	private boolean deplacementdroit;
	private boolean deplacementgauche;
	private boolean collisionhaut;
	private boolean collisionr;
	private boolean collisionl;
	private boolean collisiond;
	int vitesse;
	int compteur=0;


	private Inventaire inventaire;




	public Personnage(Terrain terrain,String nom, int ptA, int ptV, int ptD,int x, int y) { //personnage
		this.terrain=terrain;
		this.directionpersonnage =new SimpleIntegerProperty(1) ;
		this.nom = nom;
		this.ptAttaque = ptA;
		this.ptVie = ptV;
		this.ptDef = ptD;
		this.xProperty =new SimpleIntegerProperty(x) ;
		this.yProperty =new SimpleIntegerProperty(y) ;
		gravity=false;
		saut=false;
		creuse=false;
		deplacementdroit=false;
		collisionhaut=false;
		collisionr=false;
		collisionl=false;
		collisiond=false;


	}
	public Personnage(Terrain terrain,String i,String nom,int pv, int x, int y) { //pnj
		this.id=i;
		this.terrain=terrain;
		this.directionpersonnage =new SimpleIntegerProperty(1) ;
		this.nom = nom;
		this.ptVie = pv;
		this.xProperty =new SimpleIntegerProperty(x) ;
		this.yProperty =new SimpleIntegerProperty(y) ;
		gravity=false;
		saut=false;
		creuse=false;
		deplacementdroit=false;
		collisionhaut=false;
		collisionr=false;
		collisionl=false;
		collisiond=false;
	}



	public void agir() {
		verifterre();
		verifGravity();
		verifcollison();
		if (saut) {
			int newY=this.getY()-2;
//		System.out.println("compteur"+compteur);
			if(newY>0) {
				this.setY(newY);
				compteur+=2;
				if(compteur>=90) {
					saut=false;
					compteur=0;
				}
			}



		}
		if (!saut && isGravity()) {

			int newY=this.getY()+2;
			this.setY(newY);


		}
//			if(creuse) {
//				if(terrain.getIndice(yProperty.getValue()/32*30+30+xProperty.getValue()/32)!=673&&terrain.getIndice(yProperty.getValue()/32*30+30+xProperty.getValue()/32)!=)
//			      this.setY(this.getY()+2);
//			}

		if(deplacementdroit&&!collisionr) {
			int newX = this.getX()+ 10;

			if(newX <= this.terrain.getLargeur()*30) {
				this.setdirectionpersonnage(1);
				this.setX(newX);
				// System.out.println("valeur"+newX);
			}
			deplacementdroit=false;
		}


		if(deplacementgauche&&!collisionl) {
			int newX = this.getX()-10;
			if(newX >= 0) {
				this.setdirectionpersonnage(-1);
				this.setX(newX);

			}
			deplacementgauche=false;
		}

	}
	public String getId() {
		return this.nom;
	}
	public boolean isGravity() {
		return gravity;
	}

	public void verifGravity() {

		int xgauche = (getX())/32;
		int xdroite = (getX()+49)/32;
		int ybas= (getY() + 49)/32;
		int y=(getY()-10)/32;
		int ybasplusbloc= (getY() + 73)/32;

		int gravterrainbloc= (ybasplusbloc*terrain.getLargeur())+xdroite;
		int gravterraindroite= (ybas*terrain.getLargeur())+xdroite;
		int gravterraingauche= (ybas*terrain.getLargeur())+xgauche;
		int gravhautgauche= (y*terrain.getLargeur())+xgauche;
		int gravhautdroite= (y*terrain.getLargeur())+xdroite;
//		 ||terrain.getIndice(gravhautdroite)==747||terrain.getIndice(gravhautgauche)==747
		//System.out.println("valeur"+terrain.getIndice(gravterrain));
		if(terrain.getIndice(gravterraindroite)==747&&terrain.getIndice(gravterraingauche)==747) {

			//if(terrain.getIndice(yProperty.getValue()/32*30+30+xProperty.getValue()/32)==747) {
			gravity=true;
		}
		else
			gravity=false;
	}
	public void verifterre(){

		int x = (getX())/32;
		int y= (getY()+45)/32;
		int gravterrain= (y*terrain.getLargeur())+x;
		if(terrain.getIndice(gravterrain)!=747) {
			int newY=this.getY()-1;
			if(newY>0) {
				this.setY(newY);



			}
		}

	}

	public boolean getcollisionr() {
		return collisionr;

	}
	public boolean getcollisionl() {
		return collisionl;

	}

	public void verifcollison() {

		int xdroite =(getX()+49)/32;
		int xgauche =(getX())/32;
		int ybas= (getY()+40)/32;
		int yhaut= (getY())/32;
		int colrigthbas= (ybas*terrain.getLargeur())+xdroite;
		int h= (getY()-40)/32;
		int colleftbas= (ybas*terrain.getLargeur())+xgauche;
		int colrigthhaut= (yhaut*terrain.getLargeur())+xdroite;
		int colhaut= ((h)*terrain.getLargeur())+xdroite;
		int collefthaut= (yhaut*terrain.getLargeur())+xgauche;
		//System.out.println("getx:    "+(getX()+30));
		//System.out.println("position   "+xdroite+"------"+y+terrain.getLargeur());
		System.out.println("result:      "+(yhaut-1));
		if(terrain.getIndice(colrigthhaut)!=747||terrain.getIndice(colrigthbas)!=747) {
			collisionr=true;
		}
		else {
			collisionr=false;
		}
		if(terrain.getIndice(colleftbas)!=747) {
			collisionl=true;
		}else {
			collisionl=false;
		}
		if(terrain.getIndice(colhaut)!=747||terrain.getIndice(collefthaut)!=747) {
			collisionhaut=true;
		}else {
			collisionhaut=false;
		}

	}

//	public void verifcollison() {
//
//	 int x =(getX()+27)/32;
//	 int y= getY()/32;
//	 int colterrain= y*terrain.getLargeur()+x+1;
//	if(terrain.getIndice(colterrain)!=747) {
//		collision=true;
//	}
//	else {
//		collision=false;
//	}
	//	}
//		else if(deplacementgauche) {
//			 int x =(getX()-27)/32;
//			 int y= getY()/32;
//			 int colterrain= y*terrain.getLargeur()-x-1;
//
//			if(terrain.getIndice(colterrain)!=747) {
//				collision=true;
//			}
//			else {
//				collision=false;
//			}
//
//		}
//		else {
//			}
//		}


//	x*terrain.getLargeur()+y;





	public void deplacementDroit() {
		if(!collisionr) {
			deplacementdroit=true;
		}
	}
	public void deplacementGauche() {
		if(!collisionl) {
			deplacementgauche=true;
		}
	}
	public void deplacementDroitf() {
		deplacementdroit=false;
	}

	public void deplacementGauchef() {
		deplacementdroit=false;
	}



	public void sautPersonage() {
		if(!isGravity()&&!collisionhaut) {

			saut=true;

		}
	}
	public void sautPersonagef() {


		saut=false;


	}

	public void personebougepas() {
		this.setX(getX());
		this.setY(this.getY());
	}
	public void creusePersonage() {

		creuse=true;
	}

	public final int getdirectionpersonnage() {
		return directionpersonnage.getValue();
	}

	public final IntegerProperty directionpersonnageProperty(){
		return this.directionpersonnage;
	}
	public final void setdirectionpersonnage(int n){
		directionpersonnage.setValue(n);
	}




	public final int getX() {
		return xProperty.getValue();
	}
	public final void setX(int n){
		xProperty.setValue(n);
	}
	public final IntegerProperty xProperty(){
		return this.xProperty;
	}
	public final int getY() {
		return yProperty.getValue();
	}
	public final void setY(int n){
		yProperty.setValue(n);
	}
	public final IntegerProperty yProperty(){
		return this.yProperty;
	}

	public String getNom() {
		return this.nom ;
	}
	public Items getListArme(){
		return this.inventaire.getitems();
	}


	public int getAttaque() {
		return this.ptAttaque ;
	}

	public int getDefense() {
		return this.ptDef ;
	}

	public int getVie() {
		return this.ptVie ;
	}



	public void setAttaque(int x) {
		this.ptAttaque = x;
	}

	public void setVie(int x) {
		this.ptVie = x;
	}

	public void setDefense(int x) {
		this.ptDef = x;
	}
}