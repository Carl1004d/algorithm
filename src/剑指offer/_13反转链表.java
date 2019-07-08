package 剑指offer;

import tree.堆.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author 84135
 */
public class _13反转链表 {
	public ListNode ReverseList(ListNode head) {
		if(head==null) return null;
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;
		ListNode cur = head;
		for(;cur.next!=null;){
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = dummyHead.next;
			dummyHead.next = next;
		}
		return dummyHead.next;
    }
}
