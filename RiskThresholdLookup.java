public class RiskThresholdLookup {

    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index: " + i + " Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear Not Found Comparisons: " + comparisons);
        return -1;
    }

    static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;
        int comparisons = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println("Insertion Index: " + low + " Comparisons: " + comparisons);
        return low;
    }

    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] == target) {
                System.out.println("Floor: " + arr[mid] + " Comparisons: " + comparisons);
                return arr[mid];
            } else if (arr[mid] < target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + result + " Comparisons: " + comparisons);
        return result;
    }

    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] == target) {
                System.out.println("Ceiling: " + arr[mid] + " Comparisons: " + comparisons);
                return arr[mid];
            } else if (arr[mid] > target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Ceiling: " + result + " Comparisons: " + comparisons);
        return result;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};
        int target = 30;

        linearSearch(risks, target);
        binaryInsertionPoint(risks, target);
        floor(risks, target);
        ceiling(risks, target);
    }
}
