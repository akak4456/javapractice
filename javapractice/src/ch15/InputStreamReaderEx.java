package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("������� OS�� ���ڵ� : "+isr.getEncoding());
			do {
				System.out.print("������ �Է��ϼ���. ��ġ�÷��� q�� �Է��ϼ���.>");
				line = br.readLine();
				System.out.println("�Է��Ͻ� ���� : "+line);
			}while(!line.equalsIgnoreCase("q"));
			br.close();
			System.out.println("���α׷��� �����մϴ�.");
		}catch(IOException e) {}
	}

}