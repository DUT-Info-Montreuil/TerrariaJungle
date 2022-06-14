package application.vue;

import application.modele.Bloc;
import application.modele.Terrain;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TerrainVue {

	private Terrain terrain;
	private TilePane mapCarte1;
	private Bloc bloc;
	private VueBloc vuebloc;
	Image ciel = new Image("image/ciel.png");
	Image terre = new Image("image/terre.png");
	Image terre2 = new Image("image/terre2.png");

	public TerrainVue(Terrain terrain, TilePane mapCarte1,Bloc b) {
		this.terrain = terrain;
		this.mapCarte1 = mapCarte1;
		vuebloc= new VueBloc(mapCarte1, bloc);
		bloc =b;

	}


	public void dessinerTerrain() {
		int[] codesTuiles = terrain.getCodesTuiles();


		for (int i = 0 ; i < codesTuiles.length ; i++) {
			switch(codesTuiles[i]) {
				case 747 : mapCarte1.getChildren().add(new ImageView(ciel));
					break;
				case 673 : mapCarte1.getChildren().add(new ImageView(terre));
					break;
				case 543 : mapCarte1.getChildren().add(new ImageView(terre2));
					break;
			}

		}

	}


	public void remplacerBloc (int position) {
		mapCarte1.getChildren().set(position , new ImageView(ciel));

	}





//	private Tilemap map;
//	@FXML
//    private TilePane mapCarte1;
//	
//	public MapVue(Tilemap m, TilePane mc) {
//		this.map=m;
//		//this.mapCarte1=mc;
//		//creationMap();
//		//creationMap();
//		
//		private Image Terre = new Image("application/vue/Terrain/543.png");
//		
//		public void creationMap() {   
//			   
//			for(int i = 0; i<map.getMap().length; i++) {
//				if(this.map.getMap()[i] == 543) {
//					this.mapCarte1.getChildren().add(new ImageView(new Image("application/vue/Terrain/543.png")));//Terre
//				}
//				
//				
//				
//				
//				
//				
//				
//				
//			}
//
//}
}