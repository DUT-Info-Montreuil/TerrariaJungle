package application.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bloc {

	private String id;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private int verif;
//	private int pv;


	public Bloc (String i,int x ,int y){
		this.id = i;
		this.xProperty =new SimpleIntegerProperty(x) ;
		this.yProperty =new SimpleIntegerProperty(y) ;
	}
//	public int addbloc() {
//		int x= getX()/32;
//	
//		
//	}

	public String getId() {
		return this.id;
	}
	public  int getX() {
		return xProperty.getValue();
	}
	public  void setX(int n){
		xProperty.setValue(n);
	}
	public  IntegerProperty xProperty(){
		return this.xProperty;
	}
	public  int getY() {
		return yProperty.getValue();
	}
	public  void setY(int n){
		yProperty.setValue(n);
	}
	public  IntegerProperty yProperty(){
		return this.yProperty;
	}
//	public void perdVie(int x) {
//        this.pv = this.pv - x;
//        if(this.pv <0) {
//            this.pv = 0;
//        }
//    }
//	public int getVie() {
//		return this.pv;
//	}
}