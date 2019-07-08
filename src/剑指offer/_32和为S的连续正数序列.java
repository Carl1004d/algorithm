package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
 * Good Luck!
 */
public class _32和为S的连续正数序列 {
	public static void main(String[] args) {
		_32和为S的连续正数序列 o = new _32和为S的连续正数序列();
		ArrayList<ArrayList<Integer>> list = o.FindContinuousSequence(9);
		for (ArrayList<Integer> arrayList : list) {
			for (Integer integer : arrayList) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(sum < 2) return result;
		int i = 1,remain=sum;
		ArrayList<Integer> temp = new ArrayList<>();
		while(i < sum) {
			if(remain == 0) {
				result.add(new ArrayList<Integer>(temp));
				Integer remove = temp.remove(0);
				remain += remove;
			}
			else if(remain < 0) {
				Integer remove = temp.remove(0);
				remain += remove;
			} else {
				temp.add(i);
				remain -= i;
				if(i==sum-1 && remain==0) result.add(new ArrayList<Integer>(temp));
				i++;
			}
		}
		return result;

	}

}
