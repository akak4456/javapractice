package ch11;

public class MyStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack st = new MyStack();
		st.push("0");
		st.push("1");
		st.push("2");
		while(!st.empty())
			System.out.println(st.pop());
	}

}
