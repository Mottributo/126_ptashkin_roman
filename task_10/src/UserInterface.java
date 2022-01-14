import core.DealLedger;

import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    DealLedger dealLedger;
    UserInterface(Scanner scanner, DealLedger dealLedger) {
        System.out.println("Welcome to the Deal Management System!");
        this.scanner = scanner;
        this.dealLedger = dealLedger;
    }
    public void addDealDialogue(String state) {
        if (Objects.equals(state, "firstTime")) System.out.println("""
                To begin, make the first deal by entering it's name,
                then specify it's date in YYYYMMDD format:
                YYYY - year, from 0001 to 9999
                MM - month, from 01 to 12
                DD - day, from 01 to 31 or a different day depending on the month.
                An example - ACME 19920620
                """);
        System.out.print("Enter the ID: ");
        String id = scanner.next();
        System.out.print("Enter the date in YYYYMMDD format: ");
        String stringDate = scanner.next();
        try {
            this.dealLedger.addDeal(id, stringDate);
            System.out.println("Success!");
        }
        catch (Exception ex) {
            System.out.println(ex);
            if (Objects.equals(state, "firstTime")) addDealDialogue("exceptionRepeat");
        }
    }
    public void commandSelection(String state) {
        switch (state) {
            case "dealLedgerLevel" -> {
                System.out.println("""
                                Options:(0) Get the list of deals and their documents
                                (1) Get the list of deals only
                                (2) Select a deal
                                (3) Add a deal
                                (4) Remove a deal
                                """);
                System.out.print("Enter the number of a command: ");
                String entry = scanner.next();
                switch (entry) {
                    case "0" -> getTheTreeDialogue();
                    case "1" -> getDealListDialogue();
                    case "2" -> selectDealDialogue();
                    case "3" -> addDealDialogue("");
                    case "4" -> removeDealDialogue();
                    default -> {
                        System.out.print("Wrong entry. Enter a single number.");
                        commandSelection("dealLedgerLevel");
                    }
                }
            }
            case "dealLevel" -> {
                System.out.print("""
                        Options:
                        (0) Get the list of documents
                        (1) Select a document
                        (2) Add a document
                        (3) Remove a document
                        (4) Change the deal date
                        (5) Get into the main menu
                        """);
                System.out.print("Enter the number of a command: ");
            }
            case "documentLevel" -> {
                System.out.print("""
                        Options:
                        (0) Change the date
                        (1) Switch the type
                        (2) Change the payment
                        (4) Get into the deal menu
                        """);
                System.out.print("Enter the number of a command: ");
            }
        }
    }

}
