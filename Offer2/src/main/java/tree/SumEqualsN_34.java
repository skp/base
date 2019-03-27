package tree;

import java.util.ArrayList;

/**
 * 二叉树的一条 root 到 叶子节点 的和为target的 所有路径.
 */
public class SumEqualsN_34 {

	ArrayList<ArrayList<Integer>> l = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null) return null;
		ArrayList<Integer> list = new ArrayList<>();
		find(root, 0, list, target);
		return l;
	}

	/**
	 * 这实际是一个前序遍历的方式.
	 * @param node
	 * @param sum
	 * @param list
	 * @param target
	 */
	private void find(TreeNode node, int sum, ArrayList<Integer> list, int target) {
		sum += node.val;
		list.add(node.val);
		if (sum == target && node.left == null && node.right == null) {
			l.add(new ArrayList<>(list));
		} else if (sum < target) {
			if (node.left != null) {
				find(node.left, sum, list, target);
			}
			if (node.right != null) {
				find(node.right, sum, list, target);
			}
		}
		list.remove(list.size() - 1);
	}
}
