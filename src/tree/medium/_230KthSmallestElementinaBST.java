package tree.medium;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class _230KthSmallestElementinaBST {
	public int kthSmallest1(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest1(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest1(root.right, k - 1 - count); // 1 is counted as
															// current node
		}

		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}

	private static int number = 0;
	private static int count = 0;

	public int kthSmallest2(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left);
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null)
			helper(n.right);
	}

	public int kthSmallest3(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}
}
