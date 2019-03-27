package list;

public class MergeTwoSortedOfList {
	public static ListNode merge(ListNode list1,ListNode list2) {
		if (list1 == null && list2 == null) return null;
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		ListNode node = null;
		if (list1.val <= list2.val) {
			node = list1;
			node.next = merge(list1.next, list2);
		} else {
			node = list2;
			node.next = merge(list1, list2.next);
		}

		return node;
	}

	private static ListNode compare(ListNode l1, ListNode l2) {
		if (l1.val <= l2.val) {
			return l1;
		} else {
			return l2;
		}
	}
}
