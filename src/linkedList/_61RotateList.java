package linkedList;

public class _61RotateList {
	public static void main(String[] args) {
		_61RotateList o = new _61RotateList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		o.reorderList(head);
	}
	 public void reorderList(ListNode head) {
		  if(head==null||head.next==null) return;
          
          //Find the middle of the list
          ListNode p1=head;
          ListNode p2=head;
          while(p2.next!=null&&p2.next.next!=null){ 
              p1=p1.next;
              p2=p2.next.next;
          }
          
          //Reverse the half after middle  1->2->3(preMiddle)->4(preCurrent)->5(current)->6 to 1->2->3->6->5->4	  // 反转后面的链表
          ListNode preMiddle=p1;
          ListNode preCurrent=p1.next;
          while(preCurrent.next!=null){
              ListNode current=preCurrent.next;
              preCurrent.next=current.next;
              current.next=preMiddle.next;
              preMiddle.next=current;
          }
          
          //Start reorder one by one  1(p1)->2->3->6(p2)->5->4 to 1->6->2->5->3->4
          p1=head;
          p2=preMiddle.next;
          while(p1!=preMiddle){
              preMiddle.next=p2.next;
              p2.next=p1.next;
              p1.next=p2;
              p1=p2.next;
              p2=preMiddle.next;
          }
	    }
}
