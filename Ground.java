import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Ground extends Box{
	private PhongMaterial mat;
	public Ground(double w,double h) {
		super(w,h,10);
		this.setTranslateZ(1000);
		this.setTranslateY(600);
		this.setRotationAxis(Rotate.X_AXIS);
		this.setRotate(-90);
	}
	public Ground(double w,double h,Color bkgd) {
		super(w,h,10);
		this.setTranslateZ(w);
		this.setTranslateY(600);
		this.setRotationAxis(Rotate.X_AXIS);
		this.setRotate(-90);
		mat = new PhongMaterial();
		mat.setDiffuseColor(bkgd);
		this.setMaterial(mat);
	}
	public Ground(double w,double h,String texMap) {
		super(w,h,10);
		this.setTranslateZ(1000);
		this.setTranslateY(600);
		this.setRotationAxis(Rotate.X_AXIS);
		this.setRotate(-90);
		mat = new PhongMaterial();
		mat.setDiffuseMap(new Image(texMap));
		this.setMaterial(mat);
	}
}
