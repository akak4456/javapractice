package ch09;

public class ClassEx1 {
	public static void main(String[] args) throws Exception{
		Card3 c = new Card3("HEART",3);
		Card3 c2 = Card3.class.newInstance();
		
		Class cObj = c.getClass();
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
	}
}
