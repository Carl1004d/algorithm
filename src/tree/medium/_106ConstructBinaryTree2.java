package tree.medium;

/**
 * Given  inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] Return the following binary
 * tree: 3 / \ 9 20 / \ 15 7
 */
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

public class _106ConstructBinaryTree2 {
//	public TreeNode buildTree(int[] inorder, int[] postorder) {
//	    return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
//	}
//
//	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
//			int postStart) {
//		if (postStart < 0 || inStart < inEnd)
//			return null;
//		
//		//The last element in postorder is the root.
//		TreeNode root = new TreeNode(postorder[postStart]);
//		
//		//find the index of the root from inorder. Iterating from the end.
//		int rIndex = inStart;
//		for (int i = inStart; i >= inEnd; i--) {
//			if (inorder[i] == postorder[postStart]) {
//				rIndex = i;
//				break;
//			}
//		}
//		//build right and left subtrees. Again, scanning from the end to find the sections.
//		root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
//		root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
//		return root;
//	}
	 private int pS = 0;	// 这个用来计数,计递归掉的节点个数,也就是上面方法中的最后一个参数
	   public TreeNode buildTree(int[] inorder, int[] postorder) {
	       int len = inorder.length;
	       pS = len-1;
	       return buildTree(inorder, 0, len-1, postorder);
	   }
	   
	    private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder) {
	        if(iEnd < iStart || iStart < 0) return null;
	        TreeNode root = new TreeNode(postorder[pS]);
	        pS--;
	        int index = -1;
	        for(int i=iStart;i<=iEnd;i++){
	            if(inorder[i] == root.val) {
	                index = i;
	                break;
	            }
	        }
	        root.right = buildTree(inorder, index+1, iEnd, postorder);
	        root.left = buildTree(inorder, iStart, index-1, postorder);
	       
	        return root;
	    }
}
