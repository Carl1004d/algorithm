package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class _103BinaryTreeZigzagLevelOrderTraversal {
	  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		  List<List<Integer>> result = new ArrayList<>();
		  if(root == null) return result;
		  Queue<TreeNode> queue = new LinkedList<>();
		  queue.add(root);
		  int level = 0;
		  while(!queue.isEmpty()){
			  int size = queue.size();
			  List<Integer> subList = new ArrayList<>();
			  for(int i = 0; i < size; i++){
				  TreeNode node = queue.poll();
				  if(level%2==0)
					  subList.add(node.val);
				  else 
					  subList.add(0,node.val);
				  if(node.left!=null) queue.add(node.left);
				  if(node.right!=null) queue.add(node.right);
				  
			  }
			  result.add(subList);
			  level++;
		  }
	        return result;
	    }
	  
	  // DFS
	  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) 
	    {
	        List<List<Integer>> sol = new ArrayList<>();
	        travel(root, sol, 0);
	        return sol;
	    }
	    
	    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
	    {
	        if(curr == null) return;
	        
	        if(sol.size() <= level)
	        {
	            List<Integer> newLevel = new LinkedList<>();
	            sol.add(newLevel);
	        }
	        
	        List<Integer> collection  = sol.get(level);
	        if(level % 2 == 0) collection.add(curr.val);
	        else collection.add(0, curr.val);
	        
	        travel(curr.left, sol, level + 1);
	        travel(curr.right, sol, level + 1);
	    }
}
