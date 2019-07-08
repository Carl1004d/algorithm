package 剑指offer;

import org.junit.Test;

import tree.TreeNode;

/**
 * 
 * @author 84135 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class _15树的子结构 {
	private boolean Doroot1hasroot2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		} else if (root1 == null) {
			return false;
		}

		if (root1.val != root2.val)
			return false;

		return Doroot1hasroot2(root1.left, root2.left) && Doroot1hasroot2(root1.right, root2.right);

	}

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = Doroot1hasroot2(root1, root2);
			}

			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

}
