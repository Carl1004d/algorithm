package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 *        5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \    / \
	7    2  5   1
	Return:
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	] 
 * 
 */
public class _113PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		backtrack(root, sum, result, new LinkedList<Integer>());
		return result;
	}

	private void backtrack(TreeNode root, int remain, List<List<Integer>> result, LinkedList<Integer> temp) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (remain-root.val == 0) {
				temp.add(root.val);
				result.add(new LinkedList<>(temp));
				temp.removeLast();
			}
		} else {
			temp.add(root.val);
			backtrack(root.left,remain-root.val,result,temp);
			backtrack(root.right,remain-root.val,result,temp);
			temp.removeLast();
		} 
			
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		_113PathSumII o = new _113PathSumII();
		List<List<Integer>> pathSum = o.pathSum(root, 8);
		System.out.println(pathSum);
	}
}
