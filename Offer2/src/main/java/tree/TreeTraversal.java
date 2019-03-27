package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

	public static List<TreeNode> preList = new ArrayList<>();
	public static List<TreeNode> backwardsPoreList = new ArrayList<>();
	public static List<TreeNode> inList = new ArrayList<>();
	public static List<TreeNode> postList = new ArrayList<>();

	/**
	 * 前序遍历
	 * 中->左->右
	 * @param node
	 * @return
	 */
	public static void preorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		preList.add(node);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

	/**
	 * 逆前序遍历  跟前序遍历 称对称 如果一棵树是和他的镜像是对称的, 那么 前序遍历和逆前序遍历是一样的.
	 * 中->右->左
	 * @param node
	 */
	public static void backwardsPreorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		backwardsPoreList.add(node);
		backwardsPreorderTraversal(node.right);
		backwardsPreorderTraversal(node.left);
	}

	/**
	 * 中序遍历
	 * 左->中->右
	 * @param node
	 * @return
	 */
	public static void inorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		inList.add(node);
		inorderTraversal(node.right);
	}

	/**
	 * 后序遍历
	 * 左->右->中
	 * @param node
	 * @return
	 */
	public static void postorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		postList.add(node);

	}

	public static void main(String[] args) {
		TreeNode p1 = new TreeNode(8);
		TreeNode p11 = new TreeNode(6);
		TreeNode p12 = new TreeNode(9);
		TreeNode p111 = new TreeNode(5);
		TreeNode p112 = new TreeNode(7);
		TreeNode p1121 = new TreeNode(7);
		TreeNode p1122 = new TreeNode(5);

		p1.left = p11;
		p1.right = p12;
		p11.left = p111;
		p11.right = p112;
		p12.left = p1121;
		p12.right = p1122;

		TreeTraversal.preorderTraversal(p1);
		TreeTraversal.backwardsPreorderTraversal(p1);
		// TreeTraversal.inorderTraversal(p1);
		// TreeTraversal.postorderTraversal(p1);
		System.out.println();
	}
}
