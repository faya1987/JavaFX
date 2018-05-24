import javafx.scene.shape.TriangleMesh;

public class RTriangle extends TriangleMesh{
	private float s,l,x,y;
	private float[] v;
	private int[] f;
	public RTriangle(float s,float l,float x,float y) {
		this.s=s;this.l=l;this.x=x;this.y=y;
		v=new float[9];
		v[0]=x;
		v[1]=y+l;
		v[2]=0;
		
		v[3]=x+s;
		v[4]=y+l;
		v[5]=0;
		
		v[6]=x;
		v[7]=y;
		v[8]=0;
		
		f=new int[12];
		int size=(v.length)/3;
			
			for(int j=0;j<size;j++)
				f[2*j]=j;
			for(int j=3;j<2*size;j++)
				f[2*(j)]=(2*size-1)-j;
			for(int j=0;j<f.length;j++)
				if(j%2!=0) f[j]=0;
				
		
		this.getPoints().addAll(v,0,9);
		this.getTexCoords().addAll(0,0);
		this.getFaces().addAll(f,0,12);
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
	
	
}
