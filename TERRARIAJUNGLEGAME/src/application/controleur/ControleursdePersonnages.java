package application.controleur;

import application.modele.Personnage;
import application.vue.vuePersonnage;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ControleursdePersonnages implements ListChangeListener<Personnage> {
	
	private Personnage perso;
	private Pane pane;
	
	public ControleursdePersonnages(Pane pane  ,Personnage perso) {
		this.perso=perso;
		this.pane=pane;
	}
	@Override
	public void onChanged(Change<? extends Personnage> perso) {
		while(perso.next()) {
			if(perso.wasAdded()) {
				System.out.println("Personnage ajout� : "+perso.getAddedSubList());
				for(Personnage p : perso.getAddedSubList()) {
					p=this.perso;
					vuePersonnage vuep=new vuePersonnage(pane,p);
				}
				
					
				}
			}
			if(perso.wasRemoved()) {
				System.out.println("Personnage supprim� : "+ perso.getRemoved());
				for(Personnage p : perso.getRemoved()) {
					p=this.perso;
					vuePersonnage vuep=new vuePersonnage(pane,p);
					vuep.removePerso(p);
					
				}
			}
		
	}

}
