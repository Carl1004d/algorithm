package dynamicProgrammingMedium;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Example 1: s = "abc", t = "ahbgdc"
 * 
 * Return true.
 * 
 * Example 2: s = "axc", t = "ahbgdc"
 * 
 * Return false.
 */
// 题目不好
public class _392IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		char[] chas = s.toCharArray();
		char[] chas2 = t.toCharArray();
		boolean flag = isSub(chas, 0, chas2, 0);
		return flag;
	}

	private boolean isSub(char[] chas, int start1, char[] chas2, int start2) {
		if (start1 < chas.length && start2 < chas2.length) { // chas,chas2都没遍历完
			for (int i = start2; i < chas2.length; i++) {
				if (chas[start1] == chas2[i]) {
					return isSub(chas, start1 + 1, chas2, i+1);
				}
			}
			// 说明循环中没有和chas的某一个字符匹配的
			return false;
		} else if (start1 == chas.length) { // chas遍历完毕,返回true
			return true;
		} else if (start1 < chas.length && start2 == chas2.length) {
			return false;
		}

		return false;
	}
	
	
	 public boolean isSubsequence_2(String s, String t) {
	        if (s.length() == 0) return true;
	        int indexS = 0, indexT = 0;
	        while (indexT < t.length()) {
	            if (t.charAt(indexT) == s.charAt(indexS)) {
	                indexS++;
	                if (indexS == s.length()) return true;
	            }
	            indexT++;
	        }
	        return false;
	    }
	
	
	
	public static void main(String[] args) {
		_392IsSubsequence o = new _392IsSubsequence();
		boolean flag = o.isSubsequence("adce", "abcde");
		System.out.println(flag);
	}
}
