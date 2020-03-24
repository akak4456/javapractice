package ch09;

public class Point2 implements Cloneable {
	int x,y;
	Point2(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x="+x+", y="+y;
	}
	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone();
		}catch(CloneNotSupportedException e) {}
		return (Point)obj;
	}
}
