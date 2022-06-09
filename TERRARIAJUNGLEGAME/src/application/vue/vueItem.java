//package application.vue;
//
//import javafx.collections.ListChangeListener;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import application.modele.Items;
//
//import application.modele.Epee;
//
//
//public class vueItem implements ListChangeListener<Items> {
//	private Pane inventaire;
//	private Pane map;
//	private ImageView image;
//
//	public vueItem(Pane p, Pane inv) {
//		this.map=p;
//		this.inventaire = inv;
//	}
//
//	@Override
//	public void onChanged(Change<? extends Items> item) {
////		while(item.next()) {
////			if(item.wasAdded()) {
////				System.out.println("arme ajouté : "+ item.getAddedSubList());
////				for(Items a : item.getAddedSubList()) {
////						addArme(a);
////						if(a instanceof Epee) {
////						this.inventaire.getChildren().add(image);
////					}
////				}
////			}
//
//			if(item.wasRemoved()) {
//				System.out.println("arme supprimé : "+ item.getRemoved());
//				System.out.println("arme supprimé : "+ item.getRemoved());
//				for(Items a : item.getRemoved()) {
//					if(a instanceof Epee) {
//						removeArmeInv(a);
//					}
//				}
//			}
//		}
//	}
//	public void addArme(Items a) {
//
//		if(a instanceof Epee) {
//			image= new ImageView("image/epee.png");
//		}
//
//
//		image.setId(a.getId());
//		image.translateXProperty().bind(a.xProperty());
//		image.translateYProperty().bind(a.yProperty());
//
//	}
//
//	public void removeArmeMap (Items a) {
//		this.map.getChildren().removeAll(this.map.lookup("#"+a.getId()));
//	}
//
//	public void removeArmeInv (Items a) {
//		this.inventaire.getChildren().removeAll(this.inventaire.lookup("#"+a.getId()));
//	}
//
//	}
//
