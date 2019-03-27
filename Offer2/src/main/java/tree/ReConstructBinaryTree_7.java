package tree;

import java.util.Arrays;

public class ReConstructBinaryTree_7 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (null == pre || null == in || pre.length != in.length) {
			return null;
		}

		return constructCore(pre, in);
	}

	private TreeNode constructCore(int[] pre, int[] in) {
		int length = pre.length;
		int rootValue = pre[0];
		TreeNode node = new TreeNode(rootValue);
		if (length == 1) {
			return node;
		}
		int inRootMiddle = 0;
		int inLeftLength = 0, inRightLength = 0;
		for (int i : in) {
			if (i == rootValue) {
				inLeftLength = inRootMiddle;
				inRightLength = length - inLeftLength - 1;
				break;
			}
			inRootMiddle++;
		}

		if (inLeftLength > 0) {
			int[] preNew = Arrays.copyOfRange(pre, 1, inLeftLength + 1);
			int[] inNew = Arrays.copyOf(in, inLeftLength);
			node.left = constructCore(preNew, inNew);
		}

		if (inRightLength > 0) {
			int[] preNew = Arrays.copyOfRange(pre, inRootMiddle + 1, length);
			int[] inNew = Arrays.copyOfRange(in, inRootMiddle + 1, length);
			node.right = constructCore(preNew, inNew);
		}

		return node;
	}

	public static void main(String[] args) {
		// TreeNode node = new ReConstructBinaryTree_7().reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
		TreeNode node = new ReConstructBinaryTree_7().reConstructBinaryTree(new int[]{1,2,3,4,5,6,7}, new int[]{3,2,4,1,6,5,7});
		System.out.println(node.val);
	}
}
