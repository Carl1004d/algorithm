package 剑指offer;

import java.util.Stack;

import tree.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _20二叉搜索树与双向链表 {
	TreeNode temp;
	public TreeNode Convert(TreeNode pRootOfTree) {	// left表示前面,right表示后面
		if(pRootOfTree==null) return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode dummyNode = new TreeNode();
		temp = dummyNode;
		stack.push(pRootOfTree);
		tranverse(stack);
		TreeNode result = dummyNode.right;
        result.left=null;
		return result;
	}

	private void tranverse(Stack<TreeNode> stack) {
		if(!stack.isEmpty()){
			
			TreeNode node = stack.pop();
			if(node==null) return;
			
			stack.push(node.left);
			tranverse(stack);
			
			
//			System.out.println(node.val);
			temp.right = node;
			node.left = temp;
			temp = node;
			
			
			stack.push(node.right);
			tranverse(stack);
			
			
		}
	}
	
	public static void main(String[] args) {
		 _20二叉搜索树与双向链表 o = new  _20二叉搜索树与双向链表();
		 TreeNode node = new TreeNode(10);
		 node.left = new TreeNode(8);
		 node.left.left = new TreeNode(7);
		 node.left.right = new TreeNode(9);
		 node.right = new TreeNode(13);
		 node.right.left = new TreeNode(12);
		 node.right.left.left = new TreeNode(11);
		 node.right.right = new TreeNode(14);
//		 Stack<TreeNode> stack = new Stack<>();
//		 stack.push(node);
//		 o.tranverse(stack, null);
		 
		 
		 TreeNode node2 = o.Convert(node);
		 while(node2!=null)
		 {
			 System.out.println(node2.val);
			 node2 = node2.right;
		 }
	}
}
