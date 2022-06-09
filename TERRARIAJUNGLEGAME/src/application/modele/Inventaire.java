package application.modele;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
	
	private ObservableList<Items> lesItems;
	
	public Inventaire (ArrayList<Items> LesItems){
		
	}
	
	public void ajouterItem(Items items) {
		lesItems.add(items);
	}
	public void supItem(Items items) {
		lesItems.remove(items);
	}
	public ObservableList<Items> getitem() {
		return lesItems;  
	}
	
	

	
}
