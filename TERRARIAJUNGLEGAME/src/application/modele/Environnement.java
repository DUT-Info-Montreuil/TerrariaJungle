package application.modele;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

public class Environnement {


	private Inventaire inventaire;

	private ArrayList<Items> listeitem;

	public Environnement() {
		inventaire=new Inventaire();

	}
	public void init() {
		this.inventaire.ajouterItem(new Epee("e1", 10,null, 0, 0));
	}



	public ObservableList<Items> getItems() {
		return inventaire.getitem();
	}






}
	

