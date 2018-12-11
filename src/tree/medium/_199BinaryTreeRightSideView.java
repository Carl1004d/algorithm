package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4] Output: [1, 3, 4] Explanation:
 * 
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class _199BinaryTreeRightSideView {
	// BFS   Time Limit Exceeded
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(queue!=null){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				if(i == queue.size()-1) result.add(node.val);
				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
			}
		}
		return result;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	// DFS
	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}
}
