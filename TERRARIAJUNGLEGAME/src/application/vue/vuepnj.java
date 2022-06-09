package application.vue;

import application.modele.Personnage;
import application.modele.Terrain;
import application.modele.pnj;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vuepnj {
	private Pane map;
	private ImageView image;
	private ImageView image2;
	private ImageView image3;
	private Terrain terrain;
	private pnj perso;
	private IntegerProperty directionpersonnage; 

	public vuepnj(Pane panneaujeu, pnj pnj) {
		super();
		this.map=panneaujeu;
		this.perso = pnj;
		
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
	
	public void afficherPersonnage() {
		if(perso instanceof pnj) {
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
//		 if(perso instanceof pnj) {
//			image3 = new ImageView("image/persoPrinc2.png");
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
		
		return this.image3;
	}
}
