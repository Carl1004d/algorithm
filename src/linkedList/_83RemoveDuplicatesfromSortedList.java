package linkedList;
public class _83RemoveDuplicatesfromSortedList {
	  public ListNode deleteDuplicates(ListNode head) {
		    if(head == null){
		    	return null;
		    }
		    ListNode pre = head;
		    ListNode cur;
		    while(pre.next!=null){
		    	cur = pre.next;
		    	if(pre.val == cur.val){
		    		pre.next = cur.next;
		    		cur.next = null;
		    	} else {
		    		pre = cur;
		    	}
		    }
	        return head;
	    }
}
