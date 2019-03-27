package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class TopToBottomPrintTree_32 {

	static Queue<TreeNode> q = new LinkedList<>();

	public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			list.add(node.val);
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}

		return list;
	}

}

