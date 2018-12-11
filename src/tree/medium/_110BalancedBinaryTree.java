package tree.medium;

public class _110BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if(left == -1 || right == -1) return false;
		if (Math.abs(left - right) <= 1)
			return true;
		return false;
	}

	private int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if(left == -1 || right == -1) return -1;
		if(Math.abs(left-right) > 1) return -1;
		return Math.max(left,right) + 1;
	}
}
