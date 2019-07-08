package 剑指offer;

import org.junit.Test;

import tree.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 */
public class _27二叉树深度 {
	int result = 0;
	public int TreeDepth(TreeNode root) {
		if(root == null) return 0;
		result = 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
		return result;
	}
	@Test
	public void test(){
		TreeNode root = new TreeNode();
		root.left = new TreeNode();
		root.right = new TreeNode();
		root.right.left = new TreeNode();
		System.out.println(TreeDepth(root));
	}
}
