
public class SwapNumbers {
	
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = 20;
		System.out.println("Arithmetic: Before swapping: a = " + a + ", b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("Arithmetic: After swapping: a = " + a + ", b = " + b);
		
		a = Integer.MAX_VALUE;
		b = 20;
		System.out.println("XOR: Before swapping: a = " + a + ", b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("XOR: After swapping: a = " + a + ", b = " + b);
	}
}
