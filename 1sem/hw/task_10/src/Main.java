import core.DealLedger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DealLedger dealLedger = new DealLedger();
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner, dealLedger);
        ui.initiate();
    }
}
