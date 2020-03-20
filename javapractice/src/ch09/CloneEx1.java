package ch09;

public class CloneEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point original = new Point(3,5);
		Point copy = (Point)original.clone();
		System.out.println(original);
		System.out.println(copy);
	}

}
