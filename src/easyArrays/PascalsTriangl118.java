package easyArrays;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return 
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
/*
 * 杨辉三角
 */
public class PascalsTriangl118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(numRows == 0){
			return lists;
		}
		for(int i = 0;i < numRows; i++){
			List<Integer> ints = new ArrayList<>();
			lists.add(ints);
		}
		lists.get(0).add(1);
		for (int i = 1; i < numRows; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					lists.get(i).add(1);
				} else {
					lists.get(i).add(lists.get(i-1).get(j)+lists.get(i-1).get(j-1));
				}
			}
		}
		return lists;
	}

	@Test
	public void fn1() {
		List<Integer> list = new ArrayList<Integer>();
		Integer a = 5;
		list.add(a);
		list.add(a);
		System.out.println(list);
	}
}
