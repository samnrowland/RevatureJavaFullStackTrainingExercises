
public class MethodLab {
	public static double toFahrenheit(double celsius) {
		return (celsius * 9/5) + 32;
	}
	
	public static int percent(int obtained, int total) {
		return (int) (((double) obtained / total) * 100);
	}
	
	public static String describeInt(int num) {
		return num + " -> binary " + Integer.toBinaryString(num) + ", hex " + Integer.toHexString(num) + ", octal " + Integer.toOctalString(num);
	}
	
	public static void swap(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("inside: a=" + a + ", b=" + b);
	}
	
	public static void addTitle(StringBuilder name) {
		name.insert(0, "Dr. ");
	}
	
	public static String addTitleToString(String name) {
		return "Dr. " + name;
	}
	
	public static int charCount(String s, char c) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
	
	public static String capitalize(String s) {
		if (s.length() == 0) {
			return s;
		}
		return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}
	
	public static String padLeft(String s, int totalLength, char padChar) {
		if (s.length() >= totalLength) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < totalLength - s.length(); i++) {
			sb.append(padChar);
		}
		sb.append(s);
		return sb.toString();
	}
	
	public static String joinWithDash(String s, int times) {
		if (times <= 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(s);
			if (i < times - 1) {
				sb.append("-");
			}
		}
		return sb.toString();
	}
	
	public static int roundHalfUp(double d) {
		return (int) (d + 0.5);
	}
	
	public static int factorialInt(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative numbers are not allowed.");
		}
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public static long factorialLong(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative numbers are not allowed.");
		}
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public static int countVowels(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = Character.toLowerCase(s.charAt(i));
			if ("aeiouAEIOU".indexOf(c) != -1) {
				count++;
			}
		}
		return count;
	}
	
	public static String summarize(String s) {
		return "Length: " + s.length() + " | Upper: " + s.toUpperCase() + " | Vowels: " + countVowels(s);
	}
	
	public static void main(String[] args) {
		System.out.println(toFahrenheit(0));
		System.out.println(toFahrenheit(37.5));
		System.out.println(toFahrenheit(-40));

		System.out.println(percent(45, 60));
		System.out.println(percent(1, 3));
		
		System.out.println(describeInt(255));
		System.out.println(describeInt(8));
		
		int a = 1;
		int b = 2;
		swap(a, b); // Pass by value, a and b in main are not affected
		System.out.println("outside: a=" + a + ", b=" + b);
		
		// StringBuilder is mutable, so changes made inside the method will affect the original object.
		// String is immutable, so changes made inside the method will not affect the original object.
		StringBuilder sb = new StringBuilder("Rao");
		addTitle(sb);
		System.out.println(sb);
		String s = "Rao";
		addTitleToString(s);   // result ignored
		System.out.println(s);
		System.out.println(addTitleToString(s));
		
		System.out.println(charCount("banana", 'a'));
		System.out.println(charCount("banana", 'z'));
		System.out.println(capitalize("jAVA"));
		
		System.out.println(padLeft("42", 5, '0'));
		System.out.println(joinWithDash("ab", 3));
		
		System.out.println(roundHalfUp(2.5));
		System.out.println(roundHalfUp(2.4));
		System.out.println(roundHalfUp(7.0));
		
		System.out.println(factorialInt(5));
		System.out.println(factorialLong(5));
		System.out.println(factorialInt(13));
		System.out.println(factorialLong(13));
		System.out.println(factorialLong(20));
		
		System.out.println(summarize("Hello World"));
		System.out.println(summarize("Sky"));
	}

}
