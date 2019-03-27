import java.util.Arrays;

public class QuickSort {
	public static void quickSort(Integer[] arr, int start, int end) {

		if (start >= end)
			return;

		int pivot = median3(arr, start, end);
		int i = start, j = end;

		while (true) {
			while (pivot >= arr[i++]) {}
			while (pivot < arr[j--]) {}

			if (i < j) {
				swapReferences(arr, i, j);
			} else {
				break;
			}
		}

		Arrays.stream(arr).forEach((num)-> System.out.println(num + ", "));

		swapReferences(arr, i, end - 1);
		quickSort( arr, start, i - 1 );    // Sort small elements
		quickSort( arr, i + 1, end );   // Sort large elements

	}

	/**
	 * Return median of left, center, and right.
	 * Order these and hide the pivot.
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	AnyType median3( AnyType [ ] a, int left, int right )
	{
		int center = ( left + right ) / 2;
		if( a[ center ].compareTo( a[ left ] ) < 0 )
			swapReferences( a, left, center );
		if( a[ right ].compareTo( a[ left ] ) < 0 )
			swapReferences( a, left, right );
		if( a[ right ].compareTo( a[ center ] ) < 0 )
			swapReferences( a, center, right );

		// Place pivot at position right - 1
		swapReferences( a, center, right - 1 );
		return a[ right - 1 ];
	}

	/**
	 * Method to swap to elements in an array.
	 * @param a an array of objects.
	 * @param index1 the index of the first object.
	 * @param index2 the index of the second object.
	 */
	public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
	{
		AnyType tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}

	public static void main(String[] args) {
	}
}
