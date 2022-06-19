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

import application.modele.Epee;
import application.modele.Inventaire;


public class vueitem implements ListChangeListener<Items> {
    private Pane inventaire;
    private Pane map;
    private ImageView image;


    public vueitem(Pane p,Pane inv) {
        this.map=p;
        this.inventaire = inv;

    }

    @Override
    public void onChanged(Change<? extends Items> item) {
        while(item.next()) {
            if(item.wasAdded()) {
                System.out.println("arme ajoutée : "+ item.getAddedSubList());
                for(Items a : item.getAddedSubList()) {
                    addArme(a);
                    if(a instanceof Epee) {
                        this.inventaire.getChildren().add(image);

                    }
                }
            }

            if(item.wasRemoved()) {
                System.out.println("arme supprimé : "+ item.getRemoved());
                for(Items a : item.getRemoved()) {
                    if(a instanceof Epee) {
                        removeArmeInv(a);
                    }
                }
            }
        }
    }
    public void addArme(Items item) {

        if( item instanceof Epee) {
            image= new ImageView("image/epee.png");

        }


        image.setId(item.getId());
        image.translateXProperty().bind(item.xProperty());
        image.translateYProperty().bind(item.yProperty());
        map.getChildren().add(image);

    }

    public void removeArmeMap (Items a) {
        this.map.getChildren().removeAll(this.map.lookup("#"+a.getId()));
    }

    public void removeArmeInv (Items a) {
        this.inventaire.getChildren().removeAll(this.inventaire.lookup("#"+a.getId()));
    }

}

