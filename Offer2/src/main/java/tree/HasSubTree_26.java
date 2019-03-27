package tree;

public class HasSubTree_26 {

	public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}

		return isEquils(root1, root2, root2);
	}

	private static boolean isEquils(TreeNode root1, TreeNode root2, TreeNode current2) {
		if (current2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val == current2.val) {
			return (isEquils(root1.left, root2, current2.left) && isEquils(root1.right, root2, current2.right)) || isEquils(root1.left, root2, root2) || isEquils(root1.right, root2, root2);
		} else {
			return isEquils(root1.left, root2, root2) || isEquils(root1.right, root2, root2);
		}
	}

	public static void main(String[] args) {
		TreeNode p1 = new TreeNode(8);
		TreeNode p11 = new TreeNode(8);
		TreeNode p12 = new TreeNode(7);
		TreeNode p111 = new TreeNode(9);
		TreeNode p112 = new TreeNode(2);
		TreeNode p1121 = new TreeNode(4);
		TreeNode p1122 = new TreeNode(7);

		p1.left = p11;
		p1.right = p12;
		p11.left = p111;
		p11.right = p112;
		p112.left = p1121;
		p112.right = p1122;

		TreeNode p2 = new TreeNode(8);
		TreeNode p21 = new TreeNode(9);
		TreeNode p22 = new TreeNode(2);

		p2.left = p21;
		p2.right = p22;

		System.out.println(HasSubTree_26.hasSubTree(p1, p2));
	}
}
