package mediumArraysWrong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _347TopKFrequentElements {
	// 1 2 3 4 5 6 7 8
	// 10 20 13 41 28 40 24 33
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(10);
		q.add(2);
		q.add(4);
		q.add(3);
		System.out.println(q);
	}
	// 用优先队列(最大堆)实现
	public List<Integer> topKFrequent2(int[] nums, int k) {
		// build hash map : character and how often it appears
		HashMap<Integer, Integer> count = new HashMap();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		// init heap 'the less frequent element first'
		// 函数式编程,Comparator为参数
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n2) - count.get(n1));

		// keep k top frequent elements in the heap
		for (int n : count.keySet()) {
			heap.add(n);
		}

		// build output list
		List<Integer> top_k = new LinkedList();
		for(int i = 0 ; i < k; i++)
			top_k.add(heap.poll());
		return top_k;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
}
