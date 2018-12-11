package tree.medium;

import java.util.LinkedList;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example: Example:
 * 
 * Input: [1,2,3]
 *  1
   / \
  2   3
   Output: 25 Explanation: The root-to-leaf path 1->2
 * represents the number 12. The root-to-leaf path 1->3 represents the number
 * 13. Therefore, sum = 12 + 13 = 25. Example 2:
 * 
 * Input: [4,9,0,5,1] 
 *  4
   / \
  9   0
 / \
5   1
 * Output: 1026 Explanation: The
 * root-to-leaf path 4->9->5 represents the number 495. The root-to-leaf path
 * 4->9->1 represents the number 491. The root-to-leaf path 4->0 represents the
 * number 40. Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class _129SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		backtrack(result,root,0);
		int sum = 0;
		for (Integer i : result) {
			sum += i;
		}
		return sum;
	}

	private void backtrack(LinkedList<Integer> result, TreeNode root, int num) {
		if(root==null)
			return;
		if(root.left==null && root.right==null){
			result.add(num*10+root.val);
		} else {
			backtrack(result,root.left,num*10+root.val);
			backtrack(result,root.right,num*10+root.val);
		}
	}
	
	
	public int sumNumbers2(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}
	
	public static void main(String[] args) {
		_129SumRoottoLeafNumbers o = new _129SumRoottoLeafNumbers();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left = new TreeNode(3);
		int result = o.sumNumbers(root);
		System.out.println(result);
	}
}
