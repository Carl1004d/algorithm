package easyArrays;

import java.util.ArrayList;
import java.util.List;
/**
 * 倒着给赋值,头和尾不要动就行了
 * 在每次行的循环之后加上最后一个1
 * @author 84135
 *
 */
/*
 * Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1]. 
 */
public class PascalsTriangleII119 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int temp = list.get(j) + list.get(j-1);
				list.set(j, temp);
			}
			list.add(1);
		}
		return list;
	}
}
