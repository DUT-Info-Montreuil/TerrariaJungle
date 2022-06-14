package application.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

public class Arc extends Arme {

	private IntegerProperty fleche;

	public Arc(String nom, int att, String id, int portee1,int defense) {
		super("arc", att, id, portee1, defense);
		// TODO Auto-generated constructor stub

	}

	//A chaque attaque avec l'arc, on retire une fleche
	public void setFleche() {
		this.fleche.setValue(fleche.getValue()-1);;
	}

	public IntegerProperty getFleche() {
		return this.fleche;
	}

	public String toString() {
		return "Arc";
	}
}