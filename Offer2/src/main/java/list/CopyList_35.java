package list;

public class CopyList_35 {

	public static  RandomListNode clone(RandomListNode pHead) {
		/*if (pHead == null)
			return null;
		RandomListNode currentNext = pHead;

		while (currentNext != null) {
			RandomListNode copy = new RandomListNode(currentNext.val);
			copy.next = currentNext.next;
			currentNext.next = copy;
			currentNext = copy.next;
		}

		currentNext = pHead;
		while (currentNext != null) {
			RandomListNode next = currentNext.next;
			if (currentNext.random != null) {
				next.random = currentNext.random.next;
			}
			currentNext = next.next;
		}

		RandomListNode head = pHead.next;
		RandomListNode node = head;
		while (pHead != null) {
			node = pHead.next;
			pHead = node.next;
			if(pHead != null) {
				node.next = node.next.next;
				node = node.next;
			}
		}

		return head;*/

		if(pHead == null) {
			return null;
		}

		RandomListNode currentNode = pHead;
		//1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
		while(currentNode != null){
			RandomListNode cloneNode = new RandomListNode(currentNode.val);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = cloneNode;
			cloneNode.next = nextNode;
			currentNode = nextNode;
		}

		currentNode = pHead;
		//2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
		while(currentNode != null) {
			currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
			currentNode = currentNode.next.next;
		}

		//3、拆分链表，将链表拆分为原链表和复制后的链表
		currentNode = pHead;
		RandomListNode pCloneHead = pHead.next;
		while(currentNode != null) {
			RandomListNode cloneNode = currentNode.next;
			currentNode.next = cloneNode.next;
			cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
			currentNode = currentNode.next;
		}

		return pCloneHead;
	}

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		n1.next = n2;
		RandomListNode n3 = new RandomListNode(3);
		n1.random = n3;
		n2.next = n3;
		RandomListNode n4 = new RandomListNode(4);
		n3.next = n4;
		RandomListNode n5 = new RandomListNode(5);
		n4.random = n2;
		n4.next = n5;
		n2.random = n5;
		CopyList_35.clone(n1);
	}
}
