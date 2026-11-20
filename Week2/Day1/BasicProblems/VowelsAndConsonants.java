
public class VowelsAndConsonants {
	public static void CountVowelsAndConsonants(String s) {
		int vowels = 0;
		int consonants = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				if ( "AEIOUaeiou".indexOf(s.charAt(i)) != -1) {
					vowels++;
				} else {
					consonants++;
				}
			}
		}
		System.out.println("Vowels: " + vowels);
		System.out.println("Consonants: " + consonants);
	}
	
	public static void main(String[] args) {
		CountVowelsAndConsonants(" Programming ");
	}

}
