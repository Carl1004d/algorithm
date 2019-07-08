package 剑指offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 */
public class _21字符串排列 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0)
			return result;
		Permutation(result, "", str, new boolean[str.length()]);
		return result;
	}

	private void Permutation(ArrayList<String> result, String temp, String str, boolean[] used) {
		if (temp.length() == str.length())
			result.add(temp);
		for (int i = 0; i < str.length(); i++) {
			if (used[i])
				continue;
			// 表示两个相等的字符的前一个已经被递归回溯完了,所以这个一样的不用再交换提前去递归回溯了
			if (i > 0 && str.charAt(i) == str.charAt(i - 1) && !used[i - 1])
				continue;

			used[i] = true;
			temp = temp + str.charAt(i);
			Permutation(result, temp, str, used);
			used[i] = false;
			temp = temp.substring(0, temp.length() - 1);
		}
	}

	// public ArrayList<String> Permutation(String str) {
	// ArrayList<String> result = new ArrayList<String>();
	// if (str == null || str.length() == 0)
	// return result;
	// Permutation(result, 0, str.toCharArray());
	// return result;
	// }
	//
	// private void Permutation(ArrayList<String> result, int index, char[]
	// chas) {
	// if(index == chas.length-1) {
	// result.add(new String(chas));
	// return;
	// }
	// for(int i = index; i < chas.length; i++) {
	// if(i != index && chas[i] == chas[index]) continue;
	// swap(chas,i,index);
	// Permutation(result,index+1,chas);
	// swap(chas,i,index);
	// }
	// }
	//
	// private void swap(char[] chas, int i, int index) {
	// char temp = chas[i];
	// chas[i] = chas[index];
	// chas[index] = temp;
	// }

}
