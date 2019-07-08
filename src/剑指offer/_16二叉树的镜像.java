package 剑指offer;

import tree.TreeNode;

public class _16二叉树的镜像 {
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}

}
