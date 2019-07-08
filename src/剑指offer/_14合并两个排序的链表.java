package 剑指offer;

import tree.堆.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author 84135
 */
public class _14合并两个排序的链表 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode cur1 = list1;
		ListNode cur2 = list2;
		ListNode dummyHead = new ListNode();
		ListNode temp = dummyHead;
		while(cur1!=null && cur2!=null) {
			if(cur1.val > cur2.val) {
				temp.next = cur2;
				temp = temp.next;
				cur2 = cur2.next;
			} else {
				temp.next = cur1;
				temp = temp.next;
				cur1 = cur1.next;
			}
		}
		if(cur1==null)
			temp.next = cur2;
		else 
			temp.next = cur1;
		
		return dummyHead.next;
	}
}
