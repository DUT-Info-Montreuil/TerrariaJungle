package application.modele;

import javafx.beans.property.DoubleProperty;

public class Epee extends Arme{

	public Epee(String nom, int att, String id, int portee1,int defense) {
		super("Epée", att, id, portee1, defense);
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		return "Epee";
	}
	public int getattaque() {
		return this.getPointAttaque();

	}
}
