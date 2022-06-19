package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Bloc;
import application.modele.Ennemi;
import application.modele.Environnement;
import application.modele.Epee;
import application.modele.Inventaire;
import application.modele.Items;
import application.modele.Luffy;
import application.modele.Personnage;
import application.modele.Terrain;
import application.modele.pnj;
import application.vue.TerrainVue;
import application.vue.VueBloc;
import application.vue.VuePv;
import application.vue.vuePersonnage;
import application.vue.vueitem;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Controleur implements Initializable {
	private Timeline gameLoop;
	private Epee epee;
	private Inventaire inv;
	private Bloc blocd;
	private Luffy perso;
	private pnj p;
	private Ennemi enemi;
	private Terrain terrain;

	@FXML
	private Pane inventaire1;
	@FXML
	private Button quitterInv;

	@FXML
	private Pane mapPane;

	@FXML
	private TilePane  mapCarte1;
	@FXML
	private BorderPane mapBorder;
	private Environnement env;


	@FXML
	void quitterInventaire(ActionEvent event) {
		inventaire1.setVisible(false);
		mapPane.requestFocus();
		gameLoop.play();
	}
	@FXML
	void keypres(ActionEvent event) {
		System.out.println("sds");
	}

//			@FXML
//			void mouseclicked(ActionEvent event) {
//				  System.out.println(" clic un Tour");
//			}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//environnement
		this.env=new Environnement();

		// creation du terrain
		terrain = new Terrain(30, 20);
		// creation de bloc
		blocd = new Bloc("block",10,400);
		// creation de d'un observateur de bloc
		VueBloc obsbloc =new VueBloc(mapPane, blocd);
		// creation de la vue du terrain
		TerrainVue terrainVue = new TerrainVue(terrain, mapCarte1, blocd);
		// appele la méthode dessiner terrain
		terrainVue.dessinerTerrain();

		System.out.println(terrain.getHauteur());
		// creation d'un personnage de type personnage
		perso = new Luffy(terrain, "luffy", "oui", 0, 100, 200);
		// creation d'une vue personnage de type vuepersonnage				p= new pnj(terrain, "dfjkgb", "ds", 0, 100, 200);
		enemi=new Ennemi(terrain, "ennemi", "oui", 0, 420, 400);
		p= new pnj(terrain, "dfjkgb", "ds", 0, 86, 200);
		//appele la méthode afficherPersonnage() de la class persovue

		//creattion d'une vue item epee
//				epee=new Epee("epee", 10, null, 10, 0);
		vueitem itemvue = new vueitem(mapPane, inventaire1);


//				persovue.afficherPersonnage();
//				obsbloc.afficherBloc(blocd);
//				vuepnje.afficherPersonnage();

		this.env.getItems().addListener(itemvue);
		this.env.getPersolist().addListener(new ControleursdePersonnages(mapPane, perso));
		this.env.getPersolist().addListener(new ControleursdePersonnages(mapPane, p));
		this.env.getPersolist().addListener(new ControleursdePersonnages(mapPane, enemi));
//				this.env.getPerso().addListener(new ControleursdePersonnages(mapPane, p));
		perso.nbCoeurProperty().addListener(new Observateurpv(new VuePv(perso,mapPane),perso));
		this.env.init();





		//recupere les touches du clavier pour réagir apres avoir KEY_PRESSED
		mapBorder.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
			//création de la methode handle qui recupere chaque touche avec un case pour utiliser les méthode de perso pour déplacer le personnage dans la map

			@Override
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
					case D :perso.deplacementDroit();break;	//allez a droite
					case Q : perso.deplacementGauche();break;//allez a gauche
//					case S  :perso.creusePersonage();break;//creuse ou sneak ou vers le bas (pour le début)
					case Z  : perso.sautPersonage();break;// saut ou vol(pour le début du développement)
					case I : inventaire1.setVisible(true); mapPane.requestFocus();gameLoop.pause();  break;
					default:break;
				}



				/*---------------------------test----------------------------------*/
				//System.out.println(perso.getdirectionpersonnage());


//						System.out.println(terrain.getIndice(419));
//						System.out.println(p.xProperty());
//						System.out.println(p.yProperty());
				System.out.println(p.getX());
				System.out.println(p.getY());
//						p.deplacementPnj();



				/*---------------------------fin test----------------------------------*/
			}
		});



		mapBorder.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {



			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=(int)e.getX();
				int y=(int)e.getY();
//						int xbloc=(int)blocd.getX();
//						int ybloc=(int)blocd.getY();
				int position= ((y/32)*terrain.getLargeur())+x/32;
//						int positionbloc=(ybloc/32)*terrain.getLargeur()+xbloc/32;
				if(terrain.getIndice(position)!=747) {
//								System.out.println(e.getX()/32+"    "+e.getY()/32 );

					switch(e.getButton()) {
						case PRIMARY: //obsbloc.removeBloc(blocd);
							if(!inventaire1.isVisible()) {
								terrain.modifierTuile(x, y, 747);
								terrainVue.remplacerBloc(position);

							}



							System.out.println( terrain.getIndice(position));

						default:
							break;
					}
				}

			}

		});



		initAnimation();

	}
//
//			}

	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kf = new KeyFrame(

				Duration.millis(10),

				(ev ->{

					this.perso.agir();
					p.deplacementPnj(perso);
					enemi.ennemiagit(perso);
					enemi.attaque(perso);
				})
		);

		gameLoop.getKeyFrames().add(kf);
		gameLoop.play();


	}
}


