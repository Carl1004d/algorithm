package tree.medium;


/**
 * 递归进行。每次找到排序数组的中点，中点左边的子排序数组构成左子树，中点右边的子排序数组构成右子树。
 * 就这样递归进行。由于每次都几乎做到了二分，所以每次的左子树和右子树的节点数量是均衡的，所以最后得到的BST树是balanced。
 */
public class _108ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
	    if (num.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(num, 0, num.length - 1);
	    return head;
	}

	public TreeNode helper(int[] num, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = (low + high) / 2;
	    TreeNode node = new TreeNode(num[mid]);
	    node.left = helper(num, low, mid - 1);
	    node.right = helper(num, mid + 1, high);
	    return node;
	}
	
}
