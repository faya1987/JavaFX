import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class FCamera extends PerspectiveCamera implements EventHandler<KeyEvent>{
	
	
	private double increment=10;
	public FCamera() {
		super(true);
		
	}
	public FCamera(double far, double near,double view,boolean vert) {
		super(true);
		this.setFarClip(far);
		this.setNearClip(near);
		this.setFieldOfView(view);
		this.setVerticalFieldOfView(vert);
		
	}
	
	public void translate(double x,double y,double z,boolean clear) {
		Translate t = new Translate(x,y,z);
		if(clear) this.getTransforms().clear();
		this.getTransforms().add(t);
	}
	public void rotate(double angle,Point3D axis,boolean clear) {
		Rotate rot = new Rotate(angle,axis);
		if(clear) this.getTransforms().clear();
		this.getTransforms().add(rot);
	}
	public void moveHorz(double x) {
		translate(x,0,0,false);
	}
	public void moveVert(double y) {
		translate(0,y,0,false);
	}
	public void zoom(double z) {
		translate(0,0,z,false);
	}
	public void rotateAboutPivot(double angle,double x,double y,double z,Point3D axis,boolean clear) {
		Rotate rot = new Rotate(angle,x,y,z,axis);
		if(clear) this.getTransforms().clear();
		this.getTransforms().add(rot);
	}

	public double getIncrement() {
		return increment;
	}
	public void setIncrement(double increment) {
		this.increment = increment;
	}
	@Override
	public void handle(KeyEvent event) {
		switch(event.getCode().getName()) {
		case "Up":
			moveVert(-increment);
			break;
		case "Down":
			moveVert(increment);
			break;
		case "Left":
			moveHorz(-increment);
			break;
		case "Right":
			moveHorz(increment);
			break;
		case "W":
			rotate(-increment,Rotate.X_AXIS,false);
			break;
		case "S":
			rotate(increment,Rotate.X_AXIS,false);
			break;
		case "A":
			rotate(-increment,Rotate.Y_AXIS,false);
			break;
		case "D":
			rotate(increment,Rotate.Y_AXIS,false);
			break;
		case "Z":
			zoom(increment);
			break;
		case "X":
			zoom(-increment);
			break;
		case "Q":
			rotate(-increment,Rotate.Z_AXIS,false);
			break;
		case "E":
			rotate(increment,Rotate.Z_AXIS,false);
			break;
		}
		
	}
	
}
