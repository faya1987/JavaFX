
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;


public class RTriangle extends MeshView {
	private float s, l, x, y;
	private float[] v;
	private int[] f;
	private TriangleMesh meshx;

	public RTriangle(float s, float l, float x, float y,float z) {
		this.s = s;
		this.l = l;
		this.x = x;
		this.y = y;
		v = new float[9];
		v[0] = x;
		v[1] = y + l;
		v[2] = z;

		v[3] = x + s;
		v[4] = y + l;
		v[5] = z;

		v[6] = x;
		v[7] = y;
		v[8] = z;

		f = new int[12];
		int size = (v.length) / 3;

		for (int j = 0; j < size; j++)
			f[2 * j] = j;
		for (int j = 3; j < 2 * size; j++)
			f[2 * (j)] = (2 * size - 1) - j;
		for (int j = 0; j < f.length; j++)
			if (j % 2 != 0)
				f[j] = 0;

		meshx = new TriangleMesh();
		meshx.getPoints().addAll(v, 0, 9);
		meshx.getTexCoords().addAll(0, 0);
		meshx.getFaces().addAll(f, 0, 12);
		this.setMesh(meshx);
	}
	public float getS() {
		return s;
	}

	public void setS(float s) {
		this.s = s;
	}

	public float getL() {
		return l;
	}

	public void setL(float l) {
		this.l = l;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float[] getV() {
		return v;
	}

	public void setV(float[] v) {
		this.v = v;
	}

	public int[] getF() {
		return f;
	}

	public void setF(int[] f) {
		this.f = f;
	}

	public TriangleMesh getMeshx() {
		return meshx;
	}

	public void setMeshx(TriangleMesh mesh) {
		this.meshx = mesh;
	}

}
