package list;

public class NodeOdIntoLoop_23 {

	public static ListNode entryNodeOfLoop(ListNode pHead) {
		if (null == pHead || null == pHead.next)
			return null;
		ListNode p1, p2;
		p1 = pHead;
		p2 = pHead;
		while (true) {
			if (null == p1.next || null == p1.next.next) {
				return null;
			}
			p1 = p1.next.next;
			p2 = p2.next;
			// p1走2, p2走1  当相遇时, p1会比p2多走了一个环的长度 (环中有几个节点就是几) 而p2走了一个环的长度
			// 此时让p1指针重新回到头结点然后 同步移动, 再次首次相遇时的节点即为环的入口
			if (p1 == p2) {
				p1 = pHead;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				return p1;
			}
		}
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
		n4.next = n2;
		NodeOdIntoLoop_23.entryNodeOfLoop(h);
	}
}
