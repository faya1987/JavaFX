import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String args[]) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//========================================================
		PhongMaterial mat= new PhongMaterial();
		mat.setDiffuseColor(Color.ORANGE);
		mat.setSpecularColor(Color.LIGHTYELLOW);
		mat.setSpecularPower(80);
		Box box = new Box(100, 100, 100);
		box.setId("Box 1");
		box.setMaterial(mat);
		Box box2 = new Box(100, 100, 100);
		box2.setMaterial(mat);
		box2.setId("Box 2");
		box.setTranslateZ(1000);
		box2.setTranslateZ(800);
		box2.setTranslateX(200);
		box.setRotationAxis(Rotate.Y_AXIS);
		box.setRotate(35);
		//========================================================
		Viewport viewport = new Viewport(new Group(box, box2));
		stage.setScene(viewport);
		stage.setTitle("3D Viewer");
		stage.setResizable(false);
		stage.show();
		//========================================================

	}

}
