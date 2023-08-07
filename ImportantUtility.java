import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImportantUtility {
    // Universal Variables
    static BufferedReader br;

    // Main Method
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        processTestCases();
    }

    // Process Test Cases
    private static void processTestCases() throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            // TODO: Perform operations on the test case
        }
    }

    // Utility Method: Sort String
    public static String sortString(String inputString) {
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    // Utility Method: Check Prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Utility Method: Find Next Prime
    public static int nextPrime(int num) {
        if (num <= 1) {
            return 2;
        }
        num++;
        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }

    // Utility Method: Swap in Array
    private static void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    // Utility Method: Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Utility Method: Calculate Lowest Common Multiple
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    // Utility Method: Calculate Greatest Common Divisor
    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    // Utility Method: Fast Power Calculation
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
