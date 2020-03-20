package ch09;

public class Card2 {
	String kind;
	int number;
	Card2(){
		this("SPADE",1);
	}
	Card2(String kind,int number){
		this.kind = kind;
		this.number = number;
	}
	public String toString() {
		return "kind : "+kind+", number : "+number;
	}
}
