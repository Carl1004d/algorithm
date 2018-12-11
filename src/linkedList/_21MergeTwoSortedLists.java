package linkedList;

public class _21MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
				temp = temp.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
				temp = temp.next;
			}
		}
		if (l1 == null) {
			temp.next = l2;
		} else {
			temp.next = l1;
		}
		return dummyHead.next;
	}
}
