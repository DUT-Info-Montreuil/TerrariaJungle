package application.modele;
import javafx.beans.property.DoubleProperty;

public class Arme extends Items{
	
	private int portee;
	private int attaque;
	private int defense;
	private String id;
	
	public Arme(String nom, int attaque, String id, int portee,int defense) {
		
		super(nom,0, id);
		this.portee = portee;
		this.attaque = attaque;
		this.defense = defense ;

	}
 
	public int getPointAttaque() {
		return attaque;
	}
		
	public int getPointDefense() {
		return defense;
	}
	
	public String getId() {
		return this.id;
	}


}
