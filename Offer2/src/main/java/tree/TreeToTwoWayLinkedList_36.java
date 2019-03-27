package tree;

/**
 * 将树转换成 双向链表的形式(还是树)
 * 运用了 中序遍历的方式. 最终 left 遍历到最大值 结束.
 */
public class TreeToTwoWayLinkedList_36 {

	static TreeNode left;
	static TreeNode right;

	public static TreeNode convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}

		convert(pRootOfTree.left);
		pRootOfTree.left = left;
		if (left != null) {
			left.right = pRootOfTree;
		}
		left = pRootOfTree;
		convert(pRootOfTree.right);
		return left;
	}

	public static void main(String[] args) {

		TreeNode p1 = new TreeNode(10);
		TreeNode p11 = new TreeNode(6);
		TreeNode p12 = new TreeNode(14);
		TreeNode p111 = new TreeNode(4);
		TreeNode p112 = new TreeNode(8);
		TreeNode p121 = new TreeNode(12);
		TreeNode p122 = new TreeNode(16);

		p1.left = p11;
		p1.right = p12;
		p11.left = p111;
		p11.right = p112;
		p12.left = p121;
		p12.right = p122;
		TreeToTwoWayLinkedList_36.convert(p1);
		System.out.println();
	}
}
