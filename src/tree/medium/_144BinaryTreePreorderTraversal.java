package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _144BinaryTreePreorderTraversal {
		 public List<Integer> preorderTraversal(TreeNode root) {
				List<Integer> pre = new LinkedList<Integer>();
				if(root==null) return pre;
				pre.add(root.val);
				pre.addAll(preorderTraversal(root.left));
				pre.addAll(preorderTraversal(root.right));
				return pre;
			}
	 // 用栈
	 public List<Integer> preorderIt(TreeNode root) {
			List<Integer> pre = new LinkedList<Integer>();
			if(root==null) return pre;
			Stack<TreeNode> tovisit = new Stack<TreeNode>();
			tovisit.push(root);
			while(!tovisit.empty()) {
				TreeNode visiting = tovisit.pop();
				pre.add(visiting.val);
				if(visiting.right!=null) tovisit.push(visiting.right);
				if(visiting.left!=null) tovisit.push(visiting.left);
			}
			return pre;
		}
}
