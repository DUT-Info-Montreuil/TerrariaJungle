package application.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

public class Environnement {

//	private ObservableList<Personnage> personnages;
	private ObservableList<Inventaire> inv;
	private ObservableList<Arme> armes;

	private ObservableList<Items> Items;
	private Terrain map;
	private Inventaire inventaire;
	
	
	
	public Environnement(Terrain map) {
		this.map=map;
//		this.inv= FXCollections.observableArrayList();
		this.armes= FXCollections.observableArrayList();
}
	public void init() {
		this.ajouterArme(new Epee("e1", 10,null, 0, 0));
	
	}


//}
	public void ajouterArme(Items item){
		inventaire.ajouterItem(item);	
		}
	public void suppArme(Items item){
		inventaire.supItem(item);
		}
	
	public ObservableList<Inventaire> getInventaire() {
		return inv;
	}
	


public Epee getEpee() {
	for(int i = 0; i< this.Items.size();i++) {
		if(this.Items.get(i) instanceof Epee) {
			return (Epee) this.Items.get(i);
		}
	}
	return null;
}

}
	

