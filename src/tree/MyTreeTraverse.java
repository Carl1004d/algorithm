package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 视频中更直观清晰的前中后遍历
 * 
 * @author 84135
 *
 */

class Command {
	TreeNode node;
	String s;

	public Command(String s, TreeNode root) {
		this.s = s;
		this.node = root;
	}
}

public class MyTreeTraverse {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null) return result;
		Stack<Command> stack = new Stack();
		stack.push(new Command("go", root));
		while (!stack.empty()) {
			Command c = stack.pop();
			if (c.s.equals("go")) {
				if(c.node.right!=null){
					stack.push(new Command("go",c.node.right));
				}
				if(c.node.left!=null){
					stack.push(new Command("go",c.node.left));
				}
				stack.push(new Command("print",c.node));
			} else {
				result.add(c.node.val);
			}
		}
		return result;
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null) return result;
		Stack<Command> stack = new Stack();
		stack.push(new Command("go", root));
		while (!stack.empty()) {
			Command c = stack.pop();
			if (c.s.equals("go")) {
				if(c.node.right!=null){
					stack.push(new Command("go",c.node.right));
				}
				stack.push(new Command("print",c.node));
				if(c.node.left!=null){
					stack.push(new Command("go",c.node.left));
				}
				
			} else {
				result.add(c.node.val);
			}
		}
		return result;
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null) return result;
		Stack<Command> stack = new Stack();
		stack.push(new Command("go", root));
		while (!stack.empty()) {
			Command c = stack.pop();
			if (c.s.equals("go")) {
				stack.push(new Command("print",c.node));
				if(c.node.right!=null){
					stack.push(new Command("go",c.node.right));
				}
				
				if(c.node.left!=null){
					stack.push(new Command("go",c.node.left));
				}
				
			} else {
				result.add(c.node.val);
			}
		}
		return result;
	}
}
