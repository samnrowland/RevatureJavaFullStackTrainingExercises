
public class SentenceReverse {
	public static String reverseSentence(String s) {
		StringBuilder sb = new StringBuilder();
		if (s.length() == 0) {
			return s;
		}
		s = s.strip();
		int insert = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (i > 0 && Character.isLetter(cur) && !Character.isLetter(s.charAt(i - 1))) {
				insert = 0;
			}
			sb.insert(insert, cur);
			insert++;
		}
		sb.insert(insert, ' ');
		return sb.toString().strip();
	}
	
	public static void main(String[] args) {
		String s = "Java  is easy to learn     ";
		String result = reverseSentence(s);
		System.out.println(result);

	}

}
