package ch11;

import java.util.List;
import java.util.Vector;

public class MyVectorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyVector myVector = new MyVector(10);
		myVector.add(1);
		myVector.add(2);
		myVector.add(3);
		myVector.add(4);
		myVector.add(5);
		print(myVector);
		
		myVector.remove(2);
		print(myVector);
		
		myVector.remove(new Integer(4));
		print(myVector);
		
		myVector.trimToSize();
		print(myVector);
	}
	public static void print(MyVector v) {
		for(int i=0;i<v.size();i++) {
			System.out.print(v.get(i)+",");
		}
		System.out.println();
		System.out.println("size:"+v.size());
		System.out.println("capacity:"+v.capacity());
	}
}
