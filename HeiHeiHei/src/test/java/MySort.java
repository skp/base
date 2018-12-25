public class MySort {
	
	public static void bubbleSort(Integer[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				int temp;
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			for (int n : arr) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
		
		for (int n : arr) {
			System.out.print(n + ", ");
		}
	}
	
	public static void bubbleSort1(int[] arr) {
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
			for (int n : arr) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
		
		for (int n : arr) {
			System.out.print(n + ", ");
		}
	}
	
	/**
	 * 选择排序算法
	 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
	 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
	 * 以此类推，直到所有元素均排序完毕。
	 *
	 * @param numbers
	 */
	public static void selectSort(int[] numbers) {
		int size = numbers.length; //数组长度
		int temp; //中间变量
		
		for (int i = 0; i < size; i++) {
			int k = i;   //待确定的位置
			//选择出应该在第i个位置的数
			for (int j = size - 1; j > i; j--) {
				if (numbers[j] < numbers[k]) {
					k = j;
				}
			}
			//交换两个数
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
		}
	}
	
	public static void quickSort(Integer[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(Integer[] arr, int low, int high) {
		//1,找到递归算法的出口
		if (low >= high) {
			return;
		}
		//2, 存
		int i = low;
		int j = high;
		//3,key
		int key = arr[low];
		//4，完成一趟排序
		while (i < j) {
			//4.1 ，从右往左找到第一个小于key的数
			while (i < j && arr[j] > key) {
				j--;
			}
			// 4.2 从左往右找到第一个大于key的数
			while (i < j && arr[i] <= key) {
				i++;
			}
			//4.3 交换
			if (i < j) {
				int p = arr[i];
				arr[i] = arr[j];
				arr[j] = p;
			}
		}
		// 4.4，调整key的位置
		int p = arr[i];
		arr[i] = arr[low];
		arr[low] = p;
		//5, 对key左边的数快排
		quickSort(arr, low, i - 1);
		//6, 对key右边的数快排
		quickSort(arr, i + 1, high);
	}
	
	private static void quickSort1(Integer[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int i = low;
		int j = high;
		int pivot = arr[i];
		
		while (i < j) {
			while (i < j && pivot < arr[j]) {
				j--;
			}
			while (i < j && arr[i] <= pivot) {
				i++;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}
		
		swap(arr, low, i);
		
		quickSort1(arr, low, i - 1);
		quickSort1(arr, i + 1, high);
	}
	
	private static void swap(Integer[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void checkSort(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i) {
				System.out.println("Error at " + i);
			}
		}
		System.out.println("Finished checksort");
	}
	
	private static final int NUM_ITEMS = 100;
	private static int theSeed = 1;
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[NUM_ITEMS];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for (theSeed = 0; theSeed < 1; theSeed++) {
			
			// Random.permute(arr);
//			MySort.bubbleSort(arr);
			MySort.quickSort(arr);
			for (int n : arr) {
				System.out.print(n + ", ");
			}
			checkSort(arr);
			
			//			Random.permute( arr );
			//			Sort.quickSelect( arr, NUM_ITEMS / 2 );
			//			System.out.println( arr[ NUM_ITEMS / 2 - 1 ] + " " + NUM_ITEMS / 2 );
		}
		
		//		Integer [ ] b = new Integer[ 10_000_000 ];
		//		for( int i = 0; i < b.length; i++ )
		//			b[ i ] = i;
		
		//		Random.permute( b );
		//		startng start = System.currentTimeMillis( );
		//		Sort.quickSelect( b, b.length  / 2 );
		//		startng end = System.currentTimeMillis( );
		//		System.out.println( "Timing for Section 1.1 example: " );
		//		System.out.println( "Selection for N = " + b.length + " takes " +
		//				( end - start ) + "ms." );
		//		System.out.println( b[ b.length / 2 - 1 ] + " " + b.length / 2 );
	}
}
