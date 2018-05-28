import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class UCamera extends PerspectiveCamera {

	public UCamera(double far, double near, double view, boolean vert) {
		super(true);
		this.setFarClip(far);
		this.setNearClip(near);
		this.setFieldOfView(view);
		this.setVerticalFieldOfView(vert);
	}

	public void translate(double x, double y, double z, boolean clear) {
		Translate t = new Translate(x, y, z);
		if (clear)
			this.getTransforms().clear();
		this.getTransforms().add(t);
	}

	public void rotate(double angle, Point3D axis, boolean clear) {
		Rotate rot = new Rotate(angle, axis);
		if (clear)
			this.getTransforms().clear();
		this.getTransforms().add(rot);
	}

	public void rotateAboutPivot(double angle, double x, double y, double z, Point3D axis, boolean clear) {
		Rotate rot = new Rotate(angle, x, y, z, axis);
		if (clear)
			this.getTransforms().clear();
		this.getTransforms().add(rot);
	}

	public void moveX(double x) {
		translate(x, 0, 0, false);
	}

	public void moveXY(double x, double y) {
		translate(x, y, 0, false);
	}

	public void moveXYZ(double x, double y, double z) {
		translate(x, y, z, false);
	}

	public void moveY(double y) {
		translate(0, y, 0, false);
	}

	public void moveZ(double z) {
		translate(0, 0, z, false);
	}
}
