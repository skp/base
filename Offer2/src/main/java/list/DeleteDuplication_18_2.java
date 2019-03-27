package list;

public class DeleteDuplication_18_2 {

	public static ListNode deleteDuplication(ListNode head) {
		if (head == null)
			return null;
		ListNode preDuplicationNode = null;
		ListNode firstDuplicationNode = null;
		ListNode currentNode = head;

		while (currentNode != null) {
			if (null != firstDuplicationNode && currentNode.val == firstDuplicationNode.val) {
				if (currentNode.next == null || currentNode.next.val != firstDuplicationNode.val) {
					if (preDuplicationNode == null) {
						head = currentNode.next;
						firstDuplicationNode = null;
					} else {
						preDuplicationNode.next = currentNode.next;
						firstDuplicationNode = preDuplicationNode;
					}
				} else if (currentNode.next.val == firstDuplicationNode.val) {
					currentNode = currentNode.next;
					continue;
				}
			} else {
				preDuplicationNode = firstDuplicationNode;
				firstDuplicationNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(1);
		head.next = node2;
		ListNode node3 = new ListNode(1);
		node2.next = node3;
		/*ListNode node4 = new ListNode(3);
		node3.next = node4;
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		ListNode node6 = new ListNode(4);
		node5.next = node6;
		ListNode node7 = new ListNode(5);
		node6.next = node7;*/
		DeleteDuplication_18_2.deleteDuplication(head);
	}

}
