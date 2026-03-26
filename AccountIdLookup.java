import java.util.Arrays;

class Transaction {
    String accountId;

    Transaction(String accountId) {
        this.accountId = accountId;
    }
}

public class AccountIdLookup {

    static int linearSearchFirst(Transaction[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].accountId.equals(target)) {
                System.out.println("Linear First Index: " + i + " Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear First Index: -1 Comparisons: " + comparisons);
        return -1;
    }

    static int linearSearchLast(Transaction[] arr, String target) {
        int comparisons = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].accountId.equals(target)) {
                index = i;
            }
        }
        System.out.println("Linear Last Index: " + index + " Comparisons: " + comparisons);
        return index;
    }

    static int binarySearch(Transaction[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            int cmp = arr[mid].accountId.compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found Index: " + mid + " Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Found Index: -1 Comparisons: " + comparisons);
        return -1;
    }

    static int countOccurrences(Transaction[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);
        if (first == -1) return 0;
        return last - first + 1;
    }

    static int firstOccurrence(Transaction[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].accountId.equals(target)) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].accountId.compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int lastOccurrence(Transaction[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].accountId.equals(target)) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].accountId.compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static void sortTransactions(Transaction[] arr) {
        Arrays.sort(arr, (a, b) -> a.accountId.compareTo(b.accountId));
    }

    public static void main(String[] args) {
        Transaction[] logs = {
                new Transaction("accB"),
                new Transaction("accA"),
                new Transaction("accB"),
                new Transaction("accC")
        };

        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        sortTransactions(logs);

        for (Transaction t : logs) {
            System.out.print(t.accountId + " ");
        }
        System.out.println();

        binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("Count: " + count);
    }
}
