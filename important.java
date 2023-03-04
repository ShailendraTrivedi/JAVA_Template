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
//		file = new File("/home/deependra/Code/Eclipse/JavaPractise/src/temp.txt");
//		br = new BufferedReader(new FileReader(file));

		br = new BufferedReader(new InputStreamReader(System.in));
		helper();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	// Write Up Area

	private static void helper() {
		try {
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				String[] strings = br.readLine().split(" ");
				if (n == 1)
					System.out.println("YES");
				else {
					Arrays.sort(strings);
					HashMap<String, Integer> map = new HashMap<>();
					for (String s : strings) {
						String str = sortString(s);
						map.put(str, map.getOrDefault(str, 0)+1);
					}
					boolean flag = true;
					for (int i : map.values()) {
						if(i%2!=0) {
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String sortString(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}

	public static int isPrime(int num) {
		int prime = 1;
		for (int i = 2; i < num; i++) {
			if ((num % i) == 0) {
				prime = 0;
			}
		}
		return num;
	}

	public static int nextPrime(int num) {
		num++;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				num++;
				i = 2;
			} else {
				continue;
			}
		}
		return num;
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
