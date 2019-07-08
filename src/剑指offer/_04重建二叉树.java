package 剑指offer;

import tree.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
 *
 */
public class _04重建二叉树 {
	public static void main(String[] args) {
		_04重建二叉树 o = new _04重建二叉树();
		TreeNode node = o.reConstructBinaryTree(new int[] { 1, 2, 4,3,5,6 }, new int[] { 4,2,1,5,3,6});
		o.tranverse(node);
	}

	

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode head = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return head;
	}

	// 从先序[start1,end1]和后序[start2,end2]构建二叉树,返回头节点
	private TreeNode reConstructBinaryTree(int[] pre, int start1, int end1, int[] in, int start2, int end2) {
		if(start1 > end1 || start2 > end2) return null;
		TreeNode head = new TreeNode(pre[start1]);
		if(start1==end1) return head;
		int j;
		for (j = start2; j <= end2; j++) {
			if (pre[start1] == in[j]) {
				break;
			}
		}
		// 找到先序遍历第一个元素在中序遍历中的位置
		head.left = reConstructBinaryTree(pre, start1 + 1, start1 + j - start2, in, start2, j - 1);// start1+j-start2
																									// 为pre第一个元素加上第二个元素切出来的长度
		head.right =  reConstructBinaryTree(pre, start1 + j - start2 + 1, end1, in, j + 1, end2);
		return head;
	}
	
	
	public void tranverse(TreeNode node) {
		if(node == null) return;
		System.out.println(node.val);
		tranverse(node.left);
		tranverse(node.right);
	}
}
