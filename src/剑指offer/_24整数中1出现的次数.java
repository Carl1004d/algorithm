package 剑指offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。 ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class _24整数中1出现的次数 {

	public int NumberOf1Between1AndN_Solution2(int n) {
		if (n < 0)
			return 0;
		int i = 1;
		int high = n;
		int cnt = 0;
		while (high != 0) {
			high = (int) (n / Math.pow(10, i));// high表示当前位的高位
			int temp = (int) (n / Math.pow(10, i - 1));
			int cur = temp % 10;// cur表示第i位上的值，从1开始计算
			int low = (int) (n - temp * Math.pow(10, i - 1));// low表示当前位的低位
			if (cur < 1) {
				cnt += high * Math.pow(10, i - 1);
			} else if (cur > 1) {
				cnt += (high + 1) * Math.pow(10, i - 1);

			} else {

				cnt += high * Math.pow(10, i - 1);
				cnt += (low + 1);

			}
			i++;
		}
		return cnt;
	}
}
/**
 * e.g. 2156: 算个位数为1的: 2156/10=215 result = 215*10, 2156-2150=6, result += (6+1)
 * 算十位数为1的: 2156/100=21 result = 21*100, 2156-2100=56 result += 10(10,11,12....19十个数字)
 */