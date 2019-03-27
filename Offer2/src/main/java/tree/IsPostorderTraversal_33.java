package tree;

/**
 * 是否是后序遍历.
 * 方法: 最后一个是root 找左树和右树, 左树都小于rootVal 右树都大于rootVal, 否则false
 * 递归处理 左右树.
 */
public class IsPostorderTraversal_33 {

	public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		if (start >= end) {
			return true;
		}
		int rootVal = sequence[end];
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] > rootVal) {
				break;
			}
		}
		int j = i;
		for (; j < end; j++) {
			if (sequence[j] < rootVal) {
				return false;
			}
		}
		return verifySequenceOfBST(sequence, start, i - 1) && verifySequenceOfBST(sequence, i, end - 1);
	}

	public static void main(String[] args) {
		System.out.println(IsPostorderTraversal_33.verifySequenceOfBST(new int[]{1, 2, 3, 4, 5}, 0, 4));
	}
}
