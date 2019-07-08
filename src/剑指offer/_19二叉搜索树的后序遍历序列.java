package 剑指offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class _19二叉搜索树的后序遍历序列 {
	public static void main(String[] args) {
		_19二叉搜索树的后序遍历序列 o = new _19二叉搜索树的后序遍历序列();
		boolean bool = o.VerifySquenceOfBST(new int[] { 4, 8, 6, 12, 16, 14, 10 });
		System.out.println(bool);
	}

	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence==null || sequence.length==0) return false;
		return isPostSequenceTree(sequence, 0, sequence.length - 1);
	}

	// 判断[start,end]是否为后序遍历的二叉树
	private boolean isPostSequenceTree(int[] sequence, int start, int end) {
		if (start > end)
			return true;
		int root = sequence[end];
		int i;
		for (i = end - 1; i >= start; i--) {
			if (root > sequence[i]) {
				break;
			}
		}
		// 找的的i前边的都是小于root的
		for (; i >= start; i--) {
			if (sequence[i] > root)
				return false;
		}

		return isPostSequenceTree(sequence, start, i) && isPostSequenceTree(sequence, i + 1, end - 1);
	}
}
