package edu.grinnell.csc207.testing;

public class Functions {

	/**
	 * @param arr the input array
	 * @return the third greatest element of arr if it has at least three elements,
	 *         the greatest element of arr if it has two elements, and
	 *         the singleton element if it only has one element
	 * @throws IllegalArgumentException if the array is empty
	 */
	public static int thirdGreatest(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		} else if (arr.length == 1) {
			return arr[0];
		} else if (arr.length == 2) {
			return Math.max(arr[0], arr[1]);
		} else {
			int sum = arr[0] + arr[1] + arr[2];
			int g1 = Math.max(arr[0], Math.max(arr[1], arr[2]));
			int g3 = Math.min(arr[0], Math.min(arr[1], arr[2]));
			int g2 = sum - g1 - g3;
			for (int i = 3; i < arr.length; i++) {
				if (arr[i] > g1) {
					g3 = g2;
					g2 = g1;
					g1 = arr[i];
				}
				else if (arr[i] > g2) {
					g3 = g2;
					g2 = arr[i];
				}
				else if (arr[i] > g3) {
					g3 = arr[i];
				}
			}
			return g3;
		}
	}

	/**
	 * @param arr the input array
	 * sorts an integer array by using index as a divider between sorted and unsorted array sections
	 * @throws IllegalArgumentException if the array is empty
	 */
	public static void sort(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < (arr.length-1); i++) {
			if (arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
	}

	/**
	 * @params s, t are strings
	 * returns the index t starts at in s if t is a substring of s, otherwise returns -1
	 * @throws IllegalArgumentException if either string is null
	 */
	public static int substringIndex(String s, String t) {
		if ((s == null) || (t == null)) {
			throw new IllegalArgumentException();
		}
		if (s.length() < t.length()) {
			return -1;
		}
		for (int i = 0; i <= (s.length()-t.length()); i++) {
			if (s.substring(i, i+t.length()).equals(t)) {
				return i;
			}
		}
		return -1;
	}

	public static int lucas (int n) {
		// Initialize
		int prev = 2;
		int curr = 1;
		int nextLucasNumber = 0;
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 1;
		} else {
			for (int i=0; i < n-1; i++) {
				nextLucasNumber = prev + curr;
				prev = curr;
				curr = nextLucasNumber;
			}
			return curr;
		}
	}
}

