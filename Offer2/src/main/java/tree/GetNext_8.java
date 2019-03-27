package tree;

import java.util.Objects;

public class GetNext_8 {
	public TreeNode GetNext(TreeNode node) {
		if(null == node)
			return null;
		if (null != node.right) {
			node = node.right;
			while (null != node.left) {
				node = node.left;
			}
			return node;
		}

		while (null != node.parent) {
			if (node == node.parent.left)
				return node.parent;
			node = node.parent;

		}
		return null;
	}
}
