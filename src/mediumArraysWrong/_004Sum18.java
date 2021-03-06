package mediumArraysWrong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _004Sum18 {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4)
			return result;
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j > i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1, right = num.length - 1;

				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[left]);
						list.add(num[right]);
						result.add(list);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1])
							left++;
						while (left < right && num[right] == num[right + 1])
							right--;
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}

		return result;

	}
}
