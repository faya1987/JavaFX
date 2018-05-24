

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class View extends Application{

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		float s=100.0f;
		float l=200.0f;
		float x=-100.0f;
		float y=-100.0f;
		float z=1000.0f;
		TriangleMesh mesh = new TriangleMesh();
		mesh.getPoints().addAll(x,y+l,0,x+s,y+l,0,x,y,0);
		mesh.getTexCoords().addAll(0,0);
		mesh.getFaces().addAll(0,0,1,0,2,0,0,0,2,0,1,0);
		
	
		RTriangle triangle = new RTriangle(s,l,x,y,z);
		
		Scene scene = new Scene(new Group(triangle),800,600);
		scene.setFill(Color.BLACK);
		FCamera camera = new FCamera(2000,0.1,60,true);
		scene.setCamera(camera);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, camera);
		stage.setScene(scene);
		stage.show();
	}

}
