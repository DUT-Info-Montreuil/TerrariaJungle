package application.controleur;

import application.modele.Luffy;
import application.modele.Personnage;
import application.vue.VuePv;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Observateurpv implements ChangeListener<Number> {
	

	private VuePv pv;
	private Luffy perso;
	public Observateurpv(VuePv pv,Luffy p) {

		this.perso=p;
		this.pv=pv;
		
	}
	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		switch (perso.nbCoeurProperty().getValue()) {
	
		case 4:
			pv.setImageActive(pv.getTabImage()[4]);
		
			break;
		case 3:
			pv.setImageActive(pv.getTabImage()[3]);
			
			break;
		case 2:
			pv.setImageActive(pv.getTabImage()[2]);
			
			break;
		case 1:
			
			pv.setImageActive(pv.getTabImage()[1]);
		
			break;
//		case 0:
//			
//			pv.setImageActive(pv.getTabImage()[0]);
//			perso.getEnv().arreterLeJeu();
//			break;
				
		default:
			break;
		} 
		
	}
	
	

		
}
