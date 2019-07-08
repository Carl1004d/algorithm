package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 视频中更直观清晰的前中后遍历
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

// 用栈
public class MyTreeTraverse {
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		MyTreeTraverse o = new MyTreeTraverse();
		List<Integer> result = o.preorderTraversal2(head);
		for (Integer integer : result) {
			System.out.print(integer+" ");
		}
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<Command> stack = new Stack<>();
		stack.push(new Command("go", root));
		while (!stack.empty()) {
			Command c = stack.pop();
			if (c.s.equals("go")) {
				if (c.node.right != null) {
					stack.push(new Command("go", c.node.right));
				}
				
				stack.push(new Command("print", c.node));
				
				if (c.node.left != null) {
					stack.push(new Command("go", c.node.left));
				}
				
			} else {
				result.add(c.node.val);
			}
		}
		return result;
	}

	// 用栈普通先序递归方法
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			cur= stack.pop();
			if(cur.right!=null) stack.push(cur.right);
			if(cur.left!=null) stack.push(cur.left);
			result.add(cur.val);
		}
		return result;
	}
	
	
	

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<Command> stack = new Stack();
		stack.push(new Command("go", root));
		while (!stack.empty()) {
			Command c = stack.pop();
			if (c.s.equals("go")) {
				if (c.node.right != null) {
					stack.push(new Command("go", c.node.right));
				}
				stack.push(new Command("print", c.node));
				if (c.node.left != null) {
					stack.push(new Command("go", c.node.left));
				}

			} else {
				result.add(c.node.val);
			}
		}
		return result;
	}

	// 用栈普通中序递归方法
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<Command> stack = new Stack();
		stack.push(new Command("go", root));
		while (!stack.empty()) {
			Command c = stack.pop();
			if (c.s.equals("go")) {
				stack.push(new Command("print", c.node));
				if (c.node.right != null) {
					stack.push(new Command("go", c.node.right));
				}

				if (c.node.left != null) {
					stack.push(new Command("go", c.node.left));
				}

			} else {
				result.add(c.node.val);
			}
		}
		return result;
	}

	// 用栈普通后序递归方法
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		TreeNode last = null;
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.peek();
			//在不存在右节点或者右节点已经访问过的情况下，访问根节点
			if (cur.right == null || last == cur.right){
				stack.pop();
				result.add(cur.val);
				last = cur;
				cur = null;
			} else
				cur = cur.right;
		}
		return result;
	}
}

// 递归
class MyTreeTraverse2 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		traversal(result, root);
		return result;
	}

	// 先序递归(未考虑null)
	private void traversal(List<Integer> result, TreeNode root) {
		result.add(root.val);
		traversal(result, root.left);
		traversal(result, root.right);
	}

	// 中序(未考虑null)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode cur = root;
		TreeNode pre = root;
		inorderTraversal2(result, root);
		return result;
	}

	private void inorderTraversal2(List<Integer> result, TreeNode root) {
		inorderTraversal2(result, root.left);
		result.add(root.val);
		inorderTraversal2(result, root.right);
	}

	// 后序一样
	
	
	
	
	
	
	
	
	// 不用那个中间节点也可以
	private void tranverse(Stack<TreeNode> stack) {
		if(!stack.isEmpty()){
			
			TreeNode node = stack.pop();
			if(node==null) return;
			// 颠倒三者顺序即可
			stack.push(node.right);
			tranverse(stack);
			
			System.out.println(node.val);
			
			stack.push(node.left);
			tranverse(stack);
			
		}
	}
}
