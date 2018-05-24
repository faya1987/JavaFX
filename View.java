import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

public class View extends Application{

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		float s=100.0f;
		float l=200.0f;
		float x=10.0f;
		float y=10.0f;
		TriangleMesh mesh = new TriangleMesh();
		mesh.getPoints().addAll(x,y+l,0,x+s,y+l,0,x,y,0);
		mesh.getTexCoords().addAll(0,0);
		mesh.getFaces().addAll(0,0,1,0,2,0,0,0,2,0,1,0);
		
	
		MeshView triangle = new MeshView(new RTriangle(s,l,x,y));
		triangle.setTranslateY(0);
		triangle.setTranslateX(0);
		Scene scene = new Scene(new Group(triangle),600,400);
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.show();
	}

}
