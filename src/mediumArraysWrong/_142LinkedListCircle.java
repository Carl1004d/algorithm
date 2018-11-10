package mediumArraysWrong;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class _142LinkedListCircle {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode fast = head.next.next;
		ListNode slow = head.next;
		while (fast != slow && fast != null) {
			if (fast.next == null)
				return null;
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while (fast != slow && slow != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;

	}
}
