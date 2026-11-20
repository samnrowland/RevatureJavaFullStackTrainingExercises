
public class StringCompression {
	public static String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		if (s.length() == 0) {
			return "";
		}
		
		char cur = s.charAt(0);
		sb.append(cur);
		int count = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if (cur != s.charAt(i)) {
				cur = s.charAt(i);
				sb.append(count).append(cur);
				count = 0;
			}
			count++;
		}
		sb.append(count);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "aaabbccccd";
		String result = compressString(s);
		System.out.println(result);
	}
}
