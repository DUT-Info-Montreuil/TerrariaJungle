package application.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Items {
	
	private String nom;
	private int pv;
	private String id;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	
	
	public Items(String nom, int pv, String id, int x, int y) {
		
		this.id = id;
		this.pv = pv;
		this.nom = nom;
		this.xProperty =new SimpleIntegerProperty(x) ;
		this.yProperty =new SimpleIntegerProperty(y) ;
		
	
	}
	
public Items(String nom, int pv, String id) {
		this(nom, pv, id, 0, 0);

	
	}
public String getId() {
	return id;
	
}
public final IntegerProperty xProperty(){
	return this.xProperty;
}
public final IntegerProperty yProperty(){
	return this.yProperty;
}


	
}
