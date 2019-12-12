package ch2;

public class CastingEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 1.0e100;
		float f = (float)d;
		System.out.println(f);
		d = 1.0e-50;
		f = (float)d;
		System.out.println(f);
		f = 9.1234567f;
		d = 9.1234567;
		double d2 = (double)f;
		
		System.out.printf("f=%20.18f\n",f);
		System.out.printf("d=%20.18f\n",d);
		System.out.printf("d2=%20.18f\n",d2);
	}

}
