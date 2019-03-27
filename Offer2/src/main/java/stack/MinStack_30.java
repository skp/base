package stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack_30 {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void push(int node) {
		stack.push(node);
		if (stack2.isEmpty())
			stack2.push(node);
		else
			stack2.push(node < stack2.peek() ? node : stack2.peek());
	}

	public void pop() {
		stack.pop();
		stack2.pop();
	}

	public int min() {
		return stack2.peek();
	}
}
