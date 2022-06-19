package application.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import application.modele.Ennemi;
import application.modele.Items;
import application.modele.Luffy;
import application.modele.Personnage;
import application.modele.Terrain;
import application.modele.pnj;


public class vuePersonnage {
	private Pane map;
	private ImageView image;
	private ImageView image2;
	

	public vuePersonnage(Pane panneaujeu,Personnage perso )  {
		super();
		this.map=panneaujeu;
		this.afficherPersonnage(perso);
	
		}

                                                                                                                                                                                       	
	public void afficherPersonnage(Personnage perso) {
		if(perso instanceof Luffy) {
				image= new ImageView("image/persoPrinc1droite.png");	
				image2= new ImageView("image/persoPrinc1.png");
			
			
		}
		if(perso instanceof pnj) {
			image= new ImageView("image/persoPrinc1droite.png");	
			image2= new ImageView("image/persoPrinc1.png");
		}
		else if(perso instanceof Ennemi) {
			image= new ImageView("image/pnjDroit.png");	
			image2= new ImageView("image/pnjGauche.png");
		}
		image.setId(perso.getId());
		image.translateXProperty().bind(perso.xProperty());
		image.translateYProperty().bind(perso.yProperty());
		map.getChildren().add(image);
		image2.setId(perso.getId());
		image2.translateXProperty().bind(perso.xProperty());
		image2.translateYProperty().bind(perso.yProperty());
		map.getChildren().add(image2);
		image2.setVisible(false);
		
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
	public Pane getPane() {
		return map;
	}
}