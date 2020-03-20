package ch09;

public class Person {
	long id;
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Person)
			return id == ((Person)obj).id;
		else
			return false;
	}
	Person(long id){
		this.id = id;
	}
}
