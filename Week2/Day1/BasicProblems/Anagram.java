
public class Anagram {
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			char next = str1.charAt(i);
			if (str2.indexOf(next) == -1) {
				return false;
			} else {
				str2 = str2.replaceFirst(Character.toString(next), " ");
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		if (isAnagram(str1, str2)) {
			System.out.println("Anagram");
		} else {
			System.out.println("Not Anagram");
		}

	}

}
