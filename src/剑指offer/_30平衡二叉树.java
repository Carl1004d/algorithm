package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import tree.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class _30平衡二叉树 {
	public static void main(String[] args) {

		_30平衡二叉树 o = new _30平衡二叉树();
		TreeNode root = new TreeNode();
		root.left = new TreeNode();
		root.right = new TreeNode();
		root.left.left = new TreeNode();
		root.left.left.left = new TreeNode();
		root.right.left = new TreeNode();
		root.right.right = new TreeNode();
		root.right.right.right = new TreeNode();
		boolean bool = o.IsBalanced_Solution(root);
		System.out.println(bool);
	}

	private boolean isBalanced = true;

	public boolean IsBalanced_Solution(TreeNode root) {
		getDepth(root);
		return isBalanced;
	}

	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);

		if (Math.abs(left - right) > 1) {
			isBalanced = false; // 只要有一个错误,哪就是false了
		}
		return right > left ? (right + 1) : (left + 1);
	}

	
	
	
	// 方法2,递归(比较慢)
	public boolean IsBalanced_Solution2(TreeNode root) {
		if (root == null) { // 一棵空树就是平衡二叉树
			return true;
		}
		if (Math.abs(getDepth2(root.left) - getDepth2(root.right)) <= 1) {
			// 满足左右子树高度差小于等于1,那就接着判断左右子树是不是二叉树
			return (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right));
		} else {
			// 不满足左右子树高度差小于等于1,那这棵树肯定不是平衡二叉树啦
			return false;
		}
	}

	public int getDepth2(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return (left > right ? left : right) + 1;
	}
}
