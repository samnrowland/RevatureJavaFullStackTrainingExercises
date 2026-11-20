
public class ReverseNumber {

	public static int reverseInt(int num) {
		int reverse = 0;
		while (num > 0) {
			reverse *= 10;
			reverse += num % 10;
			num /= 10;
		}
		return reverse;
	}
	
	public static void main(String[] args) {
		int r = reverseInt(12345);
		System.out.println(r);
	}
}
