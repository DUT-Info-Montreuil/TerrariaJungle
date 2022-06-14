package application.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import application.modele.Items;
import application.modele.Personnage;
import application.modele.Terrain;
import application.modele.pnj;


public class vuePersonnage implements ListChangeListener<Personnage> {
	private Pane map;
	private ImageView image;
	private ImageView image2;
	private ImageView image3;
	private Terrain terrain;
	private Personnage perso;
	private IntegerProperty directionpersonnage;

	public vuePersonnage(Pane panneaujeu, Personnage persos)  {
		super();
		this.map=panneaujeu;
		this.perso = persos;
		perso.directionpersonnageProperty().addListener((obs,old,nouv)-> System.out.println(obs +"ancienne valeur:"+"  "+old+"  "+"nouvelle valeur: "+" "+nouv));
		perso.directionpersonnageProperty().addListener((obs,old,nouv)-> {
			if (image.isVisible()) {
				image.setVisible(false);
				image2.setVisible(true);
			}
			else {
				image.setVisible(true);
				image2.setVisible(false);
			}
		});
	}
	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Personnage> perso) {

		while(perso.next()) {
			if(perso.wasAdded()) {
				System.out.println("Personnage ajouté : "+perso.getAddedSubList());
				for(Personnage p : perso.getAddedSubList()) {
					afficherPersonnage();
					this.map.getChildren().add(image);
				}
			}
			if(perso.wasRemoved()) {
				System.out.println("Personnage supprimé : "+ perso.getRemoved());
				for(Personnage p : perso.getRemoved()) {
					removePerso(p);
				}
			}
		}
	}

	public void afficherPersonnage() {
		if(perso instanceof Personnage) {
			image= new ImageView("image/persoPrinc1droite.png");
			image.setId(perso.getId());
			image.translateXProperty().bind(perso.xProperty());
			image.translateYProperty().bind(perso.yProperty());
			map.getChildren().add(image);



			image2= new ImageView("image/persoPrinc1.png");
			image2.setId(perso.getId());
			image2.translateXProperty().bind(perso.xProperty());
			image2.translateYProperty().bind(perso.yProperty());
			map.getChildren().add(image2);
			image2.setVisible(false);

		}
//		else if(perso instanceof pnj) {
//			image3 = new ImageView("image/persoPrinc1droite.png");
//			image3.setId(perso.getId());
//			image3.translateXProperty().bind(perso.xProperty());
//			image3.translateYProperty().bind(perso.yProperty());
//			map.getChildren().add(image3);
//		}

	}

	public void removePerso (Personnage p) {
		this.map.getChildren().removeAll(this.map.lookup("#"+p.getId()));
	}

	public ImageView getImage() {

		return this.image;
	}
}