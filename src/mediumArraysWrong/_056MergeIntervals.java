package mediumArraysWrong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [
 * [1,3],
 * [2,6],
 * [8,10],
 * [15,18]] Output: [
 * [1,6],
 * [8,10],
 * [15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
 * are considerred overlapping.
 * 
 */
public class _056MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() < 2)
			return intervals;
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start == i2.start ? i1.end - i2.end : i1.start - i2.start;
			}
		});
		Interval temp = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval newI = intervals.get(i);
			if (newI.start <= temp.end) {
				temp.start = Math.min(newI.start, temp.start);
				temp.end = Math.max(newI.end, temp.end);
			} else {
				result.add(temp);
				temp = newI;
			}

		}
		result.add(temp);

		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}