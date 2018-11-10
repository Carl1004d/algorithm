package mediumStringWrong;

import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.events.Characters;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17LetterCombinationsaPhoneNumber {
	public List<String> letterCombinations(String digits) {

		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		LinkedList<String> ls = new LinkedList<String>();
		if (digits.isEmpty())
			return ls;
		ls.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));

			while (ls.peek().length() == i) {
				String t = ls.remove();
				for (char c : mapping[x].toCharArray()) {
					ls.add(t + c);
				}
			}
		}
		return ls;

	}

	public List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		while (ans.peek().length() != digits.length()) {
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length()) - '0'];
			for (char c : map.toCharArray()) {
				ans.addLast(remove + c);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		_17LetterCombinationsaPhoneNumber o = new _17LetterCombinationsaPhoneNumber();
		o.letterCombinations("2345");
	}
}
