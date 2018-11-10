package easyArrays;

import org.junit.Test;

public class onebitand2bitCharacters717 {
	public boolean isOneBitCharacter(int[] bits) {
//		int i = 0;
//		if(bits.length == 1){
//			return true;
//		}
//		if (bits[bits.length - 2] == 0) {
//			return true;
//		} else {
//			while (i < bits.length - 1) { // 在到最后一个0之前
//				if (bits[i] == 0) {
//					i += 1;
//				} else {
//					i += 2;
//				}
//			}
//			/*if (i == (bits.length - 1)) { // 正好到最后的0
//				return true;
//			} else { // 倒是第二个1加了2,超过了最后的0
//				return false;
//			}*/
//			// 上面注释代码简化:
//			return i == bits.length -1;
//		}
		int i = 0;
		int n = bits.length;
		while(i < n-1){
			if (bits[i] == 0) {
				i += 1;
			} else {
				i += 2;
			}
		}
		// ************************************帅气多了这样写
		return i == bits.length-1;
	}

	@Test
	public void fun1() {
		int[] bits = {0, 0 };
		System.out.println(isOneBitCharacter(bits));
	}
}
