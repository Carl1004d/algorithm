package linkedList;



public class _92ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode lastNode = dummyHead;
		for(int i = 1; i < m; i++){
			lastNode = lastNode.next;
		}
		ListNode tempNode = lastNode.next;// 1 3 2 4 5
		ListNode nextNode = tempNode.next;
		for(int i = m; i < n; i++){
			tempNode.next = nextNode.next;
			nextNode.next = lastNode.next;
			lastNode.next = nextNode;
			nextNode = tempNode.next;
		}
		return dummyHead.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		_92ReverseLinkedListII o = new _92ReverseLinkedListII();
		o.reverseBetween(head, 2, 4);
	}
}
