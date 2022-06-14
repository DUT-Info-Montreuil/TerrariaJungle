package application.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList<Items> lesItems;
	private Items item;
	public Inventaire (){
		this.lesItems= FXCollections.observableArrayList();
	}

	public void ajouterItem(Epee items) {
		lesItems.add(items);
	}
	public void supItem(Items items) {
		lesItems.remove(items);
	}
	public ObservableList<Items> getitem() {
		return lesItems;
	}
	public Items getitems() {
		return item;
	}


	public Epee getEpee() {
		for(int i = 0; i< this.lesItems.size();i++) {
			if(this.lesItems.get(i) instanceof Epee) {
				return (Epee) this.lesItems.get(i);
			}
		}
		return null;
	}

}
