package tree;

public class Mirror_27 {
	public void mirror(TreeNode node) {
		if (node == null)
			return;
		TreeNode right = node.right;
		node.right = node.left;
		node.left = right;
		mirror(node.left);
		mirror(node.right);
	}
}
