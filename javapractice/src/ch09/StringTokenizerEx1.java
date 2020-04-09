package ch09;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source,",");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
