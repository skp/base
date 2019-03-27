package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PrintTailToHead_6 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		while (null != listNode.next) {
			stack.push(listNode.val);
		}

		return new ArrayList<>(stack);
	}
}
