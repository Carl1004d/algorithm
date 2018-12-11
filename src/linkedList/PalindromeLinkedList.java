package linkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * Input: 1->2 Output: false Example 2:
 * 
 * Input: 1->2->2->1 Output: true Follow up: Could you do it in O(n) time and
 * O(1) space?
 */
public class PalindromeLinkedList {
	
public static void main(String[] args) {
	PalindromeLinkedList o = new PalindromeLinkedList();
	ListNode head = new ListNode(1);
	head.next = new ListNode(1);
	head.next.next = new ListNode(2);
	head.next.next.next = new ListNode(1);
	o.isPalindrome(head);
}
	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		// 反转当前slow及其后面节点,即可对比
		ListNode pre = slow;// 1 1 2 1 null
		ListNode cur;
		ListNode head2 = slow;
		while(pre.next != null){
			cur = pre.next;
			pre.next = cur.next;
			cur.next = head2;
			head2 = cur;
		}
		// 比较
		while(head2!=null){
			if(head.val!=head2.val)
				return false;
			head = head.next;
			head2 = head2.next;
		}
		return true;
	}
}
