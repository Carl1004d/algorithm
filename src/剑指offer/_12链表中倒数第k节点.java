package 剑指offer;

import tree.堆.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author 84135
 */
public class _12链表中倒数第k节点 {
	public ListNode FindKthToTail(ListNode head, int k) {
		return null;
	}
}
/**
 * 可以用两个指针，一个指针遍历到第k个结点的时候，第二个指针再走到第一个节点，
 * 然后两个指针的距离始终保持k-1，这样，当第一个指针的next==NULL，也就是走到最后一个节点的时候，
 * 第二个指针对应的位置，就是倒数第k个结点。
 */