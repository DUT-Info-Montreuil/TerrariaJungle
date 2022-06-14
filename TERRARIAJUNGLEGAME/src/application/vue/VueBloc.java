package application.vue;
import java.util.ArrayList;

import application.modele.Bloc;
import application.modele.BlocDestructible;
import application.modele.Terrain;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueBloc {

	private Pane map;
	private ImageView image;
	private Terrain terrain;
	private BlocDestructible blocdestructible;
	private Bloc bloc;
	public VueBloc(Pane p,Bloc b) {
		super();
		this.map=p;
		terrain=new Terrain(30,20);
		bloc=b;
	}



	public void afficherBloc(Bloc b) {
		if(b instanceof Bloc) {
			image= new ImageView("image/terre.png");
			map.getChildren().add(image);
		}


		image.setId(bloc.getId());
		image.translateXProperty().bind(bloc.xProperty());
		image.translateYProperty().bind(bloc.yProperty());
	}


	public void removeBloc (Bloc b) {
		this.map.getChildren().removeAll(this.map.lookup("#"+b.getId()));
	}
}