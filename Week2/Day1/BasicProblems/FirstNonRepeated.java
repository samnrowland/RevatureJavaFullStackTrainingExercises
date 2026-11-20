
public class FirstNonRepeated {
	public static char firstNonRepeatedChar(String str) {
		int[] counts = new int[256];
		for (int i = 0; i < str.length(); i++) {
			counts[str.charAt(i)]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (counts[str.charAt(i)] == 1) {
				return str.charAt(i);
			}
		}
		return '\0';
	}
	
	public static void main(String[] args) {
		char result = firstNonRepeatedChar("swiss");
		if (result != '\0') {
			System.out.println(result);
		} else {
			System.out.println("No non-repeated character found.");
		}

	}

}
