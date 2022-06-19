package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Luffy extends Personnage {
Environnement env;
	private IntegerProperty nbCoeursProperty;
	public Luffy(Terrain terrain, String i, String nom, int att, int x, int y) {
		super(terrain, i, nom, att, x, y);
		nbCoeursProperty=new SimpleIntegerProperty(3) ;
		env= new Environnement();
	
	
	}
	public void perdrePv() {
		int nbCoeur =this.getNbCoeurs()-1;
		if(getNbCoeurs()>=1) 
			this.nbCoeursProperty.setValue(nbCoeur);
	}
	

	public final int getNbCoeurs() {
		return this.nbCoeursProperty.getValue();
	}

	public  IntegerProperty nbCoeurProperty() {
		return this.nbCoeursProperty;
	}
	public void attaque() {
    	for(int i = 0 ; i < env.getPersolist().size(); i++) {
    		if(	(((getX() - env.getPersolist().get(i).getX()) <= getEpee().getPorte()) && ((getX() - env.getPersolist().get(i).getX()) >= -getEpee().getPorte())) &&  (getY() == env.getPersolist().get(i).getY()) ){
	           if(env.getPersolist().get(i) instanceof pnj) {
	                    	System.out.println("enfin");
	                        attaque(env.getPersolist().get(i));
	                        if(env.getPersolist().get(i).getNbCoeurs() ==0) {
	                            env.getPersolist().remove(i);
	                        }
	                    }
    		}
		}
 }
	@Override
	protected void perdvie() {
			int coeurnb =this.getNbCoeurs()-1;
			if(getNbCoeurs()>=1) 
				this.nbCoeursProperty.setValue(coeurnb);
		}
		
	}


