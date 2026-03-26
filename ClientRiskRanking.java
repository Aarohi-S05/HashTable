class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }
}

public class ClientRiskRanking {

    static void bubbleSortAscending(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void insertionSortDescending(Client[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].riskScore < key.riskScore ||
                    (arr[j].riskScore == key.riskScore &&
                     arr[j].accountBalance < key.accountBalance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void printTopN(Client[] arr, int n) {
        for (int i = 0; i < n && i < arr.length; i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 1000),
                new Client("clientA", 20, 500),
                new Client("clientB", 50, 800)
        };

        bubbleSortAscending(clients);
        for (Client c : clients) {
            System.out.print(c.name + ":" + c.riskScore + " ");
        }
        System.out.println();

        insertionSortDescending(clients);
        for (Client c : clients) {
            System.out.print(c.name + ":" + c.riskScore + " ");
        }
        System.out.println();

        printTopN(clients, 3);
    }
}
