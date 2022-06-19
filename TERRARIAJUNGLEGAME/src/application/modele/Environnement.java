package application.modele;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;


public class Environnement {


	private Inventaire inventaire;
	private Terrain terrain;
	private ArrayList<Items> listeitem;
	private ObservableList<Personnage> personnages;
	private ObservableList<Ennemi> ennemi;


	
	
	public Environnement() {
		terrain=new Terrain(30,20);
		inventaire=new Inventaire();
		this.personnages= FXCollections.observableArrayList();
		this.ennemi= FXCollections.observableArrayList();

}
	public void init() {
		this.inventaire.ajouterItem(new Epee("e1", 10,null, 0, 0));
		this.ajouterPerso(new pnj(terrain, "dfjkgb", "ds", 0, 100, 200));
		this.ajouterPerso(new Luffy(terrain, "luffy", "oui", 0, 100, 200));
		this.ajouterPerso(new Ennemi(terrain, "ennemi", "oui", 0, 420, 400));
	}
	
	public ObservableList<Personnage> getPersolist() {
		return personnages;
	}
	public ObservableList<Ennemi> getennemilist() {
		return ennemi;
	}
	
	public void ajouterPerso(Personnage a){
		personnages.add(a);
	}

	public ObservableList<Items> getItems() {
		return inventaire.getitem();
	}
	
	public Personnage getennemi() {
		for(int i = 0; i< this.personnages.size();i++) {
			if(this.personnages.get(i) instanceof Ennemi) {
				return (Ennemi) this.personnages.get(i);
			
	
			}
		}
		return null;
	}
	public Personnage getperso() {
		for(int i = 0; i< this.personnages.size();i++) {
			if(this.personnages.get(i) instanceof Personnage) {
				return (Personnage) this.personnages.get(i);
			
	
			}
		}
		return null;
	}

						    }
	

	

