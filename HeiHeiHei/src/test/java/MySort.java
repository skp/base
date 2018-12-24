public class MySort {
	
	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,1,11,15,18};
		int pos;
		int len = arr.length;
		int nextJ = len - 1;
		for (int i = 0; i < len - 1; i++) {
			pos = 0;
			for (int j = 0; j < nextJ; j++) {
				int temp;
				if (arr[j] > arr[j + 1]) {
					pos = j;
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			nextJ = pos;
			System.out.println("pos: " + pos);
			if (pos == 0) {
				break;
			}
			for (int n:arr
					) {
				System.out.print(n+", ");
			}
			System.out.println();
		}
		
		for (int n:arr
		) {
			System.out.print(n+", ");
		}
	}
}
