package mediumStringWrong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _3LongestSubstringWithoutRepeatCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);	// 找最大的重复的位置,再往前走一个.
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String s = "abcdefgafg";
		_3LongestSubstringWithoutRepeatCharacters a = new _3LongestSubstringWithoutRepeatCharacters();
		a.lengthOfLongestSubstring(s);
	}
}
