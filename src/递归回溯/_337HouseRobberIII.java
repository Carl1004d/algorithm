package 递归回溯;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class _337HouseRobberIII {
	// 递归,没加记忆化搜索
	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;

		int max = 0;
		int[] temp = new int[4];
		if (root.left != null && root.right != null) {
			temp[0] = max;
			temp[1] = rob(root.left) + rob(root.right);
			temp[3] = rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
					+ root.val;
			max = getMax(temp);
		} else if (root.left != null) {
			temp[0] = max;
			temp[1] = rob(root.left);
			temp[3] = rob(root.left.left) + rob(root.left.right) + root.val;
			max = getMax(temp);
		} else if (root.right != null) {
			temp[0] = max;
			temp[2] = rob(root.right);
			temp[3] = rob(root.right.left) + root.val + rob(root.right.right);
			max = getMax(temp);
		}
		return max;
	}

	private int getMax(int[] temp) {
		int max = 0;
		for (int i : temp) {
			if (max < i) {
				max = i;
			}
		}
		return max;
	}

	// 记忆化搜索
	public int rob2(TreeNode root) {
	    return robSub(root, new HashMap<>());
	}

	private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
	    if (root == null) return 0;
	    if (map.containsKey(root)) return map.get(root);
	    
	    int val = 0;
	    
	    if (root.left != null) {
	        val += robSub(root.left.left, map) + robSub(root.left.right, map);
	    }
	    
	    if (root.right != null) {
	        val += robSub(root.right.left, map) + robSub(root.right.right, map);
	    }
	    
	    val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
	    map.put(root, val);
	    
	    return val;
	}
	
	//	返回两个数,一个是抢这个,一个是不抢这个
	public int rob3(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}
}
