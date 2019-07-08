package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import tree.TreeNode;

public class _18从上往下打印二叉树 {
	// [10,6,14,4,8,12,16]
	@Test
	public void test1(){
		
	}
	public static void main(String[] args) {
		_18从上往下打印二叉树 o = new _18从上往下打印二叉树();
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		ArrayList<Integer> arr = o.PrintFromTopToBottom(root);
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if(root==null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			result.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
		return result;
	}
}
