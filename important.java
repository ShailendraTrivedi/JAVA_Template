import java.io.*;
import java.util.*;
import java.lang.*;

public class important {
	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Universal Variables

	static File file;
	static BufferedReader br;

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Main Method

	public static void main(String[] args) throws IOException {
		file = new File("/home/deependra/Code/Eclipse/JavaPractise/src/temp.txt");
		br = new BufferedReader(new FileReader(file));

		br = new BufferedReader(new InputStreamReader(System.in));
		helper();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Write Up Area

	private static void helper() {
		try {
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String[] strings = br.readLine().split(" ");
				int n = Integer.parseInt(strings[0]);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Swap in Array

	private static void swap(int[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Fast Sorting
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	private static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Lowest Common Factor

	private static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Highest Common Factor

	private static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Fast Power

	private static int fastPower(int a, int b, int n) {
		if (n == 0) {
			return 1 % b;
		}
		if (n == 1) {
			return a % b;
		}

		long recurPow = fastPower(a, b, n / 2);
		recurPow = (recurPow * recurPow) % b;

		if (n % 2 == 1) {
			recurPow = recurPow * a % b;
		}

		return (int) recurPow;
	}
}
