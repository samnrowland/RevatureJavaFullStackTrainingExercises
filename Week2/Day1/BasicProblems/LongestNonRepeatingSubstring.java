
public class LongestNonRepeatingSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int[] index = new int[256];
		StringBuilder ans = new StringBuilder();
		StringBuilder cur = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (index[s.charAt(i)] != 0) {
				if (cur.length() > ans.length()) {
					ans = new StringBuilder(cur);
				}
				while (cur.length() > 0 && cur.charAt(0) != s.charAt(i)) {
					index[cur.charAt(0)] = 0;
					cur.deleteCharAt(0);
				}
				if (cur.length() > 0) {
					index[cur.charAt(0)] = 0;
					cur.deleteCharAt(0);
				}
			}
			cur.append(s.charAt(i));
			index[s.charAt(i)] = 1;
		}
		if (cur.length() > ans.length()) {
			ans = new StringBuilder(cur);
		}
		return ans.length();
	}
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}
}
