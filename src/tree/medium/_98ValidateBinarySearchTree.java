package tree.medium;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees. Example 1:
 *
 * Input:
	    2
	   / \
	  1   3
	Output: true
	Example 2:
	
	    5
	   / \
	  1   4
	     / \
	    3   6
	Output: false
	Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
	             is 5 but its right child's value is 4.
 */
public class _98ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	// 中序遍历有序,所以只需要在中序遍历时候判断有序即可
	public boolean isValidBST2(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}

	public static void main(String[] args) {
		_98ValidateBinarySearchTree o = new _98ValidateBinarySearchTree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);

		boolean validBST = o.isValidBST(root);
		System.out.println(validBST);
	}
}
