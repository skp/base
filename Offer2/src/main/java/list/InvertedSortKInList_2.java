package list;

public class InvertedSortKInList_2 {

	/**
	 * 倒数1开始 倒数0 为null .
	 */
	public ListNode findKInTail(ListNode head, int k) {
		if(k < 1 || null == head)
			return null;
		int p1 = 1;
		ListNode nodePoint1 = head;
		ListNode nodePoint2 = head;
		while (p1 < k) {
			nodePoint1 = nodePoint1.next;
			if (null == nodePoint1) {
				return null;
			}
			p1++;
		}
		while (null != (nodePoint1 = nodePoint1.next)) {
			nodePoint2 = nodePoint2.next;
		}

		return nodePoint2;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);
		ListNode list6 = new ListNode(6);
		ListNode list7 = new ListNode(7);
		ListNode list8 = new ListNode(8);
		ListNode list9 = new ListNode(9);
		ListNode list10 = new ListNode(10);
		// ListNode list = new ListNode();
		// ListNode list = new ListNode();
		// ListNode list = new ListNode();
		// ListNode list = new ListNode();
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = list6;
		list6.next = list7;
		list7.next = list8;
		list8.next = list9;
		list9.next = list10;
		System.out.println(new InvertedSortKInList_2().findKInTail(list1, 9).val);
	}
}
