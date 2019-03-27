package list;

public class ReverseList_24 {
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null, next;

		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode n1 = new ListNode(2);
		h.next = n1;
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		ListNode n3 = new ListNode(4);
		n2.next = n3;
		ListNode n4 = new ListNode(5);
		n3.next = n4;
		ReverseList_24.reverseList(h);
	}
}
