package 剑指offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */
public class _11二进制中1的个数 {
	public int NumberOf1(int n) {
		int count = 0;
        for(int i = 0; i < 32; i++){
            if((n >>> i & 1) == 1)		// n>>>i n无符号右移i位
                ++count;
        }
        return count;
	}
}
