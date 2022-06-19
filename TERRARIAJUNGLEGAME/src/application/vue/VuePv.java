package application.vue;

import application.modele.Luffy;
import application.modele.Personnage;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VuePv {
	private Image[] tabImage= {new Image("image/perdue.png"),new Image("image/coeur1.png"),new Image("image/coeur2.png"),
			new Image("image/coeur3.png"),new Image("image/coeur.png"),};	
	private ImageView imagea;
	private Luffy perso;
	
	public VuePv(Luffy L,Pane map) {
		this.perso=L;
		this.imagea=new ImageView(tabImage[4]);
		this.imagea.setTranslateY(-100);
		map.getChildren().add(imagea);
		
	}
	
	public IntegerProperty getCoeurs() {
		return this.perso.nbCoeurProperty();
	}
	
	public Image[] getTabImage(){
	 return this.tabImage;
	}
	
	public void setImageActive(Image image) {
		if(image.equals(tabImage[0])) {
			imagea.setImage(tabImage[0]);
			imagea.setTranslateY(0);
			imagea.setOpacity(0.70);
		}else {
			imagea.setImage(image);
			imagea.setTranslateY(-100);
			imagea.setOpacity(1);
		}
		imagea.setImage(image);
	}
}
