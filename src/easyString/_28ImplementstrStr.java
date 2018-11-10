package easyString;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1
 */
public class _28ImplementstrStr {
	// public int strStr(String haystack, String needle) {
	// char[] chas1 = haystack.toCharArray();
	// char[] chas2 = needle.toCharArray();
	// if(chas2.length == 0){
	// return 0;
	// }
	// for (int i = 0; i < chas1.length; i++) {
	// if (chas1[i] == chas2[0]) {
	// int temp = i;
	// int j = 0;
	// for (; j < chas1.length && temp < chas1.length && chas1[temp] ==
	// chas2[j];) {
	// temp++;
	// j++;
	// if(temp == chas1.length || j == chas2.length){
	// break;
	// }
	// }
	// if (j == chas2.length) {
	// return temp - j;
	// }
	// }
	// }
	// return -1;
	// }
	public int strStr(String haystack, String needle) {
		int l1 = haystack.length(), l2 = needle.length();
		if (l1 < l2) {
			return -1;
		} else if (l2 == 0) {
			return 0;
		}
		int threshold = l1 - l2;
		for (int i = 0; i <= threshold; ++i) {
			if (haystack.substring(i, i + l2).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String s1 = "afasasd";
		String s2 = "asa";
		_28ImplementstrStr a = new _28ImplementstrStr();
		System.out.println(a.strStr(s1, s2));
	}
}
