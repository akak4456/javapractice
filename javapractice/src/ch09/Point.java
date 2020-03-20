package ch09;

public class Point implements Cloneable {
	int x,y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x="+x+", y="+y;
	}
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		}catch(CloneNotSupportedException e) {}
		return obj;
	}
}
