package mediumStringWrong.递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 *
 */
// 自己做的!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class _93RestoreIPAddress {
	public static void main(String[] args) {
		_93RestoreIPAddress o = new _93RestoreIPAddress();
		o.restoreIpAddresses("25525511135");
	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		backtrack(list, s, "", 0);
		return list;
	}

	private void backtrack(List<String> list, String s, String temp, int count) {
		if (count == 4) {
			if (s.length() == 0) {
			//	list.add(temp.substring(0, temp.length()));
				list.add(temp.substring(0, temp.length()-1));
				return;
			} else {
				return;
			}
		}
		
		for (int i=1; i<4; i++) {
	        if (s.length()< i) break;
	        String substring = s.substring(0,i);
	        if ((substring.startsWith("0") && substring.length()>1) || (i==3 && Integer.parseInt(substring) >= 256)) continue;
	        backtrack(list, s.substring(i,s.length()), temp+substring+(count==3?"" : "."), count+1);
	    }
		
		
//		if (s.length() >= 1)
//			backtrack(list, s.substring(1, s.length()), temp + s.substring(0, 1) + ".", count + 1);
//		if (s.length() >= 2) {
//			String substring = s.substring(0, 2);
//			if (substring.charAt(0) != '0')	// 第一个是0,不算
//				backtrack(list, s.substring(2, s.length()), temp + s.substring(0, 2) + ".", count + 1);
//		}
//
//		if (s.length() >= 3) {// if(Integer.parseInt(aString)>255||(aString.length()
//								// > 1 && aString.charAt(0)=='0')) continue;
//			String num = s.substring(0, 3);
//			Integer n = Integer.valueOf(num);
//			if (n <= 255 && num.charAt(0) != '0') // 第一个是0,不算
//				backtrack(list, s.substring(3, s.length()), temp + s.substring(0, 3) + ".", count + 1);
//		}
	}
}
