package ch09;

public final class Card3 {
	String kind;
	int num;
	
	Card3(){
		this("SPADE",1);
	}
	Card3(String kind,int num){
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		return kind+":"+num;
	}
}
