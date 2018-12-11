package tree.medium;

/**
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove. If the node is found, delete the node. Note:
 * Time complexity should be O(height of tree).
 * 
 * 左边提上去右边提上去都可以
 */
public class _450DeleteNodeinaBST {
	
	public TreeNode deleteNode(TreeNode root, int key) {
	    if(root == null){
	        return null;
	    }
	    if(key < root.val){
	        root.left = deleteNode(root.left, key);
	    }else if(key > root.val){
	        root.right = deleteNode(root.right, key);
	    }else{
	        if(root.left == null){
	            return root.right;
	        }else if(root.right == null){
	            return root.left;
	        }
	        
	        TreeNode minNode = findMin(root.right);
	        root.val = minNode.val;
	        root.right = deleteNode(root.right, root.val);
	    }
	    return root;
	}

	private TreeNode findMin(TreeNode node){
	    while(node.left != null){
	        node = node.left;
	    }
	    return node;
	}
}
