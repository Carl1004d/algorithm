package 剑指offer;

import java.util.ArrayList;

import tree.堆.ListNode;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 */
public class _03从尾到头打印链表 {
	ArrayList list = new ArrayList();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}
}
