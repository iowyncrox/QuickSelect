import java.util.Arrays;

public class QuickSelect {

	public static int KthSmallestElement(int[] array, int start, int end,
			int KthElement) {

		if (KthElement > 0 && KthElement <= end - start + 1) {
			int j = partition(array, start, end);

			if (j - start == KthElement - 1) {
				return array[j];
			}

			if (j - start > KthElement - 1) {
				return KthSmallestElement(array, start, j - 1, KthElement);
			}

			return KthSmallestElement(array, j + 1, end, KthElement - j + start
					- 1);
		}
		return (int) Integer.MAX_VALUE;
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[low];
		int i = low;
		int j = high + 1;

		while (true) {
			while (compare(array[++i], pivot)) {
				if (i == high)
					break;
			}

			while (compare(pivot, array[--j])) {
				if (j == low)
					break;
			}

			if (i >= j) {
				break;
			}

			swap(array, i, j);
		}

		swap(array, low, j);
		return j;
	}

	private static boolean compare(int i, int j) {
		return i < j ? true : false;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 12, 3, 5, 7, 4, 19, 26 };
		int k = 5;
		System.out.println(KthSmallestElement(array, 0, array.length - 1, k));
		System.out.println(Arrays.toString(array));
	}

}
