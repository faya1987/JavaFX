import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Viewport extends Scene implements EventHandler<Event> {
	private Group root;
	private double increment = 10;
	private UCamera camera, camera1, camera2, camera3, camera4;
	private PointLight light;
	private AmbientLight omni; 
	public Viewport(Group root) {
		super(root, 800, 600, true, SceneAntialiasing.BALANCED);
		omni = new AmbientLight(Color.KHAKI);
		omni.setLightOn(false);
		light = new PointLight(Color.LIGHTYELLOW);
		light.setTranslateX(0);
		light.setTranslateY(0);
		light.setTranslateZ(800);
		this.root = new Group(root);
		this.setRoot(this.root);
		camera1 = new UCamera(2000, 0.1, 30, false);
		camera2 = new UCamera(2000, 0.1, 30, false);
		camera2.setTranslateX(1000);
		camera2.setTranslateZ(1000);
		camera2.setRotationAxis(Rotate.Y_AXIS);
		camera2.setRotate(-90);
		camera3 = new UCamera(2000, 0.1, 30, false);
		camera3.setTranslateX(-1000);
		camera3.setTranslateZ(1000);
		camera3.setRotationAxis(Rotate.Y_AXIS);
		camera3.setRotate(90);
		camera4 = new UCamera(2000, 0.1, 30, false);
		camera4.setTranslateZ(2000);
		camera4.setRotationAxis(Rotate.Y_AXIS);
		camera4.setRotate(-180);
		camera = camera1;
		this.setCamera(camera);
		this.addEventHandler(ScrollEvent.ANY, this);
		this.addEventHandler(KeyEvent.KEY_PRESSED, this);
		this.setFill(Color.BLACK);
	}

	@Override
	public void handle(Event event) {
		if (event.getEventType() == KeyEvent.KEY_PRESSED) {
			
			KeyEvent kev = (KeyEvent) event;
			//System.out.println(kev.getCode().getName());
			switch (kev.getCode().getName()) {
			case "Numpad 5":
				root.getChildren().add(light);
				break;
			case "Multiply":
				root.getChildren().add(omni);
				break;
			case "Numpad 2":
				light.getTransforms().add(new Translate(0,-increment,0));
				break;
			case "Numpad 4":
				light.getTransforms().add(new Translate(increment,0,0));
				break;
			case "Numpad 8":
				light.getTransforms().add(new Translate(0,increment,0));
				break;
			case "Numpad 6":
				light.getTransforms().add(new Translate(-increment,0,0));
				break;
			case "Add":
				light.getTransforms().add(new Translate(0,0,increment));
				break;
			case "Subtract":
				light.getTransforms().add(new Translate(0,0,-increment));
				break;
			case "5":
				light.setLightOn(!light.isLightOn());
				break;
			case "6":
				omni.setLightOn(!omni.isLightOn());
				break;
			case "1":
				this.setCamera(camera1);
				camera = camera1;
				break;
			case "2":
				this.setCamera(camera2);
				camera = camera2;
				break;
			case "3":
				this.setCamera(camera3);
				camera = camera3;
				break;
			case "4":
				this.setCamera(camera4);
				camera = camera4;
				break;
			case "W":
				camera.moveY(-increment);
				break;
			case "S":
				camera.moveY(increment);
				break;
			case "A":
				camera.moveX(-increment);
				break;
			case "D":
				camera.moveX(increment);
				break;
			case "Up":
				camera.rotate(increment, Rotate.X_AXIS, false);
				break;
			case "Down":
				camera.rotate(-increment, Rotate.X_AXIS, false);
				break;
			case "Left":
				camera.rotate(-increment, Rotate.Y_AXIS, false);
				break;
			case "Right":
				camera.rotate(increment, Rotate.Y_AXIS, false);
				break;
			}
		} else if (event.getEventType() == ScrollEvent.SCROLL) {
			ScrollEvent sev = (ScrollEvent) event;
			if (sev.getDeltaY() < 0) {
				camera.moveZ(-increment);
			} else {
				camera.moveZ(increment);
			}
		}

	}

}
