package mediumArraysWrong;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
 * together with x-axis forms a container, such that the container contains
 * the most water. Note: You may not slant the container and n is at least
 * 2. 数组中的每个数对应一条线段的长度，索引对应x坐标，两个索引可以组成一个底部的宽，高度就是前面所说的线段的长度，而既然是要盛水，
 * 高度就是两个线段中较短的一个。
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;
		while (left < right && left >= 0 && right <= height.length - 1) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return maxArea;
	}
}
